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

/**
 * 
 * @author ramveersingh
 */
public class Block {
	public static void main(String args[]) {
		int t;
		int n;
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			getMaxHeight(n);
		}
	}

	private static void getMaxHeight(int n) {
		int i = 0;
		int blocks = 0;
		while (i <= n) {
			blocks += i;
			if (blocks >n) {
				System.out.println(i-1);
				blocks = 0;
				break;
			}else if(blocks==n){
				System.out.println(i);
				break;
			}
			i++;
		}

	}
}
