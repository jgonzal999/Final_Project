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
		int op2=0;
		char ex ='n';
		String a;
		String b;
		do {			
			do {
				menu.mainMenu();
				try {
					op = sc.nextInt();
				}catch(Exception e) {
					op=100;
					sc.nextLine();
				}
			}while (op<1 || op>3);
			if (op>0 && op<3) {
				switch(op) {
					case 1:
						menu.insertDirectory(oper.defdirectory);
						a = sc.next();
						try {
							if(oper.workDirectory(a)) oper.listFiles(a);
						}catch(Exception e) {
							menu.sorry();
							System.out.println(e);
						}						
						break;
					case 2:
						do {
							do {
								menu.operationsMenu();
								try {
									op2 = sc.nextInt();
								}catch(Exception e) {
									op2=100;
									sc.nextLine();
								}
							}while (op2<1 || op2>4);
							if (op2>0 && op2<4) {
								switch(op2) {
									case 1:
										menu.insertDirectory(oper.defdirectory);
										a = sc.next();
										try {
											if(oper.workDirectory(a)) {
												menu.insertNew();
												a = sc.next();
												try {
													oper.addNewFile(a);
												}catch(Exception e) {
													menu.sorry();
													System.out.println(e);
												}						
												break;
											}
										}catch(Exception e) {
											menu.sorry();
											System.out.println(e);
										}
										break;
									case 2:
										menu.insertDirectory(oper.defdirectory);
										a = sc.next();
										try {
											if(oper.workDirectory(a)) {
												menu.insertDel();
												a = sc.next();
												try {
													oper.delFile(a);
												}catch(Exception e) {
													menu.sorry();
													System.out.println(e);
												}						
												break;
											}
										}catch(Exception e) {
											menu.sorry();
											System.out.println(e);
										}
										break;
									case 3:
										menu.insertDirectory(oper.defdirectory);
										a = sc.next();
										try {
											if(oper.workDirectory(a)) {
												menu.insertsearch();
												b = sc.next();
												try {
													oper.searchFiles(a, b);
												}catch(Exception e) {
													menu.sorry();
													System.out.println(e);
												}						
												break;
											}
										}catch(Exception e) {
											menu.sorry();
											System.out.println(e);
										}
										break;										
									default:
										break;
								}
							}				
										
						}while(op2!=4);
						break;
					default:
						break;
				}
						
			}else {
				menu.cont();
				ex = sc.next().charAt(0);
				if (ex!='y' && ex!='Y') {
					op=0;
				}
			}
		}while(op!=3);
		sc.close();
		menu.bye();

	}

}
