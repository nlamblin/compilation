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
		
//		System.out.println("----------00-syntaxe----------");
//		file = new FileInputStream(new File("test-suite/00-syntaxe.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------00-syntaxe----------");
//		Thread.sleep(1000);
//
//		System.out.println("----------01-minimal----------");
//		file = new FileInputStream(new File("test-suite/01-minimal.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------01-minimal----------");
//		Thread.sleep(1000);

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

//		System.out.println("----------03-expression----------");
//		file = new FileInputStream(new File("test-suite/03-expression.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------03-expression----------");
//		Thread.sleep(1000);
//
//		System.out.println("----------04-expression----------");
//		file = new FileInputStream(new File("test-suite/04-expression.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------04-expression----------");
//		Thread.sleep(1000);
//
//		System.out.println("----------05-expression----------");
//		file = new FileInputStream(new File("test-suite/05-expression.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------05-expression----------");
//		Thread.sleep(1000);
//
//		System.out.println("----------06-local----------");
//		file = new FileInputStream(new File("test-suite/06-local.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------06-local----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------07-parametre----------");
//		file = new FileInputStream(new File("test-suite/07-parametre.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------07-parametre----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------08-fonction----------");
//		file = new FileInputStream(new File("test-suite/08-fonction.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------08-fonction----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------09-fonction----------");
//		file = new FileInputStream(new File("test-suite/09-fonction.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------09-fonction----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------10-conditionnelle----------");
//		file = new FileInputStream(new File("test-suite/10-conditionnelle.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------10-conditionnelle----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------11-iteration----------");
//		file = new FileInputStream(new File("test-suite/11-iteration.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------11-iteration----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------12-recursivite----------");
//		file = new FileInputStream(new File("test-suite/12-recursivite.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------12-recursivite----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------13-err1----------");
//		file = new FileInputStream(new File("test-suite/13-err1.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------13-err1----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------14-err2----------");
//		file = new FileInputStream(new File("test-suite/14-err2.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------14-err2----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------15-err3----------");
//		file = new FileInputStream(new File("test-suite/15-err3.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------15-err3----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------16-err4----------");
//		file = new FileInputStream(new File("test-suite/16-err4.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------16-err4----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------17-err5----------");
//		file = new FileInputStream(new File("test-suite/17-err5.miage"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------17-err5----------");
//		Thread.sleep(1000);
//		
//		System.out.println("----------fibonacci----------");
//		file = new FileInputStream(new File("test-suite/fibonacci"));
//		parser = new ParserCup(new Yylex(new BufferedReader(new InputStreamReader(file))));
//		try {
//			parser.parse();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("----------fibonacci----------");
//		Thread.sleep(1000);
		
	
	}

}

		
