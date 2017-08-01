package com.kairos.planning.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.AnchorShadowVariable;
import org.optaplanner.core.api.domain.variable.CustomShadowVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableGraphType;
import org.optaplanner.core.api.domain.variable.PlanningVariableReference;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Task")
@PlanningEntity(difficultyComparatorClass = TaskDifficultyComparator.class)
public class Task  extends TaskOrVehicle{

	private TaskType taskType;
	// Planning variables: changes during planning, between score calculations.
    @PlanningVariable(valueRangeProviderRefs = {"taskRange","vehicleRange"},
            graphType = PlanningVariableGraphType.CHAINED)
    private TaskOrVehicle previousTaskOrVehicle;
    @AnchorShadowVariable(sourceVariableName = "previousTaskOrVehicle")
    //@CustomShadowVariable(variableListenerClass = LocationVariableUpdaterListener.class,
     ///       sources = {@PlanningVariableReference(variableName = "previousTaskOrVehicle")})
    private Vehicle vehicle;
    @PlanningVariable(valueRangeProviderRefs = {"employeeRange"})
    private Employee employee;
    private boolean locked;
    private int indexInTaskType;
    private int readyTime;
	public int getReadyTime() {
		return readyTime;
	}
	public void setReadyTime(int readyTime) {
		this.readyTime = readyTime;
	}
	public int getIndexInTaskType() {
		return indexInTaskType;
	}
	public void setIndexInTaskType(int indexInTaskType) {
		this.indexInTaskType = indexInTaskType;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public Vehicle getVehicle() {
		return vehicle;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public TaskOrVehicle getPreviousTaskOrVehicle() {
		return previousTaskOrVehicle;
	}
	public void setPreviousTaskOrVehicle(TaskOrVehicle previousTaskOrVehicle) {
		this.previousTaskOrVehicle = previousTaskOrVehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	private Citizen citizen;
	private String priority;
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    public String getLabel(){
    	return id+"";
    }
    private Long duration;
    public Long getDuration() {
		return taskType.getBaseDuration();
	}
	private Location location;
	
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public Location getLocation() {
		return location;
	}
	
	public long getDistanceFromPreviousTaskOrVehicle() {
        if (previousTaskOrVehicle == null) {
            throw new IllegalStateException("This method must not be called when the previousTaskOrVehicle ("
                    + previousTaskOrVehicle + ") is not initialized yet.");
        }
        return getDistanceFrom(previousTaskOrVehicle);
    }
	private long getDistanceFrom(TaskOrVehicle previousTaskOrVehicle) {
		return previousTaskOrVehicle.getLocation().getDistanceFrom(this.getLocation());
	}
	public String toString(){
		return id+"-"+priority+"-"+getDuration()+"-"+location.name+"-"+taskType.getRequiredSkillList();
	}
	public int getMissingSkillCount() {
        if (employee == null) {
            return 0;
        }
        int count = 0;
        for (Skill skill : taskType.getRequiredSkillList()) {
            if (!employee.getSkillSet().contains(skill)) {
                count++;
            }
        }
        return count;
    }
	public Long getEmployeeId(){
		return employee.getId();
	}
}

