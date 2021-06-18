/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package javabasic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author ramveersingh
 */
public class TryWithResources {

	public static void main(String args[]) {
		//printFile();
		//trywithres();
		customEx();
	}
	

	private static void printFile() {
		InputStream is = null;
		try {
			is = new FileInputStream("/Users/ramveersingh/Documents/workspace-sts-3.8.4.RELEASE/utility/kanimochi/javabasic/test.txt");
			int data = is.read();
			while (data != -1) {
				System.out.print((char) data);
				data = is.read();
			}
		} catch (IOException e) {
			System.out.println("exception in catch.....");
			e.printStackTrace();
			
		} finally {
			System.out.println("in finally.....");
			if (is != null) {
				try {
					is.close();
					System.out.println("is is closed.....");
				} catch (IOException e) {
					System.out.println("exception in finally.....");
					e.printStackTrace();
				}
			}else{
				System.out.println("is is null.....");
			}
		}
	}
	
	private static void trywithres(){
		try(FileInputStream fis = new FileInputStream("/Users/ramveersingh/Documents/workspace-sts-3.8.4.RELEASE/utility/kanimochi/javabasic/test.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);){
			int data = bis.read();
			while (data != -1) {
				System.out.print((char) data);
				data = bis.read();
			}
			int k = 90/0;
		}catch(Exception e){
			System.out.println("exception in catch.....");
			e.printStackTrace();
		}finally{
			System.out.println("in finally.....");
		}
	}
	
	
	private static void customEx(){
		try(MyAutoClosable cls = new MyAutoClosable()){
			cls.res();
		}catch(Exception e){
			System.out.println("Exception in catch.....");
		}finally{
			System.out.println("in finally....");
		}
	}
	
}
class MyAutoClosable implements AutoCloseable{

	public void res(){
		System.out.println("another method inside myautoCloseable");
	}
	@Override
	public void close() throws Exception {
		System.out.println("MyAutoCloseable(): closed");
		
	}
	
}
