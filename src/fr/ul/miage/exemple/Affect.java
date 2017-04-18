package fr.ul.miage.exemple;

public class Affect {

	public void genererAffect(String numeroRegistre1, String numeroRegistre2) {
		Assembleur.chaineAssembleur += "MOV("+numeroRegistre2+","+numeroRegistre1+") \n";
	}
	
	public void genererAffectConstante(String numeroRegistre, int constante) {
		Assembleur.chaineAssembleur += "CMOVE("+constante+","+numeroRegistre+") \n";
	}
}