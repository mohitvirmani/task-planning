package com.kairos.planning.solution;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.persistence.xstream.api.score.buildin.hardsoft.HardSoftScoreXStreamConverter;

import com.kairos.planning.domain.Citizen;
import com.kairos.planning.domain.Employee;
import com.kairos.planning.domain.Location;
import com.kairos.planning.domain.Skill;
import com.kairos.planning.domain.Task;
import com.kairos.planning.domain.TaskType;
import com.kairos.planning.domain.Vehicle;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@PlanningSolution
public class TaskPlanningSolution {
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public List<Citizen> getCitizenList() {
		return citizenList;
	}

	public void setCitizenList(List<Citizen> citizenList) {
		this.citizenList = citizenList;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<TaskType> getTaskTypeList() {
		return taskTypeList;
	}

	public void setTaskTypeList(List<TaskType> taskTypeList) {
		this.taskTypeList = taskTypeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "vehicleRange")
	private List<Vehicle> vehicleList;
	@ProblemFactCollectionProperty
	private List<Citizen> citizenList;
	@PlanningEntityCollectionProperty
	@ValueRangeProvider(id = "taskRange")
	private List<Task> taskList;
	//@ProblemFactCollectionProperty
	private List<TaskType> taskTypeList;
	//@ProblemFactCollectionProperty
	private List<Employee> employeeList;
	//@ProblemFactCollectionProperty
	private List<Skill> skillList;
	@ProblemFactCollectionProperty
	private List<Location> locationList;
	
	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	@PlanningScore
    @XStreamConverter(HardSoftScoreXStreamConverter.class)
    private HardSoftScore score;
	
}
