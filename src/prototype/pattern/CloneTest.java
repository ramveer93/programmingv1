/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package prototype.pattern;

/**
 * 
 * @author ramveersingh
 */
public class CloneTest {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
//		Subject originalSub = new Subject("Math");
//		Student originalStudent = new Student("Ramveer", 110, originalSub.getName());
//		System.out.println("Original student----------------"+originalStudent);
//		
//		
//		Student cloneStudent  =  (Student) originalStudent.clone();
//		System.out.println("Cloned student----------------"+cloneStudent);
//		
//		
//		originalStudent.setName("tanu");
//		originalStudent.getSubject().setName("Electrical");
//		
//		
//		System.out.println("Original student after change----------------"+originalStudent);
//		System.out.println("Cloned student after change----------------"+cloneStudent);
//		if(originalStudent==cloneStudent){
//			System.out.println("true");
//		}else{
//			System.out.println("false");
//		}
		
		Student cls = new Student("anil", 112, "Physics");
		Student cls2 = cls;
		if(cls==cls2){
			System.out.println("true");
		}else{
			System.out.println("false");
		}

		Student cls3 = new Student("manoj", 113, "iti");
		Student cls4 = (Student)cls3.clone();
		if(cls3==cls4){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
	}

}
