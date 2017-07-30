package com.kairos.planning.executioner;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskPlanningSolverTest {
	TaskPlanningSolver solver= new TaskPlanningSolver();
	@Test
	public void test() {
		solver.runSolver();
	}

}
