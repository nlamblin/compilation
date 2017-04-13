package fr.ul.miage.exemple;

import java.util.ArrayList;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class Arbre{
	
	public Noeud racine;
	public ArrayList<String[]> liste_element;
	
	public Arbre(){
		this.racine = new Noeud("Program", null);
		this.liste_element = new ArrayList<>();
	}
	
	public void ajouterNoeud(Noeud n){
		this.racine.fils.add(n);
	}
	
	
	public String afficher(){
		return this.racine.toString()+"\n";
	}
	
	
	public void parcourirTousLesFils(Noeud n, TableDesSymboles tds) throws ParseException{

		for(Noeud no : n.fils){
			if(no.fils.size() > 0){
				String[] tab = new String[2];
				tab[0] = no.cle;
				tab[1] = no.valeur;
				this.liste_element.add(tab);
				parcourirTousLesFils(no,tds);
			}else{
				String[] tab = new String[2];
				tab[0] = no.cle;
				tab[1] = no.valeur;
				this.liste_element.add(tab);
			}
		}
		
	}
	
	
	public void afficherListeElement(TableDesSymboles tds) throws ParseException{
		for(String[] s : this.liste_element){
			System.out.println(s[0]+ "   "  + s[1]);
		}
	}
	
}
