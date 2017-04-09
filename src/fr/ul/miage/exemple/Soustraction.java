package fr.ul.miage.exemple;

public class Soustraction {

	public void genererSoustraction(String numeroRegistre1, String numeroRegistre2, String numeroResigtreSortie) {
		Assembleur.chaineAssembleur += "SUB("+numeroRegistre1+","+numeroRegistre2+","+numeroResigtreSortie+") \n";
	}
	
	public void genererSoustractionConstante(String numeroRegistre1, int constante, String numeroResigtreSortie) {
		Assembleur.chaineAssembleur += "SUBC("+numeroRegistre1+","+constante+","+numeroResigtreSortie+") \n";
	}
}
