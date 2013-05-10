package com.farrellcrafts.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class attempts to find all solutions the given sudoku puzzle
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class PuzzleSolver{
	private int[][] initialValues;
	private List<int[][]> solutions;
	private final int gridSize;
	private final int size;
	//TODO use this to stop solving if past time
	private long timeout;
	
	protected PuzzleSolver(int size){
		this.size = size;
		this.gridSize = (int)Math.sqrt(size);
	}	
	
	public PuzzleSolver(int[][] board, long timeout){
		this.timeout= timeout;  
		initialValues = board;
		size = initialValues.length;
		gridSize = (int)Math.sqrt(initialValues.length);
		checkBoard();
		solutions = findSolutions(initialValues);
	}
	
	/**
	 * @return all solutions found
	 */
	public List<int[][]> getSolutions() {
		return solutions;
	}
	
	/*
	 * Verifies that the given board is square and doesn't violate the sudoku condition
	 */
	private void checkBoard() {
		checkBoardSize();
		checkForInvalidValues();
	}
	
	/**
	 * Verifies that the board given to solve doesn't already violate the sudoku condition
	 */
	private void checkForInvalidValues() {
		for(int group = 0; group < size; group++){
			checkGroupForInvalidValues(getRow(initialValues, group));
			checkGroupForInvalidValues(getColumn(initialValues, group));
			if(group % gridSize == 0){
				for(int gridCol = 0; gridCol < size; gridCol+=gridSize){
					checkGroupForInvalidValues(getGrid(initialValues, group, gridCol));
				}
			}
		}
	}
	
	/**
	 * Verifies that there are no invalid values in the given array
	 * @throws IllegalArgumentException if there are more than 1 of any value in a group
	 */
	private void checkGroupForInvalidValues(int[] group) throws IllegalArgumentException{
		for(int val = 1; val <= size; val++){
			int count = 0;
			for(int groupVal : group){
				if(groupVal == val){
					count++;
					if(count > 1){
						throw new IllegalArgumentException("The given sudoku board violates the sudoku condition");
					}
				}
			}
		}
	}

	private List<int[][]> findSolutions(int[][] start) {
		List<int[][]> solutions = new ArrayList<int[][]>();
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				if(valueNotSet(start[row][col])){
					List<Integer> values = getFreeValues(start, row, col);
					//No values means we are at a dead end with this solution
					if(values.size() == 0){
						return solutions;
					//Many values, many possible solutions
					}else if(values.size() > 1){
						return handleMultipleValuesForCell(values, start, row, col);
					//1 value, just keep going	
					}else{
						start[row][col] = values.get(0);
					}
				}
			}
		}
		//need to add the current solution if we got one
		solutions.add(start);
		return solutions;
	}
	
	/**
	 * This helper function attempts to find a solution for each value in values given the board start
	 * @param values a list of possible values for the cell row, col
	 * @param start a 2d array of ints representing the current state of the sudoku board
	 * @param row the row of the cell that the values list corresponds to
	 * @param col the col of the cell that the values list corresponds to
	 * @return all solutions that were found
	 */
	private List<int[][]> handleMultipleValuesForCell(List<Integer> values, int[][] start, int row, int col){
		List<int[][]> solutions = new ArrayList<int[][]>();
		for(int value : values){
			int[][] solution = copySolution(start);
			solution[row][col] = value;
			List<int[][]> foundSolutions = findSolutions(solution);
			if(foundSolutions != null && foundSolutions.size() > 0){
				solutions.addAll(foundSolutions);
			}
		}
		return solutions;
	}
	
	/**
	 * Sets the puzzle to be solved only used in testing
	 * @param puzzle
	 */
	protected void setPuzzle(int[][] puzzle){
		this.initialValues = puzzle;
	}
	
	private boolean valueNotSet(int value){
		return value < 1;
	}
	
	/**
	 * Copies a 2d int array
	 */
	private int[][] copySolution(int[][] solution){
		int [][] copy = new int[solution.length][];
		for(int i = 0; i < solution.length; i++){
			copy[i] = new int[solution.length];
			System.arraycopy(solution[i], 0, copy[i], 0, solution.length);
		}
		return copy;
	}
	
	/**
	 * 
	 * @param board a 2d array of int representing the current solution board
	 * @param rowInd the row to get the free (or unused values for)
	 * @param colInd the column to get the free values for
	 * @return a list of all the values not used by the given cell's (row, col pair) peers 
	 */
	protected List<Integer> getFreeValues(int[][] board, int rowInd, int colInd){
		List<Integer> rowValues = getFreeValues(getRow(board, rowInd));
		List<Integer> colValues = getFreeValues(getColumn(board, colInd));
		List<Integer> gridValues = getFreeValues(getGrid(board, rowInd, colInd));
		List<List<Integer>> listOfFreeValues = new ArrayList<List<Integer>>();
		listOfFreeValues.add(rowValues);
		listOfFreeValues.add(colValues);
		listOfFreeValues.add(gridValues);
		return intersection(listOfFreeValues);
	}
	
	/**
	 * @param a list of lists to intersect
	 * @return the intersection of all the lists in the given list
	 */
	private<T> List<T> intersection(List<List<T>> listsToInersect) {
        List<T> returnList = new ArrayList<T>();
        try{
	        List<T> firstList = listsToInersect.remove(0);
	        for (T t : firstList) {
	        	returnList.add(t);
	        	for(List<T> list : listsToInersect){
	        		if(!list.contains(t)){
	        			returnList.remove(t);
	        		}
	        	}
	        }
        }catch(IndexOutOfBoundsException e){
        	//If we were passed a list with no elements we silently continue
        	//TODO add logging so that this is not completely lost
        }
        return returnList;
    }
	
	private void checkBoardSize(){
		if(gridSize*gridSize != initialValues.length){
			throw new IllegalArgumentException("Only square grids are supported at this time");
		}
	}
	
	/**
	 * Checks that the given int val is not in the given array
	 * @param val the value to look for
	 * @param array the array to search
	 * @return true if the value is in the array, false otherwise
	 */
	private boolean valueNotInArray(int val, int[] array) {
		for(int ind = 0; ind < array.length; ind++){
			if(array[ind]==val){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Finds all values not currently being used in the current array,
	 * with in the allowed range of course
	 * (greater than 1 and less than or equal to the size of the board)
	 */
	private List<Integer> getFreeValues(int[] array){
		List<Integer> freeValues = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++){
			if(valueNotInArray(i, array)){
				freeValues.add(i);
			}
		}
		return freeValues;
	}
	
	/**
	 * Returns an array of ints located at rowInd in the given board
	 */
	protected int[] getRow(int[][] board, int rowInd){
		return board[rowInd];
	}
	
	/**
	 * Returns an array of int for located at the given column index in the given board
	 */
	protected int[] getColumn(int[][] board, int columnIndex){
		int[] column = new int[size];
		for(int row = 0; row < size; row++){
			column[row] = board[row][columnIndex];
		}
		return column;
	}
	
	/**
	 * Returns an array of ints representing all values in the current grid
	 * That grid is determined by finding the base row and column for the grid 
	 * and then incrementing that index until it is more than the baseIndex + the grid size
	 * @return an array of ints representing a sudoku grid (typically 3 X 3)
	 */
	protected int[] getGrid(int[][] board, int startRow, int startCol){
		int[] grid = new int[size];
		int baseRow = startRow - (startRow % gridSize);
		int baseCol = startCol - (startCol % gridSize);
		int ind = 0;
		for(int row = baseRow; row < baseRow + gridSize; row++){
			for(int col = baseCol; col < baseCol + gridSize; col++){
				grid[ind++] = board[row][col];
			}
		}
		return grid;
	}
}
