package fr.ul.miage.exemple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class Arbre {

	public Noeud racine;
	public ArrayList<Map<String, String[]>> liste_element;
	public Map<String, String[]> map;

	public Arbre() {
		this.racine = new Noeud("Program", null);
		this.liste_element = new ArrayList<>();
		this.map = new HashMap<>();
	}

	public void ajouterNoeud(Noeud n) {
		this.racine.fils.add(n);
	}

	public String afficher() {
		return this.racine.toString() + "\n";
	}

	public void parcourirTousLesFils(Noeud n, TableDesSymboles tds, int i, String parent) throws ParseException{
		String fils = "";
		int j = i;
		for (Noeud no : n.fils) {
			String[] tab = new String[2];
			if(no.cle.equals("FUNCTION")){
				parent = "" + i;
				String nom = tds.getNom(no.valeur);
				tab[0] = nom;
				String valeur = tds.getValeur(nom);
				tab[1] = valeur;
				this.map.put(parent, tab);
			}
			switch_parcours(no, tab, j, parent,tds);
			if(no.fils.size()>0){
				for (Noeud noe : no.fils) {
					String[] tab2 = new String[2];
					j = j + 1;
					fils = parent + j;
					switch_parcours(noe, tab2, j, fils, tds);			
				}
				j=0;
			}else{
				j++;
			}
			i = i + 1;
		}
		this.map = this.doSort(this.map);
	}

	public void switch_parcours(Noeud no, String[] tab, int i,String parent, TableDesSymboles tds) throws ParseException {
		String nom = "";
		String valeur = "";
		String fils = "";
		switch (no.cle) {
		case "AFFECT":
			tab[0] = no.cle;
			tab[1] = no.valeur;
			this.map.put(parent, tab);
			parcourirTousLesFils(no, tds, i, parent);
			break;
		case "CALL":

			break;
		case "CONSTANTE":
			fils = parent + i;
			tab[0] = no.cle;
			tab[1] = no.valeur;
			this.map.put(fils, tab);
			break;
		case "VAR":
			fils = parent + i;
			nom = tds.getNom(no.valeur);
			tab[0] = nom;
			valeur = tds.getValeur(nom);
			tab[1] = valeur;
			this.map.put(fils, tab);
			break;
		case "+":
			fils = parent + i;
			tab[0] = no.cle;
			tab[1] = no.valeur;
			this.map.put(fils, tab);
			parcourirTousLesFils(no, tds, 1, fils);
			break;
		case "-":

			break;
		case "/":
			fils = parent + i;
			tab[0] = no.cle;
			tab[1] = no.valeur;
			this.map.put(fils, tab);
			parcourirTousLesFils(no, tds, 1, fils);
			break;
		case "*":

			break;
		case "FUNC":

			break;
		}
	}

	public void afficherListeElement() throws ParseException {
		for (Map.Entry<String, String[]> e : this.map.entrySet()) {
			String val = "";
			if(e.getValue()[1] != null){
				val =" valeur :" + e.getValue()[1];
			}		
			System.out.println(e.getKey() + "  " + e.getValue()[0] + val);
		}
		/*
		 * switch (s[0]) { case "VAR" : Var v = new Var(); //
		 * System.out.println(tds.getValeur(tds.getNom(tab[1])));
		 * v.genererVar(valeur); case "FUNCTION" : System.out.println(
		 * "identification d'une fonction"); case "AFFECT" : System.out.println(
		 * "identification d'un affect"); Affect a = new Affect(); //
		 * a.genererAffect( je sais pas comment recuperer la variable , je sais
		 * pas comment recuperer la valeur); case "CONSTANTE" :
		 * System.out.println(valeur); default : break; }
		 */

		// System.out.println(s[0] + " " + s[1]);
		// System.out.println(nom + " " + type + " " + categorie + " " +
		// valeur);
	}

	public Map<String, String[]> doSort(Map<String, String[]> map) {
		Comparator<String> comparator = new KeyComparator<String>();
		Map<java.lang.String, java.lang.String[]> sortedMap = new TreeMap<String, String[]>(comparator);
		sortedMap.putAll(map);
		return sortedMap;
	}

	public class KeyComparator<String> implements Comparator<String> {

		@Override
		public int compare(String sourceKey, String targetKey) {
			return ((java.lang.String) sourceKey).compareTo((java.lang.String) targetKey);
		}

	}

}
