package com.farrellcrafts.sudoku.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 * This class is responsible for loading sudoku puzzles from a data source
 * If no data source is specified then the default data at the end of this class 
 * will be used
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class SudokuPuzzleLoader {
	private DataSource source;
	private Map<Integer, SudokuPuzzle> puzzles;
	private SudokuPuzzle currentPuzzle;
	//Represents the possible data sources that puzzles can be loaded from
	protected enum DataSource{
		XML, SQL, DEFAULT;
	}
	
	/**
	 * Default constructor, uses the default data source
	 */
	public SudokuPuzzleLoader(){
		source = DataSource.DEFAULT;
		puzzles = loadData();
	}
	
	/**
	 * Constructor that uses the specified data source
	 * @param source
	 */
	public SudokuPuzzleLoader(DataSource source){
		this.source = source;
		puzzles = loadData();
	}
	
	/**
	 * Grabs the next puzzle that hasn't been solved by the user and matches the given difficulty
	 * @param diff the difficulty of the puzzle to grab
	 * @return a sudoku puzzle
	 */
	public SudokuPuzzle getNextPuzzle(Difficulty diff){
		for(Entry<Integer, SudokuPuzzle> entry : puzzles.entrySet()){
			SudokuPuzzle puzzle = entry.getValue();
			if(entry.getKey() != null){
				if(currentPuzzle == null){
					if(!puzzle.userSolved() 
							&& puzzle.getDifficulty() == diff){
						currentPuzzle = puzzle;
						return currentPuzzle;
					}
				}else{
					if(currentPuzzle.hashCode() != entry.getKey() 
						&& puzzle.getDifficulty() == diff 
						&& !puzzle.userSolved()){
						currentPuzzle = puzzle;
						return currentPuzzle;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	private Map<Integer, SudokuPuzzle> loadData(){
		Map<Integer, SudokuPuzzle> puzzles = null;
		switch(source){
		case DEFAULT:
			puzzles = defaultData();
			break;
		case XML:
			throw new NotImplementedException();
			//break;
		case SQL:
			throw new NotImplementedException();
			//break;
		default:
			throw new IllegalArgumentException();
		}
		return puzzles;
	}
	
	//get the puzzle currently loaded
	public SudokuPuzzle getCurrentPuzzle() {
		return currentPuzzle;
	}
	
	/**
	 * this just initializes some default data
	 * For more puzzles use a different data source
	 * @return
	 */
	private static Map<Integer, SudokuPuzzle> defaultData(){
		int[][] easyInitial = new int[][]{
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
		
		int[][] easySolution = new int[][]{
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
		
		int[][] easyInitial1 = new int[][]{
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
		
		int[][] easySolution1 = new int[][]{
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
		
		int[][] mediumInitial = new int[][]{
				{0,0,2,8,0,0,5,0,0},
				{0,1,0,0,0,0,0,0,6},
				{0,5,0,0,0,1,0,0,7},
				{0,7,0,0,2,0,6,0,5},
				{0,0,0,0,0,0,0,0,9},
				{6,0,0,0,7,8,0,4,0},
				{0,0,0,0,0,6,0,0,1},
				{4,6,0,5,0,0,3,0,0},
				{0,0,0,0,0,9,4,0,8},
				};
		
		int[][] mediumSolution = new int[][]{
				{7,9,2,8,6,3,5,1,4},
				{8,1,4,7,5,2,9,3,6},
				{3,5,6,4,9,1,8,2,7},
				{9,7,3,1,2,4,6,8,5},
				{1,4,8,6,3,5,2,7,9},
				{6,2,5,9,7,8,1,4,3},
				{2,8,9,3,4,6,7,5,1},
				{4,6,1,5,8,7,3,9,2},
				{5,3,7,2,1,9,4,6,8}
				};
		
		int[][] mediumInitial1 = new int[][]{
				{3,0,0,0,8,0,0,0,1},
				{7,0,4,0,0,5,3,0,8},
				{0,2,0,0,0,0,7,9,0},
				{0,0,0,0,3,0,0,2,6},
				{0,0,0,0,6,0,5,8,0},
				{0,0,0,0,0,1,0,0,0},
				{5,0,3,0,0,9,0,0,0},
				{0,0,7,0,5,0,0,0,3},
				{0,0,6,0,0,0,0,1,0}
				};
		
		int[][] mediumSolution1 = new int[][]{
				{3,6,9,4,8,7,2,5,1},
				{7,1,4,9,2,5,3,6,8},
				{8,2,5,6,1,3,7,9,4},
				{9,7,8,5,3,4,1,2,6},
				{4,3,1,7,6,2,5,8,9},
				{6,5,2,8,9,1,4,3,7},
				{5,8,3,1,4,9,6,7,2},
				{1,9,7,2,5,6,8,4,3},
				{2,4,6,3,7,8,9,1,5}
				};
		
		int[][] hardInitial = new int[][]{
				{9,1,6,0,0,0,5,0,8},
				{0,0,0,0,0,0,0,0,1},
				{0,7,8,0,6,0,0,0,2},
				{0,0,0,0,3,2,7,0,5},
				{5,6,0,7,4,0,0,0,0},
				{7,0,0,9,0,0,0,6,0},
				{0,0,4,0,9,3,1,0,0},
				{0,5,0,0,7,0,0,0,0},
				{0,0,0,0,5,0,0,0,9}
				};
		
		int[][] hardSolution = new int[][]{
				{9,1,6,4,2,7,5,3,8},
				{2,4,5,3,8,9,6,7,1},
				{3,7,8,5,6,1,4,9,2},
				{4,9,1,6,3,2,7,8,5},
				{5,6,2,7,4,8,9,1,3},
				{7,8,3,9,1,5,2,6,4},
				{6,2,4,8,9,3,1,5,7},
				{8,5,9,1,7,4,3,2,6},
				{1,3,7,2,5,6,8,4,9}
				};
		
		int[][] hardInitial1 = new int[][]{
				{2,7,0,0,0,5,0,0,0},
				{1,0,5,7,2,0,0,3,0},
				{3,8,0,4,0,0,5,0,2},
				{8,0,0,0,3,7,4,0,0},
				{0,6,0,0,1,0,0,0,0},
				{5,0,3,0,0,0,0,1,0},
				{0,3,0,0,0,0,0,4,7},
				{0,0,0,9,0,0,1,0,5},
				{0,0,0,0,7,0,0,6,8}
				};
		
		int[][] hardSolution1 = new int[][]{
				{2,7,4,3,8,5,6,9,1},
				{1,9,5,7,2,6,8,3,4},
				{3,8,6,4,9,1,5,7,2},
				{8,1,9,2,3,7,4,5,6},
				{4,6,7,5,1,9,2,8,3},
				{5,2,3,6,4,8,7,1,9},
				{6,3,1,8,5,2,9,4,7},
				{7,4,8,9,6,3,1,2,5},
				{9,5,2,1,7,4,3,6,8}
				};
		//Create all default puzzles
		SudokuPuzzle easy = new SudokuPuzzle(Difficulty.EASY, easyInitial, easySolution, false);
		SudokuPuzzle easy1 = new SudokuPuzzle(Difficulty.EASY, easyInitial1, easySolution1, false);
		SudokuPuzzle medium = new SudokuPuzzle(Difficulty.MEDIUM, mediumInitial, mediumSolution, false);
		SudokuPuzzle medium1 = new SudokuPuzzle(Difficulty.MEDIUM, mediumInitial1, mediumSolution1, false);
		SudokuPuzzle hard = new SudokuPuzzle(Difficulty.HARD, hardInitial, hardSolution, false);
		SudokuPuzzle hard1 = new SudokuPuzzle(Difficulty.HARD, hardInitial1, hardSolution1, false);

		Map<Integer, SudokuPuzzle> puzzleMap = new HashMap<Integer, SudokuPuzzle>();
		//Add them to the puzzleMap		
		puzzleMap.put(easy.hashCode(), easy);
		puzzleMap.put(easy1.hashCode(), easy1);
		puzzleMap.put(medium.hashCode(), medium);
		puzzleMap.put(medium1.hashCode(), medium1);
		puzzleMap.put(hard.hashCode(), hard);
		puzzleMap.put(hard1.hashCode(), hard1);
		return puzzleMap;
	}
	
}
