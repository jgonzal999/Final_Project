package main;

public class Menus {
	public void wellcome() {
		System.out.println("********************************************");
		System.out.println("*** Welcome to File Handling Application ***");
		System.out.println("***            by LockedMe.com           ***");
		System.out.println("***      Developer: Javier Gonzalez      ***");
		System.out.println("********************************************");
	}
	public void mainMenu(String a) {
		System.out.println("\nWorking Directory: "+a.replace("//", "/"));
		System.out.println("\nMain Menu:\n\n 1.List a directory\n 2.Operations\n\n 3.QUIT\\n\\n Please, select an option:");
	}
	public void operationsMenu(String a) {
		System.out.println("\nWorking Directory: "+a.replace("//", "/"));
		System.out.println("\nMain Menu:\n\n 1.Add new file\n 2.Delete file\n 3.Search files\n\n 4.QUIT\n\n Please, select an option:");
	}
	public void insertNew() {
		System.out.println("Please, enter new file (if not added default extension will be .txt): ");
	}
	public void insertDel() {
		System.out.printf("Please, enter file to delete (complete name without path): ");
	}
	public void insertDirectory() {
		System.out.printf("Please, enter directory ('d' for default): ");
	}
	public void insertFile() {
		System.out.printf("Please, enter file to write to it: ");
	}
	public void readFile() {
		System.out.printf("Please, enter file to read it: ");
	}
	public void insertText() {
		System.out.printf("Please, enter text: ");
	}
	public void cont() {
		System.out.println("Do you really want to quit the app? (y/n): ");
	}
	public void bye() {
		System.out.println("Bye, thank you for using our products!");
	}
	public void sorry() {
		System.out.println("Sorry, try it again!");
	}
}
