package fr.ul.miage.exemple;

import java.util.HashMap;

public class Assembleur {

	public static String chaineAssembleur;
	public HashMap<String, String> mapGestionRegistre;
	
	public Assembleur() {
		this.chaineAssembleur = "";
		
		for(int i = 0; i <= 26; i++) {
			this.mapGestionRegistre.put("R"+i, null);
		}
		this.mapGestionRegistre.put("R31", null);
		this.mapGestionRegistre.put("BP", null);
		this.mapGestionRegistre.put("LP", null);
		this.mapGestionRegistre.put("SP", null);
		this.mapGestionRegistre.put("XP", null);
	}
	
	public String chercherPlaceVide() throws PlusDePlaceEnRegistre {
		for(int i = 0; i < this.mapGestionRegistre.size(); i++) {
			if (this.mapGestionRegistre.get(i) == null) {
				return mapGestionRegistre.get(i);
			}
		}
		throw new PlusDePlaceEnRegistre();
	}
	
	public void ajouterEnRegistre(String valeur) throws PlusDePlaceEnRegistre {
		String placeRegistre = chercherPlaceVide();
		this.mapGestionRegistre.put(placeRegistre, valeur);
		
		Load l = new Load();
		l.genererLoad(valeur, placeRegistre);
	}
	
	public void supprimerEnRegistre(String numeroRegistre) {
		this.mapGestionRegistre.put(numeroRegistre, null);
	}
}
