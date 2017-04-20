package fr.ul.miage.exemple;

import java.util.ArrayList;

public class Noeud {

    // TODO: se rappeler de l'interet...
    // private static int numeroNoeud = 0;
    public String cle, valeur;
    public ArrayList<Noeud> fils;

    public Noeud(String cle, String valeur) {
        this.cle = cle;
        this.valeur = valeur;
        this.fils = new ArrayList<>();
        // numeroNoeud++;
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
