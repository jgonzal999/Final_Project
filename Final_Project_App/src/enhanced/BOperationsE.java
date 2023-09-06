package enhanced;

import java.io.IOException;
import java.util.Scanner;

public interface BOperationsE {
	public boolean workDirectory(String a) throws IOException;
	public void addNewFile(String a) throws IOException;
	public void delFile(String a) throws IOException;
	public void listFiles() throws IOException;
	public boolean searchFiles(String b) throws IOException;
	// Enhanced
	public void writeFile(String b, Scanner dis) throws IOException ;
	public void readFile(String b) throws IOException;
}
