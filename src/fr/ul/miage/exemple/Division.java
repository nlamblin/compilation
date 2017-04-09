package fr.ul.miage.exemple;

public class Division {

	public void genererDivision(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "DIV("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+") \n";
	}
	
	public void genererDivisionConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "DIV("+numeroRegistre1+","+constante+","+numeroRegistreSortie+") \n";
	}
}
