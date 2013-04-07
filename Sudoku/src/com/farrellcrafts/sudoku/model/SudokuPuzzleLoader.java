package com.farrellcrafts.sudoku.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SudokuPuzzleLoader {
	private DataSource source;
	private Map<Integer, SudokuPuzzle> puzzles;
	private SudokuPuzzle currentPuzzle;
	protected enum DataSource{
		XML, SQL, DEFAULT;
	}
	
	public SudokuPuzzleLoader(){
		source = DataSource.DEFAULT;
		puzzles = loadData();
	}
	
	public SudokuPuzzleLoader(DataSource source){
		this.source = source;
		puzzles = loadData();
	}
	
	public SudokuPuzzle getNextPuzzle(){
		for(Entry<Integer, SudokuPuzzle> entry : puzzles.entrySet()){
			if(entry.getKey() != null){
				if(!entry.getValue().userSolved() && currentPuzzle == null){
					currentPuzzle = entry.getValue();
					return currentPuzzle;
				}else if(currentPuzzle.hashCode() != entry.getKey()){
					currentPuzzle = entry.getValue();
					return currentPuzzle;
				}
			}
		}
		return null;
	}
	
	private Map<Integer, SudokuPuzzle> loadData(){
		Map<Integer, SudokuPuzzle> puzzles = null;
		switch(source){
		case DEFAULT:
			puzzles = defaultData();
			break;
		case XML:
			
			break;
		case SQL:
			
			break;
		default:
			throw new IllegalArgumentException();
		}
		return puzzles;
	}
	
	private static Map<Integer, SudokuPuzzle> defaultData(){
		int[][] initialValues = new int[][]{
				{7,1,0,0,0,5,6,0,0},
				{4,5,0,2,3,0,1,0,7},
				{0,0,6,0,8,0,5,0,0},
				{2,8,0,7,0,0,9,0,6},
				{0,0,1,6,2,3,0,0,5},
				{6,7,5,0,9,0,3,1,0},
				{0,0,4,0,1,2,0,5,9},
				{1,2,7,5,6,0,0,8,3},
				{0,0,9,0,7,8,0,6,0}
				};
		int[][] solutionValues = new int[][]{
				{7,1,2,9,4,5,6,3,8},
				{4,5,8,2,3,6,1,9,7},
				{3,9,6,1,8,7,5,2,4},
				{2,8,3,7,5,1,9,4,6},
				{9,4,1,6,2,3,8,7,5},
				{6,7,5,8,9,4,3,1,2},
				{8,6,4,3,1,2,7,5,9},
				{1,2,7,5,6,9,4,8,3},
				{5,3,9,4,7,8,2,6,1}
				};
		
		int[][] initialValues1 = new int[][]{
				{0,0,8,9,0,0,0,0,1},
				{7,0,0,1,0,3,0,9,8},
				{0,0,3,0,0,0,0,6,0},
				{0,0,0,0,4,8,1,0,0},
				{0,1,7,0,0,0,6,4,0},
				{0,0,5,2,1,0,0,0,0},
				{0,2,0,0,0,0,8,0,0},
				{6,8,0,5,0,1,0,0,7},
				{5,0,0,0,0,6,3,0,0}
				};
		int[][] solutionValues1 = new int[][]{
				{2,5,8,9,6,4,7,3,1},
				{7,4,6,1,5,3,2,9,8},
				{1,9,3,7,8,2,5,6,4},
				{9,3,2,6,4,8,1,7,5},
				{8,1,7,3,9,5,6,4,2},
				{4,6,5,2,1,7,9,8,3},
				{3,2,1,4,7,9,8,5,6},
				{6,8,9,5,3,1,4,2,7},
				{5,7,4,8,2,6,3,1,9}
				};
		SudokuPuzzle puzzle = new SudokuPuzzle(Difficulty.EASY, initialValues, solutionValues, false);
		SudokuPuzzle puzzle1 = new SudokuPuzzle(Difficulty.EASY, initialValues1, solutionValues1, false);
		Map<Integer, SudokuPuzzle> puzzleMap = new HashMap<Integer, SudokuPuzzle>();
		puzzleMap.put(puzzle.hashCode(), puzzle);
		puzzleMap.put(puzzle1.hashCode(), puzzle1);
		return puzzleMap;
	}
	
}
