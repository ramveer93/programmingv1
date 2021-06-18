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
public class Subject {
 private String name;
 public Subject(String name){
	 this.name = name;
 }
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Subject [name=" + name + "]";
}
 
}
