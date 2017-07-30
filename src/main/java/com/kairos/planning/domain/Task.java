package com.kairos.planning.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.AnchorShadowVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableGraphType;

@PlanningEntity
public class Task  extends TaskOrVehicle{

	private TaskType taskType;
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
	private Long priority;
	public Long getPriority() {
		return priority;
	}
	public void setPriority(Long priority) {
		this.priority = priority;
	}
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	// Planning variables: changes during planning, between score calculations.
    @PlanningVariable(valueRangeProviderRefs = {"vehicleRange", "taskRange"},
            graphType = PlanningVariableGraphType.CHAINED)
    private TaskOrVehicle previousTaskOrVehicle;
    @AnchorShadowVariable(sourceVariableName = "previousTaskOrVehicle")
    private Vehicle vehicle;
	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return vehicle;
	}
    public String getLabel(){
    	return id+"";
    }
    private Long duration;
    public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
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
		return id+"-"+priority+"-"+duration+"-"+vehicle;
	}
}
