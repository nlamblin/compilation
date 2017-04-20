package fr.ul.miage.exemple;

import java.util.HashMap;
import java.util.Stack;

public class Assembleur {

	/**
	 * chaine permettant de stocker le code assembleur générer
	 */
	public String chaineAssembleur;
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
		this.chaineAssembleur = ".include beta.asm \n";
		this.mapGestionRegistre = new HashMap<>();
		this.pileValeurRegistre = new Stack<>();
		
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
	
	
	
	/**************************************************************
	 * 
	 * 
	 * CODE ASSEMBLEUR
	 *
	 *
	 *************************************************************/
	
	public void genererIntitule(String intitule) {
		this.chaineAssembleur += intitule+": \t";
	}
	
	public void genererVar(String var) {
		this.chaineAssembleur += var + ": LONG(0) \n";
	}
	
	public void genererLoad(String variable, String numeroRegistre) {
		this.chaineAssembleur += "LD("+variable+","+numeroRegistre+") \n";
	}
	
	public void genererPop(String numeroRegistre){
		this.chaineAssembleur += "POP("+numeroRegistre+") \n";
	}
	
	public void genererCall(String intitule) {
		this.chaineAssembleur += "CALL("+intitule+") \n";
	}
	
	public void genererAffect(String numeroRegistre1, String numeroRegistre2) {
		this.chaineAssembleur += "MOV("+numeroRegistre2+","+numeroRegistre1+") \n";
	}
	
	public void genererAffectConstante(String numeroRegistre, int constante) {
		this.chaineAssembleur += "CMOVE("+constante+","+numeroRegistre+") \n";
	}
	
	public void genererAddition(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		this.chaineAssembleur += "ADD("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+") \n";
	}
	
	public void genererAdditionConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		this.chaineAssembleur += "ADD("+numeroRegistre1+","+constante+","+numeroRegistreSortie+") \n";
	}
	
	public void genererSoustraction(String numeroRegistre1, String numeroRegistre2, String numeroResigtreSortie) {
		this.chaineAssembleur += "SUB("+numeroRegistre1+","+numeroRegistre2+","+numeroResigtreSortie+") \n";
	}
	
	public void genererSoustractionConstante(String numeroRegistre1, int constante, String numeroResigtreSortie) {
		this.chaineAssembleur += "SUBC("+numeroRegistre1+","+constante+","+numeroResigtreSortie+") \n";
	}
	
	public void genererMultiplication(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		this.chaineAssembleur += "MUL("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+") \n";
	}
	
	public void genererMultiplicationConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		this.chaineAssembleur += "MUL("+numeroRegistre1+","+constante+","+numeroRegistreSortie+") \n";
	}
	
	public void genererDivision(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		this.chaineAssembleur += "DIV("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+") \n";
	}
	
	public void genererDivisionConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		this.chaineAssembleur += "DIV("+numeroRegistre1+","+constante+","+numeroRegistreSortie+") \n";
	}
	
	public void genererConditionEgale(String numeroRegsitre1, String numeroRegistre2, String numeroRegistre3) {
		this.chaineAssembleur += "CMPEQ("+numeroRegsitre1+","+numeroRegistre2+","+numeroRegistre3+") \n";
	}
	
	public void genererConditionInf(String numeroRegistre1, String numeroRegistre2, String numeroRegistre3) {
		this.chaineAssembleur += "CMPLE("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistre3+") \n";
	}
	
	public void genererConditionInfEgale(String numeroRegistre1, String numeroRegistre2, String numeroRegistre3) {
		this.chaineAssembleur += "CMPLT("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistre3+") \n";
	}
	
	public void genererBf(String intitule) {
		this.chaineAssembleur += "BF("+intitule+") \n";
	}
	
    public void genererBr(String numeroRegistre, String intitule) {
        this.chaineAssembleur += "BR(" + numeroRegistre + "," + intitule + ") \n";
    }
    
	public void genererHalt() {
		this.chaineAssembleur += "Halt() \n";
	}
}
