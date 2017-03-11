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
		FileInputStream file;
		ParserCup parser;
		
		System.out.println("----------00-syntaxe----------");
		file = new FileInputStream(new File("test-suite/00-syntaxe.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------00-syntaxe----------");
		Thread.sleep(1000);

		System.out.println("----------01-minimal----------");
		file = new FileInputStream(new File("test-suite/01-minimal.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------01-minimal----------");
		Thread.sleep(1000);

		System.out.println("----------02-global----------");
		file = new FileInputStream(new File("test-suite/02-global.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------02-global----------");
		Thread.sleep(1000);

		System.out.println("----------03-expression----------");
		file = new FileInputStream(new File("test-suite/03-expression.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------03-expression----------");
		Thread.sleep(1000);

		System.out.println("----------04-expression----------");
		file = new FileInputStream(new File("test-suite/04-expression.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------04-expression----------");
		Thread.sleep(1000);

		System.out.println("----------05-expression----------");
		file = new FileInputStream(new File("test-suite/05-expression.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------05-expression----------");
		Thread.sleep(1000);

		System.out.println("----------06-local----------");
		file = new FileInputStream(new File("test-suite/06-local.miage"));
		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
		try {
			parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------06-local----------");
	}

}
