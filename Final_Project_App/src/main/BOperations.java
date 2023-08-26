package main;

import java.io.IOException;

public interface BOperations {
	
	public boolean workDirectory(String a) throws IOException;
	public void addNewFile(String a) throws IOException;
	public void delFile(String a) throws IOException;
	public void listFiles(String a) throws IOException;
	public boolean searchFiles(String a, String b) throws IOException;

}
