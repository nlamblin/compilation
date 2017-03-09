/**
 * 
 */
package fr.ul.miage.exemple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream(new File("test-suite/01-minimal.miage"));
		ParserCup parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		parser.debug_parse();
		try {
			parser.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
