package com.kairos.planning.executioner;

import java.util.ArrayList;
import java.util.List;

import com.kairos.planning.domain.Affinity;
import com.kairos.planning.domain.AvailabilityRequest;
import com.kairos.planning.domain.Citizen;
import com.kairos.planning.domain.Employee;
import com.kairos.planning.domain.Location;
import com.kairos.planning.domain.Skill;
import com.kairos.planning.domain.Task;
import com.kairos.planning.domain.TaskType;
import com.kairos.planning.domain.Vehicle;
import com.kairos.planning.solution.TaskPlanningSolution;
import com.thoughtworks.xstream.XStream;

public class TaskPlanningGenerator {
	public TaskPlanningSolution loadUnsolvedSolution(){
		TaskPlanningSolution unresolvedSolution = new TaskPlanningSolution();
		unresolvedSolution.setTaskList(generateTasks());
		unresolvedSolution.setVehicleList(generateVehicleList());
		unresolvedSolution.setCitizenList(generateCitizenList());
		unresolvedSolution.setLocationList(generateLocationList());
		return unresolvedSolution;
	}
	public TaskPlanningSolution loadUnsolvedSolutionFromXML(){
		XStream xstream = new XStream();
		xstream.processAnnotations(Employee.class); 
		xstream.processAnnotations(Citizen.class); 
		xstream.processAnnotations(Task.class); 
		xstream.processAnnotations(TaskType.class); 
		xstream.processAnnotations(Skill.class); 
		xstream.processAnnotations(Vehicle.class); 
		xstream.processAnnotations(TaskPlanningSolution.class);
		xstream.processAnnotations(Affinity.class);
		xstream.processAnnotations(Location.class);
		xstream.processAnnotations(AvailabilityRequest.class);
		xstream.setMode(XStream.ID_REFERENCES);
		TaskPlanningSolution unresolvedSolution ;
		try{
			unresolvedSolution = (TaskPlanningSolution)xstream.fromXML(this.getClass().getClassLoader().getResourceAsStream("data/problemset.xml"));
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return unresolvedSolution;
	}
	
	

	private List<Vehicle> generateVehicleList() {
		List<Vehicle> vehicleList= new ArrayList<Vehicle>();
		for(int i=0;i<2;i++){
			Vehicle vehicle= new Vehicle();
			vehicle.setId(200000l+i);
			vehicle.setLocation(generateLocationList().get(0));
			vehicle.setType((i*10)%2==0? "car":"bike");
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}

	private List<Task> generateTasks() {
		List<Task> taskList= new ArrayList<Task>();
		List<Citizen> citizens= generateCitizenList();
		List<Location> locations= generateLocationList();
		for(int i=0;i<10;i++){
			Task task= new Task();
			task.setId(100000l+i);
			//task.setPriority(new Long(i));
			//task.setDuration(10L*i);
			task.setCitizen(citizens.get(i));
			task.setLocation(locations.get(i));
			taskList.add(task);
		}
		return taskList;
	}

	private List<Location> generateLocationList() {
		List<Location> locations= new ArrayList<Location>();
		locations.add(new Location("Oodles1",11.21300,11.43344));
		locations.add(new Location("Oodles2",21.34300,21.54334));
		locations.add(new Location("Oodles3",31.45600,31.32434));
		locations.add(new Location("Oodles4",41.23234,41.45634));
		locations.add(new Location("Oodles5",51.32300,51.55434));
		locations.add(new Location("Oodles6",61.23234,61.54534));
		return locations;
	}

	private List<Citizen> generateCitizenList() {
		List<Citizen> citizens= new ArrayList<Citizen>();
		citizens.add(new Citizen(10l,"Sachin Verma"));
		citizens.add(new Citizen(10l,"Ulrik"));
		citizens.add(new Citizen(10l,"Arvind"));
		citizens.add(new Citizen(10l,"Mohit"));
		citizens.add(new Citizen(10l,"Rijul"));
		citizens.add(new Citizen(10l,"Kunal"));
		citizens.add(new Citizen(10l,"Anil"));
		citizens.add(new Citizen(10l,"Maneesh"));
		citizens.add(new Citizen(10l,"Sumit"));
		citizens.add(new Citizen(10l,"Himanshu"));
		return citizens;
	} 
	private List<Employee> generateEmployeeList() {
		List<Employee> employees= new ArrayList<Employee>();
		//employees.add(new Employee(101l,"John Doe",new ArrayList<Skill>()));
		//employees.add(new Employee(102l,"Jane Doe",new ArrayList<Skill>()));
		//employees.add(new Employee(103l,"Jean Doe",new ArrayList<Skill>()));
		return employees;
	} 
}
