package org.kh.member.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
	}
	public Controller getController(String path) {
		System.out.println(path + " ---> 검색");
		return mappings.get(path);
	}
}
