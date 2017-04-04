package fr.ul.miage.exemple;

import java.util.ArrayList;

public class Noeud {

	public static int numeroNoeud = 0;
	public String cle, valeur;
	public ArrayList<Noeud> fils;
	
	public Noeud(String c, String v){
		this.cle = c;
		this.valeur = v;
		this.fils = new ArrayList<>();
		this.numeroNoeud++;
	}
	
	public void setCle(String c){
		this.cle = c;
	}
	
	public void setValeur(String v){
		this.valeur = v;
	}
	
	public String toString(){
		String res = "-";
		String val = "";
		if(this.valeur == null){
			val="$";
		}else{
			val = this.valeur;
		}
		res += "||"+this.cle + "|" +val+"||";
		
		if(this.fils.size() > 0){
			res += "\n";
			for(Noeud n : this.fils){
				int nb_esp = 1;
				for(int j = 0; j<nb_esp;j++){					
					res += "\n";
					res += " ";
				}
				res += "  " + n.toString();
				nb_esp++;
			}

			res += "\n";
			
		}
		return res ;
	}
}
