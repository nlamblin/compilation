package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class TableDesSymboles{
	
	//Table[i][0] = nom
	//Table[i][1] = categorie
	//Table[i][2] = type
	//Table[i][3] = value
	private String table[][];
	
	//Definit la place de la variable dans le tableau
	public static int indice;
	
	
	public TableDesSymboles(){
		this.table = new String [10][4];
	}
	
	/**
	 * Fonction qui test si l'element est présent ou non
	 * @param nom
	 * @return
	 */
	public boolean estPresent(String nom){
		boolean res = false;
		
		for(int i = 0; i < this.table.length; i++){
			if(this.table[i][0] != null){
				if(this.table[i][0].equals(nom)){
					res = true;
					this.indice = i;
				}
			}
			if(res){
				break;
			}
		}
		return res;
	}
	
	/**
	 * Fonction qui insere une variable ou une fonction
	 * @param nom
	 * @param type
	 * @param categorie
	 * @param value
	 * @throws ParseException
	 */
	public void inserer(String nom, String type, String categorie) throws ParseException{
		if(this.estPresent(nom)){
			//Variable globale et locale ne peuvent pas avoir le même nom
			if(this.table[this.indice][2].equals("variable")){
				throw new ParseException("Une variable porte déjà ce nom : " + nom);
			}else if(this.table[this.indice][2].equals("fonction")){
				throw new ParseException("Une fonction porte déjà ce nom : " + nom);
			}
		}else{
			for(int i = 0; i < this.table.length; i++){
				if(this.table[i][0] == null){
					this.table[i][0] = nom;
					this.table[i][1] = type;
					this.table[i][2] = categorie;
					break;
				}
			}
		}
	}
	
	public void ajouterValeur(String nom, String value){
		if(this.estPresent(nom)){
			this.table[this.indice][3] = value;
		}
	}
	
	public String getValeur(String nom){
		String res = null;
		if(this.estPresent(nom)){
			res = this.table[this.indice][3];
		}
		return res;
	}
	
	
	public String toString(){
		String res ="nom varibale" + " | " + "type" + " | " + "categorie" + " | " + " valeur " + "\n";
		for(int i = 0; i < this.table.length; i++){
			if(this.table[i][0] !=null){
				res += this.table[i][0] + " | " +this.table[i][1]  + " | " + this.table[i][2] +" | "  + this.table[i][3] + " " +"\n";
			}
		}
		return res;
	}
}
