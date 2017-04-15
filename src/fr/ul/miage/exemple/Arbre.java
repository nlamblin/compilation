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
		for(Noeud no : n.fils) {
			String[] tab = new String[2];
			tab[0] = no.cle;
			tab[1] = no.valeur;
			this.liste_element.add(tab);
			
			if(no.fils.size() > 0){
				parcourirTousLesFils(no,tds);
			}
		}
	}
	
	public void afficherListeElement(TableDesSymboles tds) throws ParseException{
		for(String[] s : this.liste_element){
			String nom = "";
			String type = "";
			String valeur = "";
			String categorie = "";
			if(s[1] != null){
				if(s[0].equals("CONSTANTE")){
					nom = s[0];
					valeur = s[1];
				}else{
					nom = tds.getNom(s[1]);
					type = tds.getType(nom);
					valeur = tds.getValeur(nom);
					categorie = tds.getCategorie(nom, null);
				}
			}else{
				nom = s[0];
			}
			
			System.out.println(nom);
			
/*			switch (s[0]) {
			case "VAR" :
				Var v = new Var();
				// System.out.println(tds.getValeur(tds.getNom(tab[1])));
				v.genererVar(valeur);
			case "FUNCTION" : 
				System.out.println("identification d'une fonction");
			case "AFFECT" : 
				System.out.println("identification d'un affect");
				Affect a = new Affect();
				// a.genererAffect( je sais pas comment recuperer la variable , je sais pas comment recuperer la valeur);
			case "CONSTANTE" :
				System.out.println(valeur);
			default : 
				break;
			}
*/
			
//			System.out.println(s[0] + "   " + s[1]);
// 			System.out.println(nom + "  " + type + "   " + categorie + "  " + valeur);
		}
	}
	
}
