package fr.ul.miage.exemple;

public class Affect {

	public void genererAffectConstante(String variable, int valeur) {
		Assembleur.chaineAssembleur += variable + ": LONG("+valeur+") \n";
	}
	
	public void genererAffect(String numeroRegistre1, String numeroRegistre2) {
		Assembleur.chaineAssembleur += "MOV("+numeroRegistre2+","+numeroRegistre1+")";
	}
}