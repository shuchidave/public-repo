package com.courseHero;

import java.text.NumberFormat;
import java.text.ParsePosition;

	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 */
	/*

	Course Selection
	On our site, students can input the courses they are taking in any combination of a
	Department+Course Number followed by Semester+Year. A department is always one or more
	alphabetic characters, and a course number is always one or more numeric characters.
	Semester is either an abbreviation or a word, and a Year is either two digits or four digits.
	Semester and Year can be swapped in position. There is always a space between
	Department+Course Number and Semester+Year. For example:
	CS111 2016 Fall
	CS-111 Fall 2016
	MATH 123 2015 Spring

	Semesters could be abbreviated as: F (Fall), W (Winter), S (Spring), Su (Summer)


	Part 1: Data Normalization
	Write code that, for each input format, identify the Department, Course Number, Year and
	Semester. You should include input validation in your solution.
	For example, all of the previous examples should yield the following output:
	● Department: CS
	● Course Number: 111
	● Year: 2016
	● Semester: Fall
	*/
	class CourseSelection {
	  public static void main(String[] args) {
	    isValidCourse("CS:123 Fall 2016");
	    isValidCourse("CS-111 Fall 2016");
	    isValidCourse("MATH 123 2015 Spring");
	    isValidCourse("CS:123Fall 2016");

	  }
	  
	  
	  public static void isValidCourse(String str){
	    System.out.println("---------------------------------");
	    System.out.println("---------------------------------");
	    
	    System.out.println("Input: "+str);
	    System.out.println("---------------------------------");
	    String dept = "";
	    String courseNum = "";
	    String sem = "";
	    String year = "";
	    
	    String[] arr = str.split("\\s+");
	    if(arr.length < 3 || arr.length > 4){
	      System.err.println("Invalid Input");
	      return;
	    }
	    
	    if(isNumeric(arr[arr.length-1]) && isAlpha(arr[arr.length-2])){
	      year = arr[arr.length-1];
	      sem = arr[arr.length-2];
	    }else if(isAlpha(arr[arr.length-1]) && isNumeric(arr[arr.length-2])){
	      sem = arr[arr.length-1];
	      year = arr[arr.length-2];
	    }else{
	      System.err.println("Invalid Input");
	      return;
	    }
	    
	    String course = "";
	    if(arr.length == 3){
	      course = arr[0];
	    }else if(arr.length == 4){
	      course = arr[0]+arr[1];
	    }
	    
	    int count = 0;
	    
	    while(isAlpha(String.valueOf(course.charAt(count)))){
	      dept+= course.charAt(count);
	      count++;
	    }
	    count = course.length()-1;
	    
	    while(isNumeric(String.valueOf(course.charAt(count)))){
	      courseNum = course.charAt(count)+courseNum;
	      count--;
	    }
	    
	    System.out.println("Department: "+dept);
	    System.out.println("Course Number: "+courseNum);
	    System.out.println("Year: "+year);
	    System.out.println("Semester: "+sem);
	  }
	  
	  public static boolean isNumeric(String str)
	  {
	    NumberFormat formatter = NumberFormat.getInstance();
	    ParsePosition pos = new ParsePosition(0);
	    formatter.parse(str, pos);
	    return str.length() == pos.getIndex();
	  }

	  public static boolean isAlpha(String name) {
	      return name.matches("[a-zA-Z]+");
	  }

	}

	/*
	*
	* Areas where I got stuck:
	* -How to find whether a string is numeric or not
	* -How to find whether a string is having only alpha characters
	*
	*/
	
	
	
	
	/*
	 * import java.io.*;
import java.util.*;
import java.text.NumberFormat;
import java.text.ParsePosition;


 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 

Course Selection
On our site, students can input the courses they are taking in any combination of a
Department+Course Number followed by Semester+Year. A department is always one or more
alphabetic characters, and a course number is always one or more numeric characters.
Semester is either an abbreviation or a word, and a Year is either two digits or four digits.
Semester and Year can be swapped in position. There is always a space between
Department+Course Number and Semester+Year. For example:
CS111 2016 Fall
CS-111 Fall 2016
MATH 123 2015 Spring

Semesters could be abbreviated as: F (Fall), W (Winter), S (Spring), Su (Summer)


Part 1: Data Normalization
Write code that, for each input format, identify the Department, Course Number, Year and
Semester. You should include input validation in your solution.
For example, all of the previous examples should yield the following output:
● Department: CS
● Course Number: 111
● Year: 2016
● Semester: Fall
class Solution {
  public static void main(String[] args) {
   // isValidCourse("CS:123 Fall 2016");
    //isValidCourse("CS-111 Fall 2016");
    //isValidCourse("MATH 123 2015 Spring");
    isValidCourse("CS:123 F 2016");
    //isValidCourse("CS:123Fall 2016");
    isValidCourse("CS:123 S 2016");

  }
  
  //public enum Semester {
   //  F ("Fall"), W ("Winter"), S ("Spring"), Su ("Summer") 
  //}
  
  
  public static String F="Fall";
  public static String W="Winter";
  public static String S="Spring";
  public static String Su="Summer";
  
  
  public static void isValidCourse(String str){
    System.out.println("---------------------------------");
    System.out.println("---------------------------------");
    
    System.out.println("Input: "+str);
    System.out.println("---------------------------------");
    String dept = "";
    String courseNum = "";
    String sem = "";
    String year = "";
    
    String[] arr = str.split("\\s+");
    if(arr.length < 3 || arr.length > 4){
      System.err.println("Invalid Input");
      return;
    }
    
    if(isNumeric(arr[arr.length-1]) && isAlpha(arr[arr.length-2])){
      year = arr[arr.length-1];
      sem = arr[arr.length-2];
    }else if(isAlpha(arr[arr.length-1]) && isNumeric(arr[arr.length-2])){
      sem = arr[arr.length-1];
      year = arr[arr.length-2];
    }else{
      System.err.println("Invalid Input");
      return;
    }
    
    String course = "";
    if(arr.length == 3){
      course = arr[0];
    }else if(arr.length == 4){
      course = arr[0]+arr[1];
    }
    
    int count = 0;
    
    while(isAlpha(String.valueOf(course.charAt(count)))){
      dept+= course.charAt(count);
      count++;
    }
    count = course.length()-1;
    
    while(isNumeric(String.valueOf(course.charAt(count)))){
      courseNum = course.charAt(count)+courseNum;
      count--;
    }
    
    switch(sem){
      case "F":
          sem=F;
          break;
      case "S":
        sem=S;
          break;
      case "Su":
        sem=Su;
          break;
      case "W":
        sem=W;
          break;
      default:
        sem=sem;
    }
    
    System.out.println("Department: "+dept);
    System.out.println("Course Number: "+courseNum);
    System.out.println("Year: "+year);
    System.out.println("Semester: "+sem);
  }
  
  public static boolean isNumeric(String str)
  {
    NumberFormat formatter = NumberFormat.getInstance();
    ParsePosition pos = new ParsePosition(0);
    formatter.parse(str, pos);
    return str.length() == pos.getIndex();
  }

  public static boolean isAlpha(String name) {
      return name.matches("[a-zA-Z]+");
  }

}

*
* Areas where I got stuck:
* -How to find whether a string is numeric or not
* -How to find whether a string is having only alpha characters
*
	
*/