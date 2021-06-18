/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package linkedlist;

/**
 * 
 * @author ramveersingh
 */
public class LinkedListCustom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(12);
		head.next.next = new Node(21);
		head.next.next.next = new Node(34);
		head.next.next.next.next = new Node(0);
		head.next.next.next.next.next = new Node(1);
		// display(head);
		//// listLength(head);
		// printnthElement(head,3);
		// insertStarting(head,89);
		// insertEnd(head, 81);
		// insertAfterKthPos(head, 2);
		// deleteFrom1st(head);
		//deleteLastNode(head);
		//deleteFromKthPos(head,2);
		scanCircularLinkedList(head);

	}

	public static void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();

	}

	public static int listLength(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		System.out.println("Length of linked list is: " + count);
		return count;
	}

	public static Node printnthElement(Node head, int n) {
		// if(n<=0){
		// return;
		// }
		Node temp = head;
		int count = 0;
		while (temp != null && count < n) {
			temp = temp.next;
			count++;
		}
		System.out.println("count is : " + count);
		System.out.println("nth node is : " + temp.data);
		return temp;
	}

	/**
	 * add, insert and delete operations
	 */

	/**
	 * 
	 * INSERT
	 * --------------------------------------------------------------------------
	 * 
	 * @param head
	 * @param data
	 * @return
	 */

	public static Node insertStarting(Node head, int data) {
		System.out.println("before new node inserted---");
		display(head);
		Node temp = head;
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		System.out.println("after new node inserted---");
		display(head);
		return head;
	}

	public static Node insertEnd(Node head, int data) {
		System.out.println("before new node inserted---");
		display(head);
		Node temp = head;
		Node newNode = new Node(100);
		while (head.next != null) {
			head = head.next;
		}
		head.next = newNode;
		System.out.println("after new node inserted---");
		display(temp);
		return temp;
	}

	private static Node insertAfterKthPos(Node head, int k) {
		System.out.println("before new node inserted at " + k + "th position");
		display(head);
		Node temp = head;
		int count = 0;
		Node newNode = new Node(101);
		while (head.next != null && count < k) {
			head = head.next;
			count++;
		}
		Node t = head;
		Node p = head.next;
		t.next = newNode;
		newNode.next = p;
		System.out.println("after new node inserted at " + k + "th position");
		display(temp);
		return temp;
	}

	/**
	 * DELETE---------------------------------------------------------------------------------
	 */

	public static Node deleteFrom1st(Node head) {
		display(head);
		Node temp = head;
		head = head.next;
		display(head);
		return head;
	}

	public static Node deleteLastNode(Node head) {
		display(head);
		Node temp = head;
		Node p = null;
		while (head.next != null) {
			p = head;
			head = head.next;
		}
		p.next = null;
		display(temp);
		return temp;
	}
	
	public static Node deleteFromKthPos(Node head, int k){
		display(head);
		Node temp  = head;
		int count = 0;
		Node p = null;
		while(head.next!=null && count<k){
			p  = head;
			head = head.next;
			count++;
		}
		p.next = head.next;
		display(temp);
		return temp;
	}
	
	public static void scanCircularLinkedList(Node head){
		int headValue = head.data;
		Node temp = head;
		temp = temp.next;
		System.out.print(headValue+"->");
		while(temp.next!=null && temp.data!=headValue){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();
		
	}
	

}
