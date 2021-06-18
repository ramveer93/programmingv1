/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package Builder.pattern;

/**
 * 
 * @author ramveersingh
 */
public class Phone {
private String os;
private String processor;
private int ram;
private int battery;
private double screenSize;
/**
 * @param os
 * @param processor
 * @param ram
 * @param battery
 * @param screenSize
 */
public Phone(String os, String processor, int ram, int battery, double screenSize) {
	super();
	this.os = os;
	this.processor = processor;
	this.ram = ram;
	this.battery = battery;
	this.screenSize = screenSize;
}
@Override
public String toString() {
	return "Phone [os=" + os + ", processor=" + processor + ", ram=" + ram + ", battery=" + battery + ", screenSize="
			+ screenSize + "]";
}

}
