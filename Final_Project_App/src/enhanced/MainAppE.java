package enhanced;

import java.util.Scanner;

import enhanced.BussinessOperationsE;
import enhanced.MenusE;

public class MainAppE {

	public static void main(String[] args) {
		MenusE menu = new MenusE();
		BussinessOperationsE oper = new BussinessOperationsE();
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
							if(oper.workDirectory(a)) oper.listFiles();
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
							}while (op2<1 || op2>6);
							if (op2>0 && op2<6) {
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
													oper.searchFiles(b);
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
									case 4:
										menu.insertDirectory(oper.defdirectory);
										a = sc.next();
										try {
											if(oper.workDirectory(a)) {
												menu.insertFile();
												b = sc.next();
												try {
													oper.writeFile(b,sc);
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
									case 5:
										menu.insertDirectory(oper.defdirectory);
										a = sc.next();
										try {
											if(oper.workDirectory(a)) {
												menu.readFile();
												b = sc.next();
												try {
													oper.readFile(b);
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
										
						}while(op2!=6);
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
