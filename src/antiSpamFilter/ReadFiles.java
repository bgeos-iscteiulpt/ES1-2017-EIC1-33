package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles {

		private static ArrayList<String> ham = new ArrayList<String>();
		private static ArrayList<String> spam = new ArrayList<String>();
		private static ArrayList<String> rules = new ArrayList<String>();

		public ReadFiles() {

		}

		public static void lerFicheiros() {

			File[] fileArray = new File("Ficheiros").listFiles();        

			for(File f: fileArray) {

				if(f.getName().equals("ham.log")) { //	ler o ficheiro ham e adicionar á lista                 
					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							ham.add(line);
						}	
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}  

				if(f.getName().equals("spam.log")) { // ler o ficheiro spam e adicionar á lista
				                 
					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							spam.add(line);
						}	
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}

				if(f.getName().equals("rules.cf")) { // ler o ficheiro rules e adicionar á lista
					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							rules.add(line);
						}	
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}  
			}
		}

		public static ArrayList<String> getHam() {
			return ham;
		}

		public static ArrayList<String> getSpam() {
			return spam;
		}

		public static ArrayList<String> getRules() {
			return rules;
		}
		
		
		
	}
