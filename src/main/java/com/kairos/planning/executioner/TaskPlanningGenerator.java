package com.kairos.planning.executioner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kairos.planning.domain.Citizen;
import com.kairos.planning.domain.Location;
import com.kairos.planning.domain.Task;
import com.kairos.planning.domain.Vehicle;
import com.kairos.planning.solution.TaskPlanningSolution;

public class TaskPlanningGenerator {
	public TaskPlanningSolution loadUnsolvedSolution(){
		TaskPlanningSolution unresolvedSolution = new TaskPlanningSolution();
		unresolvedSolution.setTaskList(generateTasks());
		unresolvedSolution.setVehicleList(generateVehicleList());
		unresolvedSolution.setCitizenList(generateCitizenList());
		unresolvedSolution.setLocationList(generateLocationList());
		return unresolvedSolution;
	}

	private List<Vehicle> generateVehicleList() {
		List<Vehicle> vehicleList= new ArrayList<Vehicle>();
		for(int i=0;i<=2;i++){
			Vehicle vehicle= new Vehicle();
			vehicle.setId(200000l+i);
			vehicle.setLocation(generateLocationList().get(0));
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}

	private List<Task> generateTasks() {
		List<Task> taskList= new ArrayList<Task>();
		List<Citizen> citizens= generateCitizenList();
		List<Location> locations= generateLocationList();
		for(int i=0;i<=5;i++){
			Task task= new Task();
			task.setId(100000l+i);
			task.setPriority(new Long(i));
			task.setDuration(10L*i);
			task.setCitizen(citizens.get(i));
			task.setLocation(locations.get(i));
			taskList.add(task);
		}
		return taskList;
	}

	private List<Location> generateLocationList() {
		List<Location> locations= new ArrayList<Location>();
		locations.add(new Location("Oodles1",1100,2200));
		locations.add(new Location("Oodles2",2200,2400));
		locations.add(new Location("Oodles3",1300,2600));
		locations.add(new Location("Oodles4",1500,2200));
		locations.add(new Location("Oodles5",1500,2200));
		locations.add(new Location("Oodles6",1600,4200));
		return locations;
	}

	private List<Citizen> generateCitizenList() {
		List<Citizen> citizens= new ArrayList<Citizen>();
		citizens.add(new Citizen("Sachin Verma"));
		citizens.add(new Citizen("Ulrik"));
		citizens.add(new Citizen("Arvind"));
		citizens.add(new Citizen("Mohit"));
		citizens.add(new Citizen("Rijul"));
		citizens.add(new Citizen("Kunal"));
		return citizens;
	} 
}
