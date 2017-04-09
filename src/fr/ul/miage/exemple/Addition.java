package fr.ul.miage.exemple;

public class Addition {

	public void genererAddition(String numeroRegistre1, String numeroRegistre2, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "ADD("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistreSortie+") \n";
	}
	
	public void genererAdditionConstante(String numeroRegistre1, int constante, String numeroRegistreSortie) {
		Assembleur.chaineAssembleur += "ADD("+numeroRegistre1+","+constante+","+numeroRegistreSortie+") \n";
	}
}