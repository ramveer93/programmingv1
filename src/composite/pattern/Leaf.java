/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package composite.pattern;

/**
 * 
 * @author ramveersingh
 */
public class Leaf implements Component {

	String name;
	int price;

	Leaf(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	@Override
	public void shotPrice() {
		System.out.println(name + ": " + price);

	}

}
