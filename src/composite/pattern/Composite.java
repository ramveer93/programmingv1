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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ramveersingh
 */
public class Composite  implements Component {
    String name;
    public Composite(String name){
    	super();
    	this.name = name;
    }
	List<Component> components = new ArrayList<>();

	public void addComponent(Component com){
		components.add(com);
	}
	
	@Override
	public void shotPrice() {
		System.out.println(name);
		for(Component c:components){
			c.shotPrice();
		}
		
	}

}
