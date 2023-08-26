package main;

import java.util.Scanner;

import main.Menus;
import main.BussinessOperations;

public class MainApp {

	public static void main(String[] args) {
		Menus menu = new Menus();
		BussinessOperations oper = new BussinessOperations();
		Scanner sc = new Scanner(System.in);
		int op=0;
		char ex ='n';
		String a;
		String b;
		do {			
			do {
				menu.mainMenu(oper.defdirectory);
				try {
					op = sc.nextInt();
				}catch(Exception e) {
					op=100;
					sc.reset();
				}
			}while (op<1 || op>3);
			if (op>0 && op<3) {
				switch(op) {
					case 1:
						menu.insertDirectory();
						a = sc.next();
						try {
							oper.workDirectory(a);
						}catch(Exception e) {
							menu.sorry();
							System.out.println(e);
						}						
						break;
					case 2:
						menu.insertNew();
						a = sc.next();
						try {
							oper.addNewFile(a);
						}catch(Exception e) {
							menu.sorry();
							System.out.println(e);
						}						
						break;
					case 3:
						menu.insertDel();
						a = sc.next();
						try {
							oper.delFile(a);
						}catch(Exception e) {
							menu.sorry();
							System.out.println(e);
						}
						break;
					case 4:
						menu.insertDirectory();
						a = sc.next();
						try {
							oper.listFiles(a);
						}catch(Exception e) {
							menu.sorry();
						}
						break;
					case 5:						
						menu.insertDirectory();
						a = sc.next();
						menu.insertFile();
						b=sc.next();
						try {
							oper.writeFile(a,b,sc);
						}catch(Exception e) {
							menu.sorry();
						}
						break;
					case 6:
						menu.insertDirectory();
						a = sc.next();
						menu.readFile();
						b=sc.next();
						try {
							oper.readFile(a,b);
						}catch(Exception e) {
							menu.sorry();
						}
						break;
				}
						
			}else {
				menu.cont();
				ex = sc.next().charAt(0);
				if (ex!='y' && ex!='Y') {
					op=0;
				}
			}
		}while(op!=7);
		sc.close();
		menu.bye();

	}

}
