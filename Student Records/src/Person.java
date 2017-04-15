public class Person {
    private String fName;
    private String lName;
    private String courseTitle;
    private int idNumber;   
    private static int count = 1234567;
    
    public Person(){
       idNumber = count++;
    }
    
    public Person(String fName, String lName, String courseTitle) {
       this.fName = fName;
       this.lName = lName;
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
    
    public int getIDNumber() {    
       return idNumber;
    }
    
   @Override
   public String toString() {  
       return getFirstName() +" " +getLastName() + " " +
             + getIDNumber() + "(Course(s): " + getCourse();
    }

 }
