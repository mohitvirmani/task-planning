package com.kairos.planning.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Location")
public class Location {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	protected String name;
    protected double latitude;
    protected double longitude;

    public Location() {
    }

    public Location(String name, double latitude, double longitude) {
    	this.name=name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

	public long getDistanceFrom(Location location) {
		double latitudeDifference = location.latitude - latitude;
        double longitudeDifference = location.longitude - longitude;
        return new Double(Math.sqrt(
                (latitudeDifference * latitudeDifference) + (longitudeDifference * longitudeDifference))).longValue();
	}
	public String toString(){
		return name+"-"+latitude+"-"+longitude;
	}
}
