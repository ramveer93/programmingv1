/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package utility;

/**
 * 
 * @author ramveersingh
 */
public class FirstUseCaseVo {
private String tagid;
private int day;
private double v;

public FirstUseCaseVo(String tagid,int day,double v){
	this.tagid = tagid;
	this.day = day;
	this.v = v;
}

public double getV() {
	return this.v;
}
public void setV(double v) {
	this.v = v;
}
public int getDay() {
	return this.day;
}
public void setDay(int day) {
	this.day = day;
}
public String getTagid() {
	return this.tagid;
}
public void setTagid(String tagid) {
	this.tagid = tagid;
}
@Override
public String toString() {
	return "FirstUseCaseVo [tagid=" + tagid + ", day=" + day + ", v=" + v + "]";
}

}
