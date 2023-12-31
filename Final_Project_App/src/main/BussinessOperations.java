package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
			if (a.charAt(0)!='/') a="/"+a;
			if (a.charAt(a.length()-1)!='/') a=a+"/";
			a.replace("//", "/");// to prevent user can use double //
			directory=a.replace("/", "//");
		}
		File f = new File(directory);
		if(f.exists()) {
			System.out.println(" OK, the directory exists.");	
			defdirectory= directory;
			return true;
		}else {
			System.out.println(" Sorry, the directory:  "+directory.replace("//", "/")+" doesn't exist.");
			return false;
		}
	}
	
	public void addNewFile(String a) throws IOException {
		//if file doesn't have any extension I add .txt extension as default
		
		if (a.lastIndexOf(".")<0) a+=".txt";
		File file = new File(defdirectory+a);
        if (file.createNewFile()){
        	System.out.println(" OK, the file has been created!");
        }else{
        	System.out.println(" Sorry, the file: "+file+" already exists.");
        }
	}
	public void delFile(String a) throws IOException {
		File file = new File(defdirectory+a);
		try {
			if (file.exists()) {
				file.delete();
				System.out.println(" OK, the file has been deleted!");
			}else {
				System.out.println(" Sorry, the file: "+file+" doesn't exist.");
			}
		}catch (Exception e) {
    		System.out.println(" Sorry, the file: "+file+" cannot be deleted.");
    		System.out.println(e);
    	}
	}
	public void listFiles() throws IOException {
						
		File f = new File(defdirectory);		
		if(f.exists()) {
			ArrayList<String> totalfiles = new ArrayList<String>();
			ArrayList<String> totaldirectories = new ArrayList<String>();
			File[] files = f.listFiles();
			for (File file: files) {
				if(file.isFile()) {
					totalfiles.add(file.getName());				
				}
				if(file.isDirectory()) {
					totaldirectories.add(file.getName());				
				}
			}
//			Collections.sort(totalfiles); This is a already created method, I use mine
//			Collections.sort(totaldirectories);
//			Quick Sort Method
			sort(totalfiles,0,totalfiles.size()-1);
			sort(totaldirectories,0,totaldirectories.size()-1);
			System.out.println("\n Directories:");
			for (String dir: totaldirectories) System.out.println("   "+dir);
			System.out.println("\n Files:");
			for (String fil: totalfiles) System.out.println("   "+fil);
		}else {
			System.out.println(" Sorry, the directory: "+defdirectory.replace("//", "/")+" doesn't exist.");
		}		
	}
	
//	Quick Sort Method	
	int partition(ArrayList<String> arr,int low, int high) {
		String pivot =arr.get(high);
		int i=low-1;
		for (int j=low;j<high;j++) {
			if (arr.get(j).compareToIgnoreCase(pivot)<0) {
				i++;
				String temp =arr.get(i);
				arr.set(i,arr.get(j));
				arr.set(j,temp);					
			}
		}
		String temp =arr.get(i+1);
		arr.set(i+1,arr.get(high));
		arr.set(high,temp);	
		return i+1;
	}	
	public void sort(ArrayList<String> arr,int low,int high) {
		if(low<high) {
			int pi=partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}
	
	public boolean searchFiles(String b) throws IOException{				
		File f = new File(defdirectory);		
		if(f.exists()) {
			ArrayList<String> totalfiles = new ArrayList<String>();
			File[] files = f.listFiles();
			for (File file: files) {
				if(file.isFile()) {
					totalfiles.add(file.getName());				
				}
			}
			ArrayList<String> foundedfiles=new ArrayList<String>(); 
			String pattern = b;
			Pattern p = Pattern.compile(pattern);
			Iterator<String> itr=totalfiles.iterator();
			while(itr.hasNext()){
				String c=itr.next();
				Matcher d = p.matcher(c);
				if(d.find()) {
					foundedfiles.add(c);
				}			
			}
			System.out.println(" Files found:");
			Collections.sort(foundedfiles);
			if (foundedfiles.size()!=0) {
				for (String fil: foundedfiles) System.out.println("   "+fil);
				return true;
			}else {
				System.out.println(" Sorry, files not found (pattern: "+b+")");
				return false;
			}
		}else {
			System.out.println(" Sorry, the directory: "+defdirectory.replace("//", "/")+" doesn't exist.");
			return false;
		}
	}
	
}
