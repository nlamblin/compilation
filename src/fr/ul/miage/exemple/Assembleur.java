package fr.ul.miage.exemple;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;

public class Assembleur {
	
	public TableDesSymboles tds;
	public int nbWhile;
	public int nbIf;
	
	/**
	 * Constructeur
	 */
	public Assembleur() {
		this.nbWhile = 0;
		this.nbIf = 0;
	}
	
	/*
	 * CODE ASSEMBLEUR
	 */
	
	public String genererProgramme(Noeud racine, TableDesSymboles tds) throws ParseException {
		this.tds = tds;
		
		String res = ".include beta.asm \n"
				+ "CMOVE(pile,SP) \n "
				+ "CALL(main) \n "
				+ "HALT() \n"
				+ genererData(tds) + "\n"
				+ genererCode(racine);
		
		return res;
	}
	
	public String genererData(TableDesSymboles tds) {
		String res = "data : \n";
		String [][] table = tds.table;
		// parcours de la table des symboles
		for (int i = 0; i < table.length; i++) {
			// si la catégorie de l'élément courant est globale
			if(table[i][3].equals("globale")) {
				res += "\t" + table[i][1] + ": LONG("+table[i][4]+") \n";
			}
		}
		
		return res;
	}
	
	public String genererCode(Noeud racine) throws ParseException {
		String res = "code : \n";
		// parcours de tous les fils
		for(Noeud n : racine.fils) {
			res += genererFonction(n);
		}
		
		return res;
	}
	
	public String genererFonction(Noeud noeud) throws ParseException {
		String res = "";
		for(Noeud n : noeud.fils) {
			res += genererInstructions(n);
		}
		
		return res;
	}
	
	/*public String genererReturn(Noeud noeud) {
		String res = "";
		
		if(noeud.fils.size() == 0) {
			int b = (tds.table[tds.getId(tds.getNom(noeud.cle), "INT")][5] - 2) * 4;
			
			res += genererExpression(noeud.fils)
					+ "POP(R0)"
					+ "PUTFRAME(R0, b)";
		}
		res += "";
			
		return res;
	}*/
	
	public String genererInstructions(Noeud noeud) throws ParseException {
		String res = "";
	
		switch(noeud.cle) {
		case "AFFECT" : 
			res += genererAffectation(noeud);
			break;
		/*case "RETURN" :
			res += genererReturn(noeud);
			break;*/
		case "WHILE" : 
			res += genererWhile(noeud);
			break;
		default :
			break;
		}
		
		return res;
	}
	
	public String genererAffectation(Noeud noeud) throws ParseException {
		String res = genererExpression(noeud.fils.get(1));
		res += "POP(R0) \n"
				+ "ST(R0, " + this.tds.getValeur(this.tds.getNom(noeud.fils.get(0).valeur) + " \n");
	
		return res;
	}
	
	public String genererExpression(Noeud noeud) throws ParseException {
		String res = "";
		
		switch(noeud.cle) {
		case "CONSTANTE" :
			res += "CMOVE("+ this.tds.getValeur(this.tds.getNom(noeud.fils.get(0).valeur)) +", R0) \n"
					+ "PUSH(R0) \n";
			break;
		case "VAR" :
			res += "LD("+this.tds.getValeur(this.tds.getNom(noeud.fils.get(0).valeur))+", R0) \n"
					+ "PUSH(R0) \n";
			break;
		case "+" :
			res += genererExpression(noeud.fils.get(0)) + "\n"
					+ genererExpression(noeud.fils.get(1)) + "\n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "ADD(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
			break;
		case "-" :
			res += genererExpression(noeud.fils.get(0)) + "\n"
					+ genererExpression(noeud.fils.get(1)) + "\n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "SUB(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
			break;
		case "*" :
			res += genererExpression(noeud.fils.get(0)) + "\n"
					+ genererExpression(noeud.fils.get(1)) + "\n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "MUL(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
			break;
		case "/" :
			res += genererExpression(noeud.fils.get(0)) + "\n"
					+ genererExpression(noeud.fils.get(1)) + "\n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "DIV(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
			break;
		}
		
		return res;
	}
	
	public String genererCondition(Noeud noeud) throws ParseException {
		String res = "";
		
		switch (noeud.cle) {
		case "<":
			res += genererExpression(noeud.fils.get(0)) + " \n"
				+ genererExpression(noeud.fils.get(0)) + " \n"
				+ "POP(R2) \n"
				+ "POP(R1) \n"
				+ "CMPLT(R1,R2,R0) \n"
				+ "PUSH(R0) \n";
			break;
		case ">" :
			res += genererExpression(noeud.fils.get(0)) + " \n"
					+ genererExpression(noeud.fils.get(0)) + " \n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "CMPLT(R2,R1,R0) \n"
					+ "PUSH(R0) \n";
				break;
		case "<=" :
			res += genererExpression(noeud.fils.get(0)) + " \n"
					+ genererExpression(noeud.fils.get(0)) + " \n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "CMPLE(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
				break;
		case ">=" :
			res += genererExpression(noeud.fils.get(0)) + " \n"
					+ genererExpression(noeud.fils.get(0)) + " \n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "CMPLE(R2,R1,R0) \n"
					+ "PUSH(R0) \n";
				break;
		case "=" :
			res += genererExpression(noeud.fils.get(0)) + " \n"
					+ genererExpression(noeud.fils.get(0)) + " \n"
					+ "POP(R2) \n"
					+ "POP(R1) \n"
					+ "CMPEQ(R1,R2,R0) \n"
					+ "PUSH(R0) \n";
				break;
		case "!=" :
			res += genererExpression(noeud) + " \n"
					+ genererExpression(noeud.fils.get(0)) + " \n"
					+ "POP(R0) \n"
					+ "CMOVE(0, R1) \n"
					+ "CMPEQ(R0,R1,R2) \n"
					+ "PUSH(R2) \n";
				break;
		default:
			break;
		}
		
		return res;
	}
	
	public String genererIf(Noeud noeud) throws ParseException {
		int n = this.nbIf++;
		String res = genererCondition(noeud.fils.get(0)) + " \n";
		
		res += "POP(R0) \n"
				+ "BF(R0, else_"+n+ ") \n"
				+ genererBloc(noeud.fils.get(1))
				+ "BR(fsi_"+n+") \n"
				+ "else_"+n+": \t"
				+ genererBloc(noeud.fils.get(2))
				+ "fsi_"+n+": \n";
		
		return res;
	}
	
	public String genererWhile(Noeud noeud) throws ParseException {
		int n = this.nbWhile++;
		
		String res = genererCondition(noeud.fils.get(0));
		res += "POP(R0) \n"
				+ "BF(R0, done_"+n+") \n"
				+ genererBloc(noeud.fils.get(1))
				+ "BF(R0, while_"+n+") \n"
				+ "done_"+n;
		return res;
	}
	
	public String genererBloc(Noeud noeud) throws ParseException {
		String res = "";
		
		for(Noeud n : noeud.fils) {
			res += genererInstructions(n);
		}
		
		return res;
	}
	
}
