package com.kairos.planning.executioner;

import java.util.List;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kairos.planning.domain.Citizen;
import com.kairos.planning.domain.Location;
import com.kairos.planning.domain.Task;
import com.kairos.planning.domain.Vehicle;
import com.kairos.planning.solution.TaskPlanningSolution;

public class TaskPlanningSolver {
	public static String config = "com/kairos/planning/configuration/OutdoorTaskPlanning.xml";
	Logger log= LoggerFactory.getLogger(TaskPlanningSolver.class);
	Solver<TaskPlanningSolution> solver;
	public TaskPlanningSolver(){
		SolverFactory<TaskPlanningSolution> solverFactory = SolverFactory.createFromXmlResource(config);
		solver = solverFactory.buildSolver();
	}
	public void runSolver(){
		printSolvedSolution(getSolution());
	}
	private void printSolvedSolution(TaskPlanningSolution solution) {
		log.info("-------Printing Solution:-------");
		List<Task> tasks= solution.getTaskList();
		log.info("-------Tasks:-------");
		log.info(toDisplayString(solution));
		//tasks.forEach(task->log.info(task.toString()));
		log.info("-------Printing Solution Finished:-------");
		
	}
	public TaskPlanningSolution getSolution() {
		
		TaskPlanningSolution unsolvedSolution=getUnsolvedSolution();
		printUnsolvedSolution(unsolvedSolution);
		TaskPlanningSolution solution = solver.solve(unsolvedSolution);
		return solver.getBestSolution();
		//return solution;
	}

	private void printUnsolvedSolution(TaskPlanningSolution unsolvedSolution) {
		List<Location> locations= unsolvedSolution.getLocationList();
		List<Citizen> citizens= unsolvedSolution.getCitizenList();
		List<Task> tasks= unsolvedSolution.getTaskList();
		List<Vehicle> vehicles= unsolvedSolution.getVehicleList();
		log.info("-------Printing problem dataset:-------");
		log.info("-------Locations:-------");
		locations.forEach(location->log.info(location.toString()));
		log.info("-------Citizens:-------");
		citizens.forEach(citizen->log.info(citizen.toString()));
		log.info("-------vehicels:-------");
		vehicles.forEach(vehicle->log.info(vehicle.toString()));
		log.info("-------Tasks:-------");
		tasks.forEach(task->log.info(task.toString()));
		log.info("-------Printing problem dataset completed-------");
	}
	private TaskPlanningSolution getUnsolvedSolution() {
		//return new TaskPlanningGenerator().loadUnsolvedSolution();
		
		return new TaskPlanningGenerator().loadUnsolvedSolutionFromXML();
	}
	public String toDisplayString(TaskPlanningSolution solution) {
        StringBuilder displayString = new StringBuilder();
        for (Task task : solution.getTaskList()) {
        	Vehicle  vehicle= task.getVehicle();
            displayString.append("  ").append(task).append(" -> ")
                    .append(vehicle == null ? null : vehicle).append("\n");
        }
        return displayString.toString();
    }
}
