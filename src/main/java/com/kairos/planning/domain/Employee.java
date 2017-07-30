package com.kairos.planning.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.optaplanner.core.api.domain.entity.PlanningEntity;

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
	private Map<Citizen, Affinity> affinityMap= new LinkedHashMap<Citizen, Affinity>();;
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
	
	public String toString(){
		return id+"-"+name+"-"+skillSet;
	}
	public Affinity getAffinity(Citizen citizen) {
        Affinity affinity = affinityMap.get(citizen);
        if (affinity == null) {
            affinity = Affinity.NONE;
        }
        return affinity;
    }
}
