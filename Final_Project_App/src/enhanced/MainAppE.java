package enhanced;

import java.util.ArrayList;
import java.util.Scanner;

import enhanced.BussinessOperationsE;
import enhanced.MenusE;
import enhanced.UsersE;

public class MainAppE {

	public static void main(String[] args) {
		MenusE menu = new MenusE();
		BussinessOperationsE oper = new BussinessOperationsE();
		Scanner sc = new Scanner(System.in);
		UsersE user = new UsersE();
		int op=0;
		int op2=0;
		char ex ='n';
		String a;
		String b;
		boolean enter = false;
		int times = 0;
		boolean[] permission={false,false,false,false,false,false};
		ArrayList<Object> userfind;
		
		do {
			menu.login();
			a = sc.next();
			menu.pwd(times);
			b = sc.next();
			userfind=user.UserCheck(a,b);
			if (userfind.size()==3) {
				enter =true;
				menu.wellcomeUser((String)userfind.get(0), (String)userfind.get(1));
				permission=(boolean[])userfind.get(2);
			}else {
				System.out.println(" Sorry, login/password are not correct!\n");
			}			
			times+=1;
		}while (enter==false && times<3);
		
		if(enter) {
		
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
							if(permission[0]) {	
								menu.insertDirectory(oper.defdirectory);
								a = sc.next();
								try {
									if(oper.workDirectory(a)) oper.listFiles();
								}catch(Exception e) {
									menu.sorry();
									System.out.println(e);
								}
							}else {
								System.out.println(" Sorry, You don't have permission for this option.");								
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
											if(permission[1]) {	
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
											}else {
												System.out.println(" Sorry, You don't have permission for this option.");								
											}
											break;
										case 2:
											if(permission[2]) {
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
											}else {
												System.out.println(" Sorry, You don't have permission for this option.");								
											}
											break;
										case 3:
											if(permission[3]) {
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
											}else {
												System.out.println(" Sorry, You don't have permission for this option.");								
											}
											break;
										case 4:
											if(permission[4]) {
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
											}else {
												System.out.println(" Sorry, You don't have permission for this option.");								
											}
											break;
										case 5:
											if(permission[5]) {
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
											}else {
												System.out.println(" Sorry, You don't have permission for this option.");								
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
		}else {
			System.out.println(" You have reached the maximum number of attemps.\n");
		}
		sc.close();
		if (enter) {
			menu.bye((String)userfind.get(0));
		}else {
			menu.bye();
		}
		

	}

	

}
