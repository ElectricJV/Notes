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
	 * Then moves the last record to the one to be.
	 * Deleted.
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
	 * @param args
	 */
	public static void main(String[] args) {

		StudentRecordList studentList = new StudentRecordList();

		while (true) {
			char command;
			command = JOptionPane.showInputDialog(null, "i - insert a student\n"
					+ "p - print the list\n" 
					+ "d - deletes a student").charAt(0);

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
			}
			case 'p': {
				StudentRecord [] myRecordList = studentList.getList();
				for (int i = 0; i < studentList.getSize(); i++) {
					System.out.println(myRecordList[i]);
				}
				break;
			}
			}
		}

	}

}
