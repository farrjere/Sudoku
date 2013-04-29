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
	 * @param source the data source that the puzzles will be loaded from
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
	 * A helper function for loading all puzzles
	 * If SQL or XML is specified as the data source and they fail the default data source will be tried instead 
	 * @return
	 */
	private Map<Integer, SudokuPuzzle> loadData(){
		Map<Integer, SudokuPuzzle> puzzles = null;
		switch(source){
		case DEFAULT:
			puzzles = new DefaultPuzzleLoader().getPuzzles();
			break;
		case XML:
			throw new NotImplementedException();
			//break;
		case SQL:
			try{
				puzzles = new DatabasePuzzleLoader().getPuzzles();
			}catch(Exception e){
				//If we have any problems loading from the database resort to the default data source
				puzzles = new DefaultPuzzleLoader().getPuzzles();
			}
			break;
		default:
			throw new IllegalArgumentException();
		}
		return puzzles;
	}
	
	//get the puzzle currently loaded
	public SudokuPuzzle getCurrentPuzzle() {
		return currentPuzzle;
	}
}
