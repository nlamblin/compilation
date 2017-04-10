package fr.ul.miage.exemple;

public class Affect {

	public void genererAffect(int variable, int valeur) {
		Assembleur.chaineAssembleur += variable + ": LONG("+valeur+") \n";
	}
}
