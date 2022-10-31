/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204
 * Project 4
 * 10/30/2022
 */



import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface {
	
	
	private ArrayList<LinkedList<CourseDBElement>> hMap;
	private int size;
	private final double LF = 1.5;
	
	
	
	/**
	 * This method checks to see if the given number is prime or not.
	 * @param n The integer to be checked
	 * @return true if n is a prime number and false if it is not a prime number
	 */
	private boolean isPrime(int n) {
		if(n<=1)
			return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
	
	
	/**
	 * This method calculates the next 4k+3 prime number
	 * @param n the integer whose next 4k+3 prime number will be calculated
	 * @return the next 4k+3 prime number after n % (loading factor)
	 */
	private int f4kP3Prime(int n) {
		
		int nextPrime = (int)(n/LF) + 1;
		for(;;nextPrime++)
			if(isPrime(nextPrime)) {
				if((nextPrime-3)%4 == 0)
					return nextPrime;
			}
		
	}
	
	
	
	/**
	 * Accepts the estimated number of elements and creates a hash map with the loading factor of 1.5
	 * @param n The estimated number of elements
	 */
	public CourseDBStructure(int n) {
		
		size = f4kP3Prime(n);
		hMap = new ArrayList<LinkedList<CourseDBElement>>();
		for(int i=0; i<size; i++) {
			hMap.add(new LinkedList<CourseDBElement>());
		}
	}
	/**
	 * Accepts the estimated number of elements and creates a hash map with the loading factor of 1.5
	 * @param n The estimated number of elements
	 * @param Testing only for testing
	 */
	public CourseDBStructure(String Testing, int n) {
		
		size = n;
		hMap = new ArrayList<LinkedList<CourseDBElement>>();
		for(int i=0; i<size; i++) {
			hMap.add(new LinkedList<CourseDBElement>());
		}
	}

	
	
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		int index = element.getCRN()%size;
		
		LinkedList<CourseDBElement> bucket = new LinkedList<CourseDBElement>();
		bucket = hMap.get(index);
		
		if(bucket.isEmpty())
			bucket.add(element);
			
		for(int i=0; i<bucket.size(); i++) {
			if(bucket.get(i).CRN == element.CRN)
				bucket.set(i, element);
		}
		
		hMap.set(index, bucket);
		
	}

	
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = crn%hMap.size();
		LinkedList<CourseDBElement> bucket = hMap.get(index);
		for(int i=0; i<bucket.size(); i++) {
			if(bucket.get(i).CRN == crn)
				return bucket.get(i);
		}
		throw new IOException();
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
		LinkedList<CourseDBElement> bucket;
		ArrayList<String> courses = new ArrayList<String>();
		String str = "";
		
		for(int i=0; i<hMap.size(); i++) {
			bucket = hMap.get(i);
			for(int j=0; j<bucket.size(); j++) {
				str = "\nCourse:" + bucket.get(j).courseID + " CRN:" +
						bucket.get(j).CRN + " Credits:" + bucket.get(j).creditN
						+ " Instructor:" + bucket.get(j).instructor +
						" Room:" + bucket.get(j).roomN;
				courses.add(str);
			}
		}
		return courses;
	}

	
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		
		return size;
	}
	
	

}
