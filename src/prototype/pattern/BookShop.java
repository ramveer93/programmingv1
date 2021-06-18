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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ramveersingh
 */
public class BookShop implements Cloneable{
private String shopName;
private List<Book> books = new ArrayList<>();
public String getShopName() {
	return this.shopName;
}
public void setShopName(String shopName) {
	this.shopName = shopName;
}
public List<Book> getBooks() {
	return this.books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}
@Override
public String toString() {
	return "BookShop [shopName=" + shopName + ", books=" + books + "]";
}

public void loadBooks(){
	for(int i=0;i<10;i++){
		Book b = new Book();
		b.setBid(i);
		b.setBname("book"+i);
		books.add(b);
	}
}

protected BookShop clone() throws CloneNotSupportedException{
	BookShop b = new BookShop();
	
    for(Book bk: books){
    	b.getBooks().add(bk);
    }
	return b;
	//return super.clone();
}

}
