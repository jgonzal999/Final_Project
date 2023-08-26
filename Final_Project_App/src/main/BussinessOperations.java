package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import main.Menus;

public class BussinessOperations implements BOperations {
	
	String defdirectory = new String("//home//javiergonzalezv//Desktop//ExercisesTemp//");
	Menus menu = new Menus();
	
	public BussinessOperations() {
		menu.wellcome();		
	}
	
	public boolean workDirectory(String a) throws IOException {
		String directory = new String();
		if (a.equals("d")) {
			directory= defdirectory;
		}else {			
			for (int i=0;i<a.length();i++) {
				directory+=a.charAt(i);
				if (a.charAt(i)=='/') {
					directory+="/";
				}
				if (i==a.length()-1 && a.charAt(i)!='/') {
					directory+="//";
				}
			}
		}
		File f = new File(directory);
		if(f.exists()) {
			System.out.println("OK, Work Directory exists.");	
			defdirectory= directory;
			return true;
		}else {
			System.out.println("Sorry, Directory:\n  "+a+"\n doesn't exist.");
			return false;
		}
	}
	
	public void addNewFile(String a) throws IOException {
		//I find .txt, if not I add it
		String pattern = ".txt";
		Pattern p = Pattern.compile(pattern);
		Matcher c = p.matcher(a);
		if (!c.find()) {
			a+=".txt";
		}
		File file = new File(defdirectory+a);
        if (file.createNewFile()){
        	System.out.println("File is created!");
        }else{
        	System.out.println("Sorry, file:\n "+file+"\nalready exists.");
        }
	}
	public void delFile(String a) throws IOException {
		File file = new File(defdirectory+a);
		try {
			if (file.exists()) {
				file.delete();
				System.out.println("File is deleted!");
			}else {
				System.out.println("Sorry, file:\n "+file+"\n doesn't exist.");
			}
		}catch (Exception e) {
    		System.out.println("Sorry, file:\n "+file+"\n cannot be deleted.");
    		System.out.println(e);
    	}
	}
	public void listFiles(String a) throws IOException {
				
		String directory = new String();

		if (a.equals("d")) {
			directory= defdirectory;
		}else {
			for (int i=0;i<a.length();i++) {
				directory+=a.charAt(i);
				if (a.charAt(i)=='/') {
					directory+="/";
				}
			}
		}
		File f = new File(directory);
		if(f.exists()) {
			File[] files = f.listFiles();
			for (File file: files) {
				if(file.isFile()) {
					System.out.println("File:\t"+file.getName());					
				}
				if(file.isDirectory()) {
					System.out.println("Directory:\t"+file.getName());					
				}
			}
	
		}else {
			System.out.println("Sorry, Directory: "+a.replace("//", "/")+" doesn't exist.");
		}
		
	}
	
	public boolean searchFiles(String a) throws IOException{
		return false;
	}
	
	
	
	
	
	public void writeFile(String a, String b, Scanner dis) throws IOException {
		String directory = new String();
		if (a.equals("d")) {
			directory= defdirectory;
		}else {
			for (int i=0;i<a.length();i++) {
				directory+=a.charAt(i);
				if (a.charAt(i)=='/') {
					directory+="/";
				}
			}
		}
		try {
			File f = new File(directory);
			if (f.exists()) {
				File file = new File(directory+b);
				if (file.exists()) {
					FileOutputStream fos = new FileOutputStream(file.toString(),true);
					System.out.println("Please enter the data you want to write on the file (type %% to finish)");
					String line = new String();
					char escape= '%';
					char lastch=' ';
					boolean exit=false;
					
					while(!exit) {		// when we hit enter key it will stop reading data. 
						fos.write((int)'\n');
						line = dis.nextLine();
						for (int i=0;i<line.length();i++) {
							if (line.charAt(i)==escape || exit) {
								if (lastch!=escape) {
									lastch =escape;
								}else {	
									exit=true;
								}
							}else{
								if (lastch==escape) {
									fos.write(lastch);	// in file automatically convert it
								}
								fos.write(line.charAt(i));
								lastch =line.charAt(i);
							}
						}						
						
					}
					fos.close();
					System.out.println("Done!");
				}else {
					System.out.println("Sorry, file: "+file+" doesn't exists.");
				}
			}else {
				System.out.println("Sorry, directory: "+f.getName().replace("//", "/")+" doesn't exists.");
			}
		}catch (Exception e) {
    		System.out.println("Sorry, try again");
    		System.out.println(e);
    	}

	}
	public void readFile(String a, String b) throws IOException {
		String directory = new String();
		if (a.equals("d")) {
			directory= defdirectory;
		}else {
			for (int i=0;i<a.length();i++) {
				directory+=a.charAt(i);
				if (a.charAt(i)=='/') {
					directory+="/";
				}
			}
		}
		try {
			File f = new File(directory);
			if (f.exists()) {
				File file = new File(directory+b);
				if (file.exists()) {
					System.out.println("Reading file: ");
					FileReader readfile = new FileReader(file);
					int leter;
					String text = new String(" ");
					while ((leter=readfile.read()) != -1) {
						text+=(char)leter;
					}
					System.out.println(text.replace("\n", "\n "));
					readfile.close();
				}else {
					System.out.println("Sorry, file: "+file+"doesn't exists.");
				}
			}else {
				System.out.println("Sorry, directory: "+f.getName().replace("//", "/")+"doesn't exists.");
			}
		}catch (Exception e) {
    		System.out.println("Sorry, try again");
    		System.out.println(e);
    	}

	}

}
