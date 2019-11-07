/*

Introduction to Software Engineering; Task 12
02 September 2019; Thapelo Moshoadiba

● Write code to read the content of the text file input.txt. For each line in input.txt, write a new line in the new text file output.txt that computes the answer to some operation on a list of numbers.
● If the input.txt has the following:
  Min: 1,2,3,5,6
  Max: 1,2,3,5,6
  Avg: 1,2,3,5,6
 Your program should generate output.txt as follows:
  The min of [1, 2, 3, 5, 6] is 1.
  The max of [1, 2, 3, 5, 6] is 6.
  The avg of [1, 2, 3, 5, 6] is 3.4.
● Assume that the only operations given in the input file are min, max and avg, and that the operation is always followed by a list of comma separated integers. You should define the functions min, max and avg that take in a list of integers and return the min, max or avg of the list.
● Your program should handle any combination of operations and any length of input numbers. You can assume that the list of input numbers are always valid integers and that the list is never empty.


● Change your program to additionally handle the operation “px” where x is a number from 10 to 90 and defines the x percentile of the list of numbers. E.g.:
  Input.txt:
  Min: 1,2,3,5,6
  Max: 1,2,3,5,6
  Avg: 1,2,3,5,6
  P90: 1,2,3,4,5,6,7,8,9,10
  Sum: 1,2,3,5,6
  P70: 1,2,3
● Your output.txt should read:
  The min of [1,2,3,5,6] is 1.
  The max of [1,2,3,5,6] is 6.
  The avg of [1,2,3,5,6] is 3.4.
  The 90th percentile of [1,2,3,4,5,6,7,8,9,10] is 9.
  The sum of [1,2,3,5,6] is 17.
  The 70th percentile of [1,2,3] is 2
  
*/

package myFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyFile {
	
public static void main (String [] args) {
		
		// Creation of output file
		
		try {
			
			File outObj = new File ("output.txt"); // this file will be created in the folder of the src folder (i.e. in will be in the same folder as the src folder)
			
			if (outObj.createNewFile()) {
				
				System.out.println("Successful output file creation \n");
			
			} else  {
				
				System.out.println("Output file not created; it probably already exists, check folder to see if it's there \n");
				
			}
			
		} catch (IOException e) {
			
			System.out.println ("Error in creating the output file \n");
			e.printStackTrace();
			
		}
		
		// Reading of input file
		
		try {
			
			File inObj = new File ("input.txt"); // this file is in the folder of the src folder (i.e. it's in the same folder as the src folder)
			Scanner myReader = new Scanner (inObj);
			
			while (myReader.hasNextLine()) {
				
				String inputData = myReader.nextLine();
				
				String [] array1 = inputData.split(":");
				if (array1[0].equals("min")) { // string1.equals(string2) is how you compare strings, you don't use "=="
					
					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting an string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // done with conversion
					
			        int minimum = Collections.min(intList);
							
					try {
						
						// add text to an existing file using BufferedWriter AND PrintWriter
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The minimim of " + intList + " is: " + minimum);
						// Always close the objects:
						pr.close();
						br.close();
						object.close();
						System.out.println("Minimum calculation successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the mimimum calculation to the output file \n");
						e.printStackTrace();
					}	
					
				} if (array1[0].equals("max")) {
					

					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting an string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // done with conversion
					
			        int maximum = Collections.max(intList);
							
					try {
						
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The maximum of " + intList + " is: " + maximum);
						pr.close();
						br.close();
						object.close();
						System.out.println("Maximum calculation successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the maximum calculation to the output file \n");
						e.printStackTrace();
					}
					
				} if (array1[0].equals("avg")) {
					

					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting an string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // done with conversion
					
			        Double average = intList.stream().mapToInt(val -> val).average().orElse(0.0); // how to calculate average
							
					try {
							
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The average of " + intList + " is: " + average);
						pr.close();
						br.close();
						object.close();
						System.out.println("Average calculation successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the average calculation to the output file \n");
						e.printStackTrace();
					}
					
				
				} if (array1[0].equals("Sum")) {
					

					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting an string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // done with conversion
					
			        int sum = 0;
			        for (int i: intList) {
			            sum += i;
			        }
							
					try {
							
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The sum of " + intList + " is: " + sum);
						pr.close();
						br.close();
						object.close();
						System.out.println("Sum calculation successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the sum calculation to the output file \n");
						e.printStackTrace();
					}
				
				}if (array1[0].equals("P90")) { // string1.equals(string2) is how you compare strings, you don't use "=="
					
					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting a string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // conversion is done
			        
			        /*
			         How to calculate percentiles:
			         
			         1. Order all the values in the data set from smallest to largest.
					 2. Multiply x percent by the total number of values, n.
					 3. If the index obtained in Step 2 is not a whole number, round it up to the nearest whole number and go to Step 4a. If the index obtained in Step 2 is a whole number, go to Step 4b.
					 4a.Count the values in your data set from left to right (from the smallest to the largest value) until you reach the number indicated by Step 3. The corresponding value in your data set is the xth percentile.
					 4b.Count the values in your data set from left to right until you reach the number indicated by Step 2. The xth percentile is the average of that corresponding value in your data set and the value that directly follows it.
			         
			         */
					
			        Collections.sort(intList); // sorts the list in ascending order
			        
			        int listSize = intList.size();
			        double position = (90 * listSize)/100; // this gives the position of the 90th percentile
			        double roundedUpPosition = Math.ceil(position); // The function "Math.celi(position)" rounds up the value of 'position' if it isn't a whole no. if it is a whole no. it will stay as is
			        int percentile = intList.get((int)roundedUpPosition - 1); // putting "(int)" like that in front of a double value, converts the double to an integer. This line identifies the actual 90th percentile value; we subtract 1 because indexing starts counting at 0 (so the 1st number will be in position 0; and the nth number will be in position n-1)
							
					try {
						
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The 90th percentile of " + intList + " is: " + percentile);
						// Always close the objects:
						pr.close();
						br.close();
						object.close();
						System.out.println("90th percentile identification successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the 90th percentile identification to the output file \n");
						e.printStackTrace();
					}	
					
				} if (array1[0].equals("P70")) { // string1.equals(string2) is how you compare strings, you don't use "=="
					
					String [] array2 = array1[1].split(",");
					List <String> list = new ArrayList <> (Arrays.asList(array2)); // we're making a list solely composed of numbers
					
					// Converting a string list to an int list
					
			        ArrayList <Integer> intList = new ArrayList <Integer> (); // Create an empty ArrayList to hold Integers 
			        
			        for (int i = 0; i < list.size(); i++) {
			        	
			        	int intNum = Integer.parseInt(list.get(i));
			        	intList.add(intNum);
			        	
			        } // done with conversion
					
			        Collections.sort(intList); // sorts the list in ascending order
			        
			        int listSize = intList.size();
			        double position = (70 * listSize)/100; // this gives the position of the 70th percentile
			        double roundedUpPosition = Math.ceil(position); // The function "Math.celi(position)" rounds up the value of 'position' if it isn't a whole no. . If it is a whole no. it will stay as that whole no.
			        int percentile = intList.get((int)roundedUpPosition - 1); // putting "(int)" like that in front of a double value, converts the double to an integer. This line identifies the actual 70th percentile value; we're supposed to subtract 1 because indexing starts counting at 0
							
					try {
						
						File file = new File ("output.txt");
						FileWriter object = new FileWriter (file, true);
						BufferedWriter br = new BufferedWriter (object);
						PrintWriter pr = new PrintWriter(br);
						pr.println("The 70th percentile of " + intList + " is: " + percentile);
						// Always close the objects:
						pr.close();
						br.close();
						object.close();
						System.out.println("70th percentile identification successfully written to output file \n");
						
					}catch(IOException e) {
						System.out.println("Error in writing the 70th percentile identification to the output file \n");
						e.printStackTrace();
					}	
					
				}
				
			}
			
			myReader.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error in reading the input file");
			e.printStackTrace();
			
		}
		
	}
	
}