package fr.ul.miage.exemple;

public class Affect {

	public void genererAffectConstante(String variable, int valeur) {
		Assembleur.chaineAssembleur += variable + ": LONG("+valeur+") \n";
	}
}
