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
public class Student implements Cloneable{
private String name;
private int rollNo;
private Subject subject;
  public Student(String name,int rollNo,String subject){
	  super();
	  this.name = name;
	  this.rollNo = rollNo;
	  this.subject = new Subject(subject);
  }
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}
public int getRollNo() {
	return this.rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public Subject getSubject() {
	return this.subject;
}
public void setSubject(Subject subject) {
	this.subject = subject;
}

/**
 * shallow copy
 */
//@Override
//protected Object clone() throws CloneNotSupportedException{
//	return super.clone();
//}

///**
// * deep copy
// */
@Override
protected Object clone() throws CloneNotSupportedException{
	Student s = new Student(this.name,this.rollNo,this.subject.getName());
	return s;
}



@Override
public String toString() {
	return "Student [name=" + name + ", rollNo=" + rollNo + ", subject=" + subject + "]";
}


}
