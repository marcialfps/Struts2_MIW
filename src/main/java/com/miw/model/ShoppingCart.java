package com.miw.model;

import java.util.HashMap;

public class ShoppingCart {

	private HashMap<String, Integer> list;
	
	public ShoppingCart() {
		super();
		this.list = new HashMap<String, Integer>();
	}

	public HashMap<String, Integer> getList() {
		return list;
	}

	public void setList(HashMap<String, Integer> list) {
		this.list = list;
	}
	
	public void add(String element) {
		if(list.containsKey(element)) {
			int quantity = list.get(element) + 1;
			list.put(element, quantity);
		} else {
			list.put(element,  1);
		}
	}
}
