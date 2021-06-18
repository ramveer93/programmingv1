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
 * 
 *      computer 
 *     /                   \
 *    cabinate             Perifarol
 *   /      \                    /     \
 *   HD     Mother Board         mouse  keyboard
 *          /         \
 *          Ram       CPU
 */
public class CompositeTest {

	public static void main(String args[]){
		Component hd = new Leaf(4000,"HD");
		Component ram = new Leaf(3000,"RAM");
		Component cpu = new Leaf(14000,"CPU");
		Component mouse = new Leaf(300,"MOUSE");
		Component keyboard = new Leaf(500,"KEYBOARD");
		
		
		Composite mboard  =new Composite("MotherBoard");
		Composite cabinate  =new Composite("cabinate");
		Composite peri  =new Composite("perifarol");
		Composite computer  =new Composite("computer");
		
		/**
		 * make a mother board
		 */
		mboard.addComponent(ram);
		mboard.addComponent(cpu);
		
		/**
		 * make a cabinate
		 */
		cabinate.addComponent(hd);
		cabinate.addComponent(mboard);
		
		/**
		 * make peri
		 */
		peri.addComponent(mouse);
		peri.addComponent(keyboard);
		/**
		 * make a computer
		 */
		computer.addComponent(peri);
		computer.addComponent(cabinate);

	   computer.shotPrice();
		
		
	}
	
	
	
	
	
	
}
