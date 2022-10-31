/**
 * 
 * @author Sepand Jahrominejad
 * 
 * CMSC 204
 * Project 4
 * 10/30/2022
 *
 */



public class CourseDBElement implements Comparable<CourseDBElement> {
	
	String courseID, roomN, instructor;
	int CRN, creditN;
	
	
	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		courseID = null;
		roomN = null;
		instructor = null;
		CRN = 0;
		creditN = 0;
	}
	
	
	/**
	 * Creates a CourseDBElemenet objects with given parameters
	 * @param courseID
	 * @param CRN
	 * @param creditN
	 * @param roomN
	 * @param instructor
	 */
	public CourseDBElement(String courseID, int CRN, int creditN, String roomN, String instructor) {
		this.courseID = courseID;
		this.roomN = roomN;
		this.instructor = instructor;
		this.CRN = CRN;
		this.creditN = creditN;
		
	}
	

	
	/**
	 * Compares two CourseDBElements to see if they are equals
	 * @param o The CourseDBElement to be compared
	 * @return 0 if elements are equal and 1 if not
	 */
	@Override
	public int compareTo(CourseDBElement o) {
		if(this.courseID.compareTo(o.courseID)==0 &&
				this.roomN.compareTo(o.roomN)==0 &&
				this.instructor.compareTo(o.instructor)==0 &&
						this.CRN == o.CRN && this.creditN == o.creditN)
				return 0;
		else
			return 1;
	}
	
	
	/**
	 * 
	 * @return the CRN
	 */
	public int getCRN() {
		return CRN;
	}
	
	
	/**
	 * 
	 * @return the course ID
	 */
	public String getID() {
		return courseID;
	}

	
	/**
	 * 
	 * @return the room number
	 */
	public Object getRoomNum() {
		return roomN;
	}

	
	/**
	 * sets the CRN
	 * @param parseInt will be set as CRN
	 */
	public void setCRN(int parseInt) {
		CRN = parseInt;
		
	}

}
