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
public class Book {
private String bname;
private int bid;
public String getBname() {
	return this.bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public int getBid() {
	return this.bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
@Override
public String toString() {
	return "Book [bname=" + bname + ", bid=" + bid + "]";
}

}
