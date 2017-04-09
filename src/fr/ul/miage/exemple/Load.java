package fr.ul.miage.exemple;

public class Load {

	public void genererLoad(String variable, String numeroRegistre) {
		Assembleur.chaineAssembleur += "LD("+variable+","+numeroRegistre+")";
	}
}
