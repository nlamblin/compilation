package fr.ul.miage.exemple;

public class Br {
	
	public void genererBr(String numeroRegistre, String intitule) {
		Assembleur.chaineAssembleur += "BR("+numeroRegistre+","+intitule+") \n";
	}

}
