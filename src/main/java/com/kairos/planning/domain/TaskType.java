package com.kairos.planning.domain;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("TaskType")
public class TaskType {

	private Long id;
	private String code;
	private String title;
	private Long baseDuration;
	private List<Skill> requiredSkillList=new ArrayList<Skill>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Long baseDuration) {
		this.baseDuration = baseDuration;
	}
	public List<Skill> getRequiredSkillList() {
		return requiredSkillList;
	}
	public void setRequiredSkillList(List<Skill> requiredSkillList) {
		this.requiredSkillList = requiredSkillList;
	}
	
	
}
