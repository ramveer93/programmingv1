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
public class PrototypeTest {

	public static void main(String [] args) throws CloneNotSupportedException{
		BookShop bs =new BookShop();
		bs.setShopName("Novality");
		bs.loadBooks();
		
		BookShop bs2 = (BookShop)bs.clone();
		bs.getBooks().remove(0);
		System.out.println("First"+bs);
		//bs2.loadBooks();
		System.out.println("second"+bs2);
		
		
	}
}
