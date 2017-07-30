package com.kairos.planning.domain;

public class Location {
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
