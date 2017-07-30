package com.kairos.planning.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Availability")
public class AvailabilityRequest {

	private Long id;
	private String startTimeString;
	private String endTimeString;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartTimeString() {
		return startTimeString;
	}
	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}
	public String getEndTimeString() {
		return endTimeString;
	}
	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}
	public long getMinutes(){
		//08/06/2017 11:00:00
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime startDateTime = LocalDateTime.parse(startTimeString, formatter);
		LocalDateTime endDateTime = LocalDateTime.parse(endTimeString, formatter);
		return ChronoUnit.MINUTES.between(startDateTime,endDateTime);
	}
	@Override
	public String toString() {
		return "AvailabilityRequest [startTimeString=" + startTimeString + ", endTimeString=" + endTimeString+ "]";
	}
}
