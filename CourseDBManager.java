/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204
 * Project 4
 * 10/30/2022
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure newDBS = new CourseDBStructure(20);

	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newCourse = new CourseDBElement(id, crn, credits, roomNum, instructor);
		newDBS.add(newCourse);
		
	}

	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		
		CourseDBElement course;
		
		try {
			course = newDBS.get(crn);
			return course;
		}catch(IOException e) {
			System.out.print(e.getMessage());
		}
		return null;
	}

	
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner reader = new Scanner(input);
		
		while(reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] str = data.split(" ", 5);
			add(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]),
					str[3], str[4]);
		}
		reader.close();
	}

	
	
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		
		return newDBS.showAll();
	}

}
