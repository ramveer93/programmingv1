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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ramveersingh
 */
public class ListDemo {
public static void main(String args[]){
	List l = new ArrayList();
	l.add(1);
	l.add(2);
	l.add(3);
	List l2  = new ArrayList(l);
	//l2 = l;
	if(l2==l){
		System.out.println("true");
	}else{
		System.out.println("false");
	}
}
}
