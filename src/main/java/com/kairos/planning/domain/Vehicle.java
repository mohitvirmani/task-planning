package com.kairos.planning.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Vehicle")
public class Vehicle extends TaskOrVehicle {
	private Long id;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Vehicle getVehicle() {
		return this;
	}

	public String getLabel() {
		return id + "";
	}

	private Location location;

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	public String toString() {
		return id + "-" + type;
	}
}
