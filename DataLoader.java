import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoader {
	
	private HashTableMap<String, Student> map;
	private File file;
	
	public DataLoader(File file, HashTableMap<String, Student> map)  {
		this.map = map;
		this.file = file;
		try {
			setData();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void setData() throws FileNotFoundException {
	    String userID;
	    long ID;
	    String major;
	    int gradYear;
	    Student addMe;

	    if (file == null) {
	      throw new FileNotFoundException("Error. No file found. Please use "
	      		+ "valid file ending in .txt");
	    }

	    Scanner scan = new Scanner(file);

	    while(scan.hasNextLine()) {
	       userID = scan.next();
	       ID = scan.nextLong();
	       major = scan.next();
	       gradYear = scan.nextInt();

	       addMe = new Student(ID, major, gradYear);

	       map.put(userID, addMe);
	    }

	    if (scan != null) {
	    	scan.close();
	    }
	  }


	public HashTableMap<String, Student> getMap() {
		return map;
	}


	public void setFile(File file) {
		this.file = file;
	}
	
	
}
