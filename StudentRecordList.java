import javax.swing.JOptionPane;

/**
 * @author Joshua
 *
 */
public class StudentRecordList {

	private StudentRecord list[];
	private int maxSize;
	private int size;

	/**
	 * 
	 */
	public StudentRecordList() {
		this.maxSize = 10;
		this.size = 0;
		this.list = new StudentRecord[maxSize];
	}

	/*
	 * Method to insert a record to the list. Checks if there is space (size is
	 * below maxSize). Increases size. Adds record to the location below the
	 * highest element. Returns true if successful.
	 */
	public boolean insert(StudentRecord record) {
		if (size < maxSize) {
			size++;
			list[size - 1] = record;
			return true;
		}
		return false;
	}
	
	// Method to get the list
	private StudentRecord[] getList() {
		return this.list;
	}
	
	// Method to get size
	private int getSize() {
		return this.size;
	}

	/*
	 * Finds the record to delete.
	 * Then moves the last record to the one to be deleted.
	 * Shortens the list (decrease the size of the list).
	 * Returns true if deleted.
	 */
	public boolean delete(StudentRecord record) {
		for (int where = 0; where < size; where++) {
			if (list[where].getStudentName().equalsIgnoreCase(record.getStudentName())) {
				list[where] = list[size-1];	// Puts list in last spot
				size--;		// Decrease size of list
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Method to change record.
	 * Finds the record to change.
	 * Delete old record.
	 * Inserts a new record.
	 */
	public boolean change(StudentRecord oldR, StudentRecord newR) {
		if (delete(oldR)) {
			insert (newR);
			return true;
		}
		return false;
	}
	
	/**
	 * Bubble sort method 
	 */
	public void bubbleSort() {
		for (int pass = 1; pass < size; pass++) {
			for (int element = 0; element < size -1; element++) {
				if (list[element].getStudentName().compareToIgnoreCase(list[element+1].getStudentName())>0) {
					
					StudentRecord hold = list[element];
					list[element] = list[element+1];
					list[element+1] = hold;
				}	// End if
			}	// End for element
		}	// End for pass
	}	// End bubblesort
	
	/**
	 * Binary Search - Search for a name
	 */
	public int binarySearch(String searchKey) {
		int low = 0;
		int high = size -1;
		int middle;
		
		while (low <= high) {
			middle = (high + low)/2;
			if (searchKey.equalsIgnoreCase(list[middle].getStudentName())) {
				return middle; // Element was found
			}
			else if (searchKey.compareToIgnoreCase(list[middle].getStudentName())<0) {
				high = middle -1;
			}
			else {
				low = middle +1;
			}
		}
		return -1; // Element was not found
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StudentRecordList studentList = new StudentRecordList();

		while (true) {
			char command;
			command = JOptionPane.showInputDialog(null, "i - insert a student\n"
					+ "p - print the list\n" 
					+ "d - delete a student\n"
					+ "c - change a record\n"
					+ "s - sort by name\n"
					+ "f - find a person\n").charAt(0);

			switch (command) {
			case 'i': {
				String record = JOptionPane.showInputDialog(null, "Enter <name>,<ID>,<address>,<average>",
						"Tony Campos,P123456,45 Daviselm,100");

				StudentRecord sInfo = new StudentRecord();
				sInfo.processRecord(record);

				if (!studentList.insert(sInfo)) {
					JOptionPane.showMessageDialog(null, "Not added");
				} else {
					JOptionPane.showMessageDialog(null, "Success");
				}
				break;
			}
			case 'd': {
				String record = JOptionPane.showInputDialog(null, "Enter record to delete",
						"Tony Campos,P123456,45 Daviselm,100");

				StudentRecord sInfo = new StudentRecord();
				sInfo.processRecord(record);
				
				if (!studentList.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record not found");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record deleted");
				}
				break;
			}
			case 'c': {
				String record = JOptionPane.showInputDialog(null, "Enter record to delete",
						"Tony Campos,P123456,45 Daviselm,100");

				StudentRecord sInfo = new StudentRecord();
				sInfo.processRecord(record);
				
				record = JOptionPane.showInputDialog(null, "Enter <name>,<ID>,<address>,<average>",
						"Tony Campos,P123456,45 Daviselm,100"); 
				
				StudentRecord newR = new StudentRecord();
				newR.processRecord(record);
				
				if (!studentList.change(sInfo, newR)) {
					JOptionPane.showMessageDialog(null, "Record unable to change");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				break;
			}
			case 'p': {
				StudentRecord [] myRecordList = studentList.getList();
				for (int i = 0; i < studentList.getSize(); i++) {
					System.out.println(myRecordList[i]);
				}
				break;
			}
			case 's': {
				studentList.bubbleSort();
				break;
			}
			case 'f': {
				String record = JOptionPane.showInputDialog(null, "Enter name to find",
						"Tony Campos,P123456,45 Daviselm,100");

				StudentRecord sInfo = new StudentRecord();
				sInfo.processRecord(record);
				
				int loc = studentList.binarySearch(sInfo.getStudentName());
				
				if (loc < 0) {
					JOptionPane.showMessageDialog(null, "Record not found");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record found!");
					System.out.println(loc);
				}
				break;
			}
			}
		}

	}

}
