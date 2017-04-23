package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Assembleur {

    private TableDesSymboles tds;
    private int nbWhile;
    private int nbIf;

    /**
     * Constructeur
     */
    public Assembleur() {
        this.nbWhile = 0;
        this.nbIf = 0;
    }

    public void genererFichier(String chaine) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("assembleur.txt")));
            writer.write(chaine);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
     * CODE ASSEMBLEUR
	 */

    public String genererProgramme(Noeud racine, TableDesSymboles tds) throws ParseException {
        this.tds = tds;

        String res = ".include beta.uasm \n"
                + "CMOVE(pile,SP) \n "
                + "CALL(main) \n "
                + "HALT() \n"
                + genererData(tds) + "\n"
                + genererCode(racine)
                + "pile:\n";

        return res;
    }

    private String genererData(TableDesSymboles tds) {
        String res = "data : \n";
        String[][] table = tds.table;
        // parcours de la table des symboles
        for (int i = 0; i < table.length; i++) {
            // si la catégorie de l'élément courant est globale
            if (table[i][0] != null && table[i][3].equals("globale")) {
                res += "\t" + table[i][1] + ": LONG(" + table[i][4] + ") \n";
            }
        }

        return res;
    }

    private String genererCode(Noeud racine) throws ParseException {
        String res = "code : \n";
        // parcours de tous les fils
        for (Noeud n : racine.fils) {
            res += genererFonction(n);
        }

        return res;
    }

    private String genererFonction(Noeud noeud) throws ParseException {
        String res = "\n" + tds.getNom(noeud.valeur) + ": \n";
        for (Noeud n : noeud.fils) {
            res += genererInstructions(n);
        }
        res += "fin_" + tds.getNom(noeud.valeur) + ": \n\n";

        return res;
    }

    private String genererInstructions(Noeud noeud) throws ParseException {
        String res = "";

        switch (noeud.cle) {
            case "AFFECT":
                res += genererAffectation(noeud);
                break;
            case "RETURN":
                res += genererReturn(noeud);
                break;
            case "WHILE":
                res += genererWhile(noeud);
                break;
            case "IF":
                res += genererIf(noeud);
                break;
            default:
                break;
        }

        return res;
    }

    private String genererAffectation(Noeud noeud) throws ParseException {
        String res = genererExpression(noeud.fils.get(1));

        res += "POP(R0) \n"
                + "ST(R0," + this.tds.getNom(noeud.fils.get(0).valeur) + ") \n";
        return res;
    }

    private String genererExpression(Noeud noeud) throws ParseException {
        String res = "";

        switch (noeud.cle) {
            case "CONSTANTE":
                res += "CMOVE(" + noeud.valeur + ", R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "VAR":
                res += "LD(" + this.tds.getNom(noeud.valeur) + ", R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "+":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(1))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "ADD(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "-":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(1))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "SUB(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "*":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(1))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "MUL(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "/":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(1))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "DIV(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
        }
        return res;
    }

    private String genererReturn(Noeud noeud) throws ParseException {
        String res = "";

        if (noeud.fils.isEmpty()) {
            // pas sur du tout de ça
            int b = (tds.getParametre(tds.getNom(noeud.valeur)) - 2) * 4;

            // trouver un moyen mais pas changer genererExpression !!!
            res += genererExpression(noeud.fils.get(0))
                    + "POP(R0) \n"
                    + "PUTFRAME(R0, " + b + ") \n";
        }
        return res;
    }

    private String genererWhile(Noeud noeud) throws ParseException {
        this.nbWhile++;
        String res = "\nwhile_" + this.nbWhile + ": \n"
                + genererCondition(noeud.fils.get(0))
                + "POP(R0) \n"
                + "BF(R0, done_" + this.nbWhile + ") \n"
                + genererBloc(noeud.fils.get(1))
                + "BF(R0, while_" + this.nbWhile + ") \n"
                + "done_" + this.nbWhile + ": \n\n";
        return res;
    }

    private String genererIf(Noeud noeud) throws ParseException {
        this.nbIf++;
        String res = "\nif_" + this.nbIf + ": \n"
                + genererCondition(noeud.fils.get(0))
                + "POP(R0) \n"
                + "BF(R0, else_" + this.nbIf + ") \n"
                + genererBloc(noeud.fils.get(1))
                + "BR(fsi_" + this.nbIf + ") \n"
                + "\nelse_" + this.nbIf + ": \n"
                + genererBloc(noeud.fils.get(2))
                + "fsi_" + this.nbIf + ": \n\n";
        return res;
    }

    private String genererCondition(Noeud noeud) throws ParseException {
        String res = "";

        System.out.println(noeud.fils.get(1).cle);
        switch (noeud.fils.get(1).cle) {
            case "<":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPLT(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case ">":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPLT(R2,R1,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "<=":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPLE(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case ">=":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPLE(R2,R1,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "=":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPEQ(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            case "!=":
                res += genererExpression(noeud.fils.get(0))
                        + genererExpression(noeud.fils.get(2))
                        + "POP(R2) \n"
                        + "POP(R1) \n"
                        + "CMPEQ(R1,R2,R0) \n"
                        + "PUSH(R0) \n";
                break;
            default:
                break;
        }
        return res;
    }

    private String genererBloc(Noeud noeud) throws ParseException {
        String res = "";

        for (Noeud n : noeud.fils) {
            res += genererInstructions(n);
        }

        return res;
    }
}