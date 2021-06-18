/*
 * Copyright (c) 2018 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package gfg.amazon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author ramveersingh
 */
public class SpecialStack {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			Stack<Integer> s  =new Stack<>();
			GFG g =new GFG();
			//while(!g.isFull(s,n)){
				//g.push(sc.nextInt());
			Stack<Integer> actual = new Stack<>();
			Stack<Integer> aux = new Stack<>();
			for(int i=0;i<n;i++){
				int a = sc.nextInt();
				g.push(a,actual,aux);
			}
			//}
			System.out.println(g.min(aux));
			System.out.println("min: "+g.min2(actual));
		}
	}
}

class GFG{
	public void push(int a, Stack<Integer> actual, Stack<Integer> aux){
		actual.push(a);
		if(aux.isEmpty()){
			aux.push(a);
		}else{
			int x = aux.pop();
			if(a<x){
				aux.push(a);
			}else{
				aux.push(x);
			}
		}
		
	}
	
	public int min2(Stack<Integer> s){
		int current;
		int min  = Integer.MAX_VALUE;
		while(!s.isEmpty()){
			current = s.pop();
			if(current<min){
				min = current;
			}
		}
		return min;
		
	}
	public int pop(Stack<Integer> s,Stack<Integer> aux){
		if(s.size()!=0){
			aux.pop();
			return s.pop();
		}else {
			return -1;
		}
	}
	
	public boolean isEmpty(Stack<Integer> s){
		return s.isEmpty();
	}
//	public boolean isFull(Stack<Integer> s){
//		return true;
//	}
	
	public int min(Stack<Integer> aux){
		return aux.pop();
		/**
		 * push(x) : 
		 * 1. push x to  actual stack 
		 * 2. compare x with the top element of aux stack, pop from aux: y = aux.pop()
		 *    1. x>y: push y to aux: aux.push(y);
		 *    2. x<y: push x to aux: aux.push(x)
		 *    
		 *  min(s): return s.pop();
		 *  pop(s): pop from aux and pop from actual and return it
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}