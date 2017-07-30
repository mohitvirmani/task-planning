package com.kairos.planning.domain;

public class Citizen {
	private String name;
	public String getName() {
		return name;
	}
	public Citizen(String name) {
		this.name=name;
	}
	public String toString(){
		return name;
	}

}
