package com.farrellcrafts.sudoku.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SudokuPuzzleTest {
	
	private SudokuPuzzle puzzle;
	private SudokuPuzzle smallPuzzle;
	
	@Before
	public void loadPuzzles(){
		int[][] smallSolution = {
				{1, 2, 3, 4},
				{3, 4, 1, 2},
				{2, 1, 4, 3},
				{4, 3, 2, 1}
		};
		
		int[][] smallGrid ={
				{0, 2, 3, 4},
				{3, 0, 1, 2},
				{2, 1, 0, 3},
				{0, 3, 2, 1}
		};
		
		int[][] solution = {
				{1,3,9,8,2,7,6,5,4},
				{7,6,5,9,1,4,3,2,8},
				{2,8,4,6,5,3,7,1,9},
				{8,2,7,5,6,1,4,9,3},
				{9,5,3,2,4,8,1,7,6},
				{6,4,1,7,3,9,5,8,2},
				{5,1,2,4,9,6,8,3,7},
				{4,9,8,3,7,5,2,6,1},
				{3,7,6,1,8,2,9,4,5}
				};
		int[][] currentGrid = {
				{1,0,0,8,0,0,6,5,0},
				{0,0,0,9,1,0,0,2,0},
				{0,8,0,0,5,0,7,0,9},
				{0,0,0,0,0,0,0,9,0},
				{0,5,3,0,4,0,1,7,0},
				{0,4,0,0,0,0,0,0,0},
				{5,0,2,0,9,0,0,3,0},
				{0,9,0,0,7,5,0,0,0},
				{0,7,6,0,0,2,0,0,5}
				};
		
		smallPuzzle = new SudokuPuzzle(Difficulty.EASY, smallGrid, smallSolution, false);
		puzzle = new SudokuPuzzle(Difficulty.EASY, currentGrid, solution, false);
	}
	
	@Test
	public void checkSize(){
		assertEquals(4, smallPuzzle.getSize());
		assertEquals(9, puzzle.getSize());
	}
	
	@Test
	public void checkInvalidSolution(){
		assertEquals(false, smallPuzzle.checkSolution());
		assertEquals(false, puzzle.checkSolution());
	}
	
	@Test
	public void checkValidSolution(){
		smallPuzzle.setCellValue(0, 0, 1);
		smallPuzzle.setCellValue(1, 1, 4);
		smallPuzzle.setCellValue(2, 2, 4);
		smallPuzzle.setCellValue(3, 0, 4);
		assertEquals(true, smallPuzzle.checkSolution());
		//have to reset the puzzles for other tests
		loadPuzzles();
	}
	
	@Test
	public void difficultySet(){
		assertEquals(Difficulty.EASY, puzzle.getDifficulty());
		assertEquals(Difficulty.EASY, smallPuzzle.getDifficulty());
	}
	
	@Test
	public void validHint(){
		int[][] values = puzzle.getCurrentBoard();
		int[][] smallValues = smallPuzzle.getCurrentBoard();
		Hint hint = puzzle.getHint();
		Hint smallHint = smallPuzzle.getHint();
		//Not set before hint
		assertEquals(0, values[hint.getRow()][hint.getColumn()]);
		assertEquals(0, smallValues[smallHint.getRow()][smallHint.getColumn()]);
		//Set after hint and equal to hint value
		assertEquals(hint.getValue(), puzzle.getCellValue(hint.getRow(), hint.getColumn()));
		assertEquals(smallHint.getValue(), smallPuzzle.getCellValue(smallHint.getRow(), smallHint.getColumn()));
	}
	
}
