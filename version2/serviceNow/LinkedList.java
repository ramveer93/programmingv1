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
public class LinkedList {
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	/**
	 * reverse a linkedList
	 * @param head
	 * @return
	 */
	private  static Node reverse(Node head){
		Node prev = null;
		Node next = null;
		Node current = head;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	private static void print(Node head){
		while(head!=null){
			System.out.println(head.data+" ");
			head = head.next;
		}
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);
		System.out.println("given ll is ");
		print(head);
		head = reverse(head);
		System.out.println("reversed ll ");
		print(head);
	}

}
