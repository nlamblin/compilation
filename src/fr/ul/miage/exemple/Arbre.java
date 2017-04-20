package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

import java.util.*;

public class Arbre {

    public Noeud racine;
    public ArrayList<String> liste_element;

    public Arbre() {
        this.racine = new Noeud("Program", null);
        this.liste_element = new ArrayList<>();
    }

    public void ajouterNoeud(Noeud n) {
        this.racine.fils.add(n);
    }

    public String afficher() {
        return this.racine.afficher(1) + "\n";
    }

    public void parcourirTousLesFils(Noeud n, TableDesSymboles tds) throws ParseException{

		for(Noeud no : n.fils){
			if(no.fils.size() > 0){
				this.liste_element.add(no.cle);
				parcourirTousLesFils(no,tds);
			}else{
				this.liste_element.add(no.cle);
			}
			
		}
		
	}
	
	
	public void afficherListeElement(TableDesSymboles tds) throws ParseException{
		for(String s : this.liste_element){
			System.out.println(s);
		}
	}
}
