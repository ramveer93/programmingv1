/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package serviceNow;

/**
 * 
 * @author ramveersingh
 */
public class StackNode {
   int data;
   StackNode next;
   public StackNode(int data){
	   this.data = data;
	   this.next = null;
   }
   
   public static void main(String args[]){
	   Stack s =new Stack();
	   s.push(1); 
       s.push(2); 
       s.push(3); 
       s.push(4); 
       System.out.println("Original Stack"); 
       s.display(); 
       // reverse 
       s.reverse(); 
       System.out.println("Reversed Stack"); 
       s.display(); 
   }
}
class Stack{
	StackNode top;
	public void push(int data){
		if(top==null){
			StackNode  s = new StackNode(data);
			top = s;
			return;
		}
		StackNode  s = new StackNode(data);
		s.next = this.top;
		this.top = s;
	}
	public StackNode pop(){
		StackNode s = this.top;
		this.top = this.top.next;
		return s;
	}
	public void display(){
		StackNode s = this.top;
		while(s!=null){
			System.out.println(" "+s.data);
			s = s.next;
		}
	}
	
	public void reverse(){
		StackNode prev, curr, next;
		curr = this.top;
		prev = null;
		next = null;
		
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.top = prev;
	}
}
