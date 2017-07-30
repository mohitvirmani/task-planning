package com.kairos.planning.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.InverseRelationShadowVariable;

@PlanningEntity
public abstract class TaskOrVehicle {

	// Shadow variables
    @InverseRelationShadowVariable(sourceVariableName = "previousTaskOrVehicle")
    protected Task nextTask;
    
    public abstract Vehicle getVehicle();
    
    public abstract Location getLocation();
}
