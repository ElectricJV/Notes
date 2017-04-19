/**
 * @author Joshua
 *
 */
public class StudentRecord {

	private String studentName;
	private String address;
	private String studentID;
	private double average;
	
	/**
	 * Default constructor
	 */
	public StudentRecord() {
		this.studentName = "";
		this.studentID = "";
		this.address = "";
		this.average = 0;
	}

	// Access methods
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	// Method to split a string into a set of words
	public void processRecord (String record) {
		String word[];
		word = record.split(",");
		this.studentName = word[0];
		this.studentID = word[1];
		this.address = word[2];
		this.average = Double.parseDouble(word[3]);
	}
	
	// Method to convert data back to a String
	public String toString() {
		return (this.studentName + "," + this.studentID + "," + this.address + "," + Double.toString(this.average));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String record [] = new String [1];
		
		record[0] = "CJ,123456,123 Sunset Blvd,23";
		
		StudentRecord sInfo = new StudentRecord();
		
		sInfo.processRecord(record[0]);
		System.out.println(sInfo.toString());
		System.out.println(sInfo.getStudentName());
		System.out.println(sInfo.getStudentID());
		System.out.println(sInfo.getAddress());
		System.out.println(sInfo.getAverage());
		
		sInfo.setStudentName("Koldep");
		System.out.println(sInfo.getStudentName());
		
		sInfo.setAddress("24 Sus Drive");
		System.out.println(sInfo.getAddress());
		
		sInfo.setStudentID("555555");
		System.out.println(sInfo.getStudentID());
		
		sInfo.setAverage(99.999);
		System.out.println(sInfo.getAverage());
		
		
		
		
	}

	

}
