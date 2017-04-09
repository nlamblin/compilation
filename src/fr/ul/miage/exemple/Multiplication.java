package fr.ul.miage.exemple;

public class Multiplication {

	public void genererMultiplication(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "MUL("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+")";
	}
	
	public void genererMultiplicationConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "MUL("+numeroRegistre1+","+constante+","+numeroRegistreSortie+")";
	}
}