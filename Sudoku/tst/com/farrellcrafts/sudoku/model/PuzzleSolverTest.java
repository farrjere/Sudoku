package com.farrellcrafts.sudoku.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PuzzleSolverTest {

	@Test
	public void testFindSimpleSolution(){
		SudokuPuzzleLoader loader = new SudokuPuzzleLoader();
		SudokuPuzzle puzzle = loader.getNextPuzzle(Difficulty.EASY);
		int[][] actualSolution = puzzle.getSolution();
		PuzzleSolver solver = new PuzzleSolver(puzzle.getCurrentBoard(), -1);
		List<int[][]> solutions = solver.getSolutions();
		assertEquals(1, solutions.size());
		int[][] foundSolution = solutions.get(0);
		assertNotNull(foundSolution);
		for(int row=0; row < foundSolution.length; row++){
			for(int col = 0; col < foundSolution.length; col++){
				int val = foundSolution[row][col];
				//Check a valid number
				assertTrue(val > 0);
				assertTrue(val <= foundSolution.length);
				assertEquals(actualSolution[row][col], val);
			}
		}
	}
	
	@Test
	public void testFindMultipleSolutions(){
		int[][] puzzleWithMultipleSolutions = {
				{0,8,0,0,0,9,7,4,3},
				{0,5,0,0,0,8,0,1,0},
				{0,1,0,0,0,0,0,0,0},
				{8,0,0,0,0,5,0,0,0},
				{0,0,0,8,0,4,0,0,0},
				{0,0,0,3,0,0,0,0,6},
				{0,0,0,0,0,0,0,7,0},
				{0,3,0,5,0,0,0,8,0},
				{9,7,2,4,0,0,0,5,0}	
		};
		PuzzleSolver solver = new PuzzleSolver(puzzleWithMultipleSolutions, -1);
		assertTrue(solver.getSolutions().size() > 1);
		int[][] sol = solver.getSolutions().remove(0);
		for(int[][] solution : solver.getSolutions()){
			assertTrue(!sol.equals(solution));
		}
	}
	
	@Ignore("Takes a long to run on purpose")
	@Test
	public void testFindMultipleSolutionsNoFinish(){
		Date start = new Date();
		int[][] puzzleWithMultipleSolutions = {
				{0,0,0,0,0,0,0,0,3},
				{0,5,0,0,0,8,0,1,0},
				{0,1,0,0,0,0,0,0,0},
				{8,0,0,0,0,5,0,0,0},
				{0,0,0,8,0,4,0,0,0},
				{0,0,0,3,0,0,0,0,6},
				{0,0,0,0,0,0,0,7,0},
				{0,3,0,5,0,0,0,8,0},
				{9,7,2,4,0,0,0,5,0}	
		};
		PuzzleSolver solver = new PuzzleSolver(puzzleWithMultipleSolutions, -1);
		Date stop = new Date();
		long diff=stop.getTime()-start.getTime();
		System.out.println(diff/1000);
		System.out.print(solver.getSolutions().size());
		assertTrue(solver.getSolutions().size() > 1);
		int[][] sol = solver.getSolutions().remove(0);
		for(int[][] solution : solver.getSolutions()){
			assertTrue(!sol.equals(solution));
		}
		
	}
	
	@Test
	public void testFindNoSolution(){
		int[][] puzzleWithNoSoluton = {
				{5,1,6,8,4,9,7,3,2},
				{3,0,7,6,0,5,0,0,0},
				{8,0,9,7,0,0,0,6,5},
				{1,3,5,0,6,0,9,0,7},
				{4,7,2,5,9,1,0,0,6},
				{9,6,8,3,7,0,0,5,0},
				{2,5,3,1,8,6,0,7,4},
				{6,8,4,2,0,7,5,0,0},
				{7,9,1,0,5,0,6,0,8}
				};
		PuzzleSolver solver = new PuzzleSolver(puzzleWithNoSoluton, -1);
		assertEquals(0, solver.getSolutions().size());
	}
	
	//@Test
	public void testFindSolutionFor16By16(){
		fail();
	}
	
	@Test
	public void testGetFreeValues(){
		SudokuPuzzleLoader loader = new SudokuPuzzleLoader();
		SudokuPuzzle puzzle = loader.getNextPuzzle(Difficulty.EASY);
		PuzzleSolver solver = new PuzzleSolver(puzzle.getSize());
		int[][] puzzleValues = puzzle.getCurrentBoard();
		int[][] solution = puzzle.getSolution();
		for(int i=0; i < puzzle.getSize(); i++){
			for(int j =0; j < puzzle.getSize(); j++){
				if(puzzleValues[i][j] < 1){
					List<Integer> values = solver.getFreeValues(puzzleValues, i, j);
					assertTrue(values.contains(solution[i][j]));
					for(int val : values){
						assertTrue(getErrorMessage(i, j), val > 0);
					}
				}
			}
		}
	}
	
	private String getErrorMessage(int row, int col){
		StringBuilder builder = new StringBuilder("The value for row ");
		builder.append(row);
		builder.append(" col ");
		builder.append(col);
		builder.append(" is null");
		return builder.toString();
	}
}
