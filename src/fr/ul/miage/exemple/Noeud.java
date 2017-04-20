package fr.ul.miage.exemple;

import java.util.ArrayList;

public class Noeud {

    public static int numeroNoeud = 0;
    public String cle, valeur;
    public ArrayList<Noeud> fils;

    public Noeud(String c, String v) {
        this.cle = c;
        this.valeur = v;
        this.fils = new ArrayList<>();
        this.numeroNoeud++;
    }

    public void setCle(String c) {
        this.cle = c;
    }

    public void setValeur(String v) {
        this.valeur = v;
    }

    public String afficher(int niveau) {
        String val = (this.valeur == null) ? "" : " : " + this.valeur;
        String res = "< " + this.cle + val + " >";

        if (!this.fils.isEmpty()) {
            String tabNiveau = "";
            for (int i = 0; i < niveau - 1; i++)
                tabNiveau += "\t";

            for (Noeud noeud : this.fils)
                res += "\n" + tabNiveau + "\t" + noeud.afficher(niveau + 1);

            res += "\n" + tabNiveau + "< fin " + this.cle + " >";
        }
        return res;
    }
}
