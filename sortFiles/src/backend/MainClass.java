package backend;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MainClass {

	//the path of the folder we wont to sort his files 
	private static String targetPath;
	//the file type (should be like : .png , .txt , .java  ,...ect)
	private static String fileType;
	//the path of the new folder 
	private static String theNewPathString;
	public static void main(String[] args) {
		getInputs();
		sortFiles();
	}
	//getting inputs from the user 
	private static void getInputs() {
		System.out.println("enter the target folder path");
		Scanner targetPathInput = new Scanner(System.in);
		targetPath = targetPathInput.nextLine();
		System.out.println("enter the file type (like : .png , .txt , .html)");
		Scanner fileTypeInput = new Scanner(System.in);
		fileType = fileTypeInput.nextLine();
		System.out.println("enter the path of the folder were you move your files");
		Scanner theNewPathInput = new Scanner(System.in);
	    theNewPathString = theNewPathInput.nextLine();
	}
   //sorting files 
	public static void sortFiles() {
		if(!targetPath.equals("")) {
		File targetFolder = new File(targetPath);
		File[] files = targetFolder.listFiles();
		for(File file : files) {
			String reserveFileType = "";
			for(int i = file.getPath().length() - 1; i >= 0; i--) {
				if(file.getPath().charAt(i) != '.')
					reserveFileType += file.getPath().charAt(i);
				else {
					reserveFileType += file.getPath().charAt(i);
					break;
				}
			}
			String ThisFileType = "";
			for(int i = reserveFileType.length() - 1 ; i >= 0; i--) 
				ThisFileType += reserveFileType.charAt(i);
			if(ThisFileType.equals(fileType)) {
				Path filePath = Paths.get(file.getPath());
					Path theNewPath = Paths.get(theNewPathString + "\\" + file.getName());
					try {
						Files.move(filePath,theNewPath, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		}else {
			System.out.println("Error");
		}
	}
}
