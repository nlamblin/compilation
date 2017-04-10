package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class Arbre{
	
	public Noeud racine;
	
	public Arbre(){
		this.racine = new Noeud("Program", null);
	}
	
	public void ajouterNoeud(Noeud n){
		this.racine.fils.add(n);
	}
	
	
	public String afficher(){
		return this.racine.toString()+"\n";
	}
	
	
	public String parcourirTousLesFils(Noeud n, TableDesSymboles tds) throws ParseException{
		String res = "";
		for(Noeud noeud : n.fils){
			System.out.println(noeud.cle);
			parcourirTousLesFils(noeud,tds);
		}
		return res;
	}
	
}
