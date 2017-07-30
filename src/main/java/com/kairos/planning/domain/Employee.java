package com.kairos.planning.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//@PlanningEntity
@XStreamAlias("Employee")
public class Employee {

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private Long id;
	private String name;
	private Set<Skill> skillSet;
	private Map<Citizen, Affinity> affinityMap= new LinkedHashMap<Citizen, Affinity>();
	private List<AvailabilityRequest> availabilityList;
	public List<AvailabilityRequest> getAvailabilityList() {
		return availabilityList;
	}
	public void setAvailabilityList(List<AvailabilityRequest> availabilityList) {
		this.availabilityList = availabilityList;
	}
	public Map<Citizen, Affinity> getAffinityMap() {
		return affinityMap;
	}
	public void setAffinityMap(Map<Citizen, Affinity> affinityMap) {
		this.affinityMap = affinityMap;
	}
	public Set<Skill> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAvailableMinutes(){
		long mins=0;
		for(AvailabilityRequest availabilityRequest:availabilityList){
			mins+=availabilityRequest.getMinutes();
		}
		return mins;
	}
	
	public String toString(){
		return id+"-"+name+"-"+skillSet+"-"+getAvailableMinutes();
	}
	public Affinity getAffinity(Citizen citizen) {
        Affinity affinity = affinityMap.get(citizen);
        if (affinity == null) {
            affinity = Affinity.NONE;
        }
        return affinity;
    }
}
