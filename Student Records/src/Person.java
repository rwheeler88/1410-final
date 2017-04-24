import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Person {
    private String fName;
    private String lName;
    private String courseTitle;
    protected int idNumber;   
    protected static int count = 1234567;
    
    public Person(){
       idNumber = count++;
    }
    
    public Person(String fName, String lName, String courseTitle) {
       this.fName = fName;
       this.lName = lName;
       this.courseTitle = courseTitle;
     idNumber = count++;
    }
    
   public String getFirstName(){
     return fName;
   }
    
    public String getLastName(){
       return lName;
    }
    
    public String getCourse() {
       return courseTitle;
    }
    
    public Integer getIDNumber() {    
       return idNumber;
    }
    
public static ArrayList<Person> reader() throws IOException {
		
		FileReader pw = new FileReader(MainGUI.openFileChooser());// sets file to be read
		BufferedReader read = new BufferedReader(pw);// reads file
		
		int id = 0;
		String fName = "";
		String lName = "";
		String coarseTitle = "";
		
		ArrayList<Person> list = new ArrayList<Person>();
		while (true) {// loops threw and reads in each line of the file
			String line = read.readLine();
			if (line != null) {
				id = Integer.parseInt(line);
				fName = read.readLine();
				lName = read.readLine();
				coarseTitle = read.readLine();

				Person t = new Person(fName, lName, coarseTitle);
				list.add(t);// adds to Teacher Array
				
			} else
				break;
		}
		return list;
	}
    
   @Override
   public String toString() {  
       return getFirstName() +" " +getLastName() + " " +
             + getIDNumber() + "(Course(s): " + getCourse();
    }
   
	public String[] toStringArray()
	{
		return new String[]{getIDNumber().toString(), getFirstName(), getLastName(), getCourse()};
	}

 }

