package fr.ul.miage.exemple;

import java.util.HashMap;
import java.util.Stack;

public class Assembleur {

	/**
	 * chaine permettant de stocker le code assembleur générer
	 */
	public static String chaineAssembleur;
	/**
	 * Hashhap permettant de stocker les variables et le registre leur correspondant
	 */
	public HashMap<String, String> mapGestionRegistre;
	/**
	 * pile stockant l'ensemble des intitulés des registres qui ne sont pas encore utilisés
	 */
	public Stack<String> pileValeurRegistre;
	
	/**
	 * Constructeur
	 */
	public Assembleur() {
		this.chaineAssembleur = "";
		this.mapGestionRegistre = new HashMap<>();
		
		// remplissage de la pile avec les intitulés des registres
		this.pileValeurRegistre.add("R31");
		this.pileValeurRegistre.add("XP");
		this.pileValeurRegistre.add("SP");
		this.pileValeurRegistre.add("LP");
		this.pileValeurRegistre.add("BP");
		
		for(int i = 26; i >= 0; i--) {
			this.pileValeurRegistre.add("R"+i);
		}

	}
	
	/**
	 * recherche la première place vide dans les registres
	 * @return la première place vide
	 * @throws PlusDePlaceEnRegistre, indique qu'il n'y a plus de place de libre
	 */
	public String chercherPlaceVide() throws PlusDePlaceEnRegistre {
		// si la liste n'est pas vide alors on prend le registre libre
		// qui est le premier dans la liste
		if(this.pileValeurRegistre.empty()) {
			throw new PlusDePlaceEnRegistre();
		}
		else {
			return this.pileValeurRegistre.get(0);
		}
	}
	
	/**
	 * ajoute en registre (à la premiere libre) la valeur 
	 * @param valeur, valeur à ajouter au registre
	 * @throws PlusDePlaceEnRegistre
	 */
	public void ajouterUnRegistre(String valeur) throws PlusDePlaceEnRegistre {
		String numeroRegistre = chercherPlaceVide();
		// on supprime la premiere valeur de la pile puisque le registre ne va plus etre libre
		this.pileValeurRegistre.remove(numeroRegistre);
		this.mapGestionRegistre.put(valeur, numeroRegistre);
		
		/*
		* Load l = new Load();
		* l.genererLoad(valeur, numeroRegistre);
		*/
	}
	
	/**
	 * supprime un registre des registres utilisés 
	 * @param cle, entrée à supprimer dans la hashmap puisque le registre n'est plus utilisé
	 */
	public void supprimerUnRegistre(String cle) {
		// puisqu'on supprime le registre des registres utilisés on le rajoute dans la liste des registres libres
		this.pileValeurRegistre.add(this.mapGestionRegistre.get(cle));
		this.mapGestionRegistre.remove(cle);

	}
	
	/**
	 * recupere le numero du registre à partir d'une valeur donnée
	 * @param  cle, cle dont on recherche le registre
	 * @return le numero du registret
	 * @throws VariableInexistanteDansRegistre
	 */
	public String recupererRegistre(String cle) {
		return this.mapGestionRegistre.get(cle);
	}
}
