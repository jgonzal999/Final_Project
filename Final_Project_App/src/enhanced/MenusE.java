package enhanced;

public class MenusE {
	public void wellcome() {
		System.out.println("   ********************************************");
		System.out.println("   *** Welcome to File Handling Application ***");
		System.out.println("   ***            by LockedMe.com           ***");
		System.out.println("   ***      Developer: Javier Gonzalez      ***");
		System.out.println("   ********************************************");
	}
	public void mainMenu() {
		System.out.println("\nMAIN MENU:\n\n 1.List a directory\n 2.Operations\n\n 3.QUIT\n\nPlease, select an option:");
	}
	public void operationsMenu() {
		System.out.println("\nOPERATIONS MENU:\n\n 1.Add new file\n 2.Delete file\n 3.Search files\n 4.Write to a txt file\n 5.Read a txt file\n\n 6.Main Menu\n\nPlease, select an option:");
	}
	public void login() {
		System.out.println("Please, enter login: ");
	}
	public void pwd(int times) {
		System.out.println("Please, enter pwd (Max 3 attemps: "+times+") : ");
	}
	public void wellcomeUser(String a, String b) {
		System.out.println(" Wellcome "+a+" "+b+" have a nice day!!");
	}
	
	public void insertNew() {
		System.out.println("Please, enter new file (if not included, it will be added extension .txt): ");
	}
	public void insertDel() {
		System.out.printf("Please, enter file to delete (full name without path): ");
	}
	public void insertDirectory(String a) {
		System.out.println("\nWorking directory: "+a.replace("//", "/"));
		System.out.printf("Please, enter new directory or 'd' for default: ");
	}
	public void insertsearch() {
			System.out.printf("Please insert file to search (full name or part of it): ");
	}
	public void insertFile() {
		System.out.printf("Please, enter an exist file to write to it (full name and .txt mandatory): ");
	}
	public void readFile() {
		System.out.printf("Please, enter file to read it (full name and .txt mandatory: ");
	}
	public void insertText() {
		System.out.printf("Please, enter text: ");
	}
	public void cont() {
		System.out.println("Do you really want to quit the app? (y/n): ");
	}
	public void bye() {
		System.out.println("   *****************************************************");
		System.out.println("   *** Bye, thank you for use LockedMe.com products! ***");
		System.out.println("   *****************************************************");
	}
	public void bye(String a) {
		System.out.println("   *****************************************************");
		System.out.println("    Bye "+a+", thank you for use LockedMe.com products!");
		System.out.println("   *****************************************************");
	}
	public void sorry() {
		System.out.println("Sorry, try it again!");
	}
}
