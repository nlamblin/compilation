/**
 * 
 */
package fr.ul.miage.exemple;

import java.io.BufferedReader; 
import java.io.InputStreamReader;

import fr.ul.miage.exemple.generated.ParserCup;
import fr.ul.miage.exemple.generated.Yylex;



/**
 * @author azim
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParserCup parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(System.in))));
		try {
			parser.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
