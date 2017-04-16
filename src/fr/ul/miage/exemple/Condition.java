package fr.ul.miage.exemple;

public class Condition {
	
	public void genererConditionEgale(String numeroRegsitre1, String numeroRegistre2, String numeroRegistre3) {
		Assembleur.chaineAssembleur += "CMPEQ("+numeroRegsitre1+","+numeroRegistre2+","+numeroRegistre3+")";
	}
	
	public void genererConditionInf(String numeroRegistre1, String numeroRegistre2, String numeroRegistre3) {
		Assembleur.chaineAssembleur += "CMPLE("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistre3+")";
	}
	
	public void genererConditionInfEgale(String numeroRegistre1, String numeroRegistre2, String numeroRegistre3) {
		Assembleur.chaineAssembleur += "CMPLT("+numeroRegistre1+","+numeroRegistre2+","+numeroRegistre3+")";
	}

}