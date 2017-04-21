package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class TableDesSymboles {

    //	this.table[i][0] = ID
//	this.table[i][1] = nom;
//	this.table[i][2] = type;
//	this.table[i][3] = categorie  (globale/interne/fonction);
//	this.table[i][4] = valeur
//	this.table[i][5] = nbparametre
    public String table[][];

    //Definit la place de la variable dans le tableau
    public static int indice;


    public TableDesSymboles() {
        this.table = new String[30][7];

        this.table[this.table.length - 1][0] = "" + (int) (this.table.length - 1);
        this.table[this.table.length - 1][1] = "read";
        this.table[this.table.length - 1][2] = "String";
        this.table[this.table.length - 1][3] = "fonction";
        this.table[this.table.length - 1][4] = null;
        this.table[this.table.length - 1][5] = "0";

        this.table[this.table.length - 2][0] = "" + (int) (this.table.length - 2);
        this.table[this.table.length - 2][1] = "write";
        this.table[this.table.length - 2][2] = "void";
        this.table[this.table.length - 2][3] = "fonction";
        this.table[this.table.length - 2][4] = null;
        this.table[this.table.length - 2][5] = "0";

        this.table[this.table.length - 3][0] = "" + (int) (this.table.length - 2);
        this.table[this.table.length - 3][1] = "print";
        this.table[this.table.length - 3][2] = "void";
        this.table[this.table.length - 3][3] = "fonction";
        this.table[this.table.length - 3][4] = null;
        this.table[this.table.length - 3][5] = "0";
    }

    /**
     * Fonction qui test si l'element est pr�sent ou non
     *
     * @param nom
     * @return
     * @throws ParseException
     */
    public boolean estPresent(String nom) throws ParseException {
        boolean res = false;

        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][1] != null) {
                if (this.table[i][1].equals(nom)) {
                    res = true;
                    this.indice = i;
                }
            }
            if (res) {
                break;
            }
        }
        return res;
    }

    /**
     * Fonction qui insere une variable ou une fonction
     *
     * @param nom
     * @param type
     * @param categorie
     * @param value
     * @throws ParseException
     */
    public void inserer(String nom, String type, String categorie) throws ParseException {
        if (this.estPresent(nom)) {

            //Variable globale et locale ne peuvent pas avoir le m�me nom
            if ((this.table[this.indice][3].equals("globale") || this.table[this.indice][3].equals("interne")
                    || this.table[this.indice][3].equals("fonction")) && this.table[this.indice][3].equals(categorie)) {
                throw new ParseException("Double d�finition " + type + " : " + nom);
            }
        } else if (!this.estPresent(nom)) {
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i][1] == null) {
                    this.table[i][0] = "" + i;
                    this.table[i][1] = nom;
                    this.table[i][3] = categorie;
                    if (type != null) {
                        this.table[i][2] = type;
                        if (type.equals("VAR")) {
                            this.table[i][4] = "0";
                            this.table[i][5] = "/";
                        }
                    } else {
                        this.table[i][2] = null;
                    }


                    break;
                }
            }
        }
    }

    public void ajouterParametre(String nom, String value) throws ParseException {
        if (this.estPresent(nom)) {
            this.table[this.indice][5] = value;
        } else {
            throw new ParseException(nom + " n'as pas �t� d�fini");
        }
    }

    public void ajouterType(String nom, String value) throws ParseException {
        if (this.estPresent(nom)) {
            this.table[this.indice][2] = value;
        } else {
            throw new ParseException(nom + " n'as pas �t� d�fini");
        }
    }


    public void ajouterValeur(String nom, String value) throws ParseException {
        if (this.estPresent(nom)) {
            this.table[this.indice][4] = value;
        } else {
            throw new ParseException(nom + " n'as pas �t� d�fini");
        }
    }

    public String getValeur(String nom) throws ParseException {
        String res = null;
        if (this.estPresent(nom)) {
            res = this.table[this.indice][4];
        } else {
            throw new ParseException(nom + " n'as pas �t� d�fini");
        }
        return res;
    }


    public String getType(String nom) throws ParseException {
        String res = null;
        if (this.estPresent(nom)) {
            res = this.table[this.indice][2];
        } else {
            throw new ParseException(nom + " n'as pas �t� d�fini");
        }
        return res;
    }

    public int getId(String nom, String type) throws ParseException {
        int i = 0;
        if (estPresent(nom)) {
            i = this.indice;
        } else {
            if (type != null)
                throw new ParseException(nom + " n'a pas �t� d�fini.");
        }

        return i;
    }

    public String getCategorie(String nom, String type) throws ParseException {
        int i = 0;
        String res = null;
        if (estPresent(nom)) {
            i = this.indice;
            res = this.table[i][3];
        } else {
            if (type != null)
                throw new ParseException(nom + " n'a pas �t� d�fini.");
        }

        return res;
    }

    public String getNom(String id) throws ParseException {
        if (verificationId(id)) {
            return id;
        }
        int i = Integer.parseInt(id);

        return this.table[i][1];
    }

    public String toString() {
        String res = "Table des symboles : \n";
        res += "id" + " | " + "nom" + " | " + "type" + " | " + "categorie" + " | " + " valeur " + " | " + "parametre" + "\n";
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][0] != null) {
                res += this.table[i][0] + " | " + this.table[i][1] + " | " + this.table[i][2] + " | " +
                        this.table[i][3] + " | " + this.table[i][4] + " | " + this.table[i][5] + "\n";
            }
        }

        res += "\n" + "Compilation du code : ok.";

        return res;
    }

    public boolean verificationId(String id) {
        return id.equals("AFFECT") || id.equals("FUNCTION") || id.equals("CALL") || id.equals("+")
                || id.equals("-") || id.equals("/") || id.equals("*");
    }

    public void verificationFonctionMain() throws ParseException {
        boolean trouve = false;

        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i][1].equals("main")) {
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            throw new ParseException("Erreur ! Pas de fonction main");
        }
    }
}
