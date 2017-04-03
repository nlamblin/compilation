package fr.ul.miage.exemple;


public class Arbre{
	
	public Noeud racine;
	
	public Arbre(){
		this.racine = new Noeud("Program", null);
	}
	
	public void ajouterNoeud(Noeud n){
		this.racine.fils.add(n);
	}
	
	
	public String afficher(){
		return this.racine.toString()+"\n";
	}
	
}
