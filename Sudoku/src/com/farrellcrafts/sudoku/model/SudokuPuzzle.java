package com.farrellcrafts.sudoku.model;

import java.util.Arrays;

final public class SudokuPuzzle {
	private Cell[][] currentGrid;
	private Cell[][] solutionGrid;
	private Difficulty difficulty;
	private final int size;
	private final int boxSize;
	private boolean userSolved;
	
	public SudokuPuzzle(Difficulty difficulty, int[][] initialValues, int[][] solutionValues, boolean userSolved){
		this.difficulty = difficulty;
		this.userSolved = userSolved;
		size = initialValues.length;
		boxSize = (int)Math.sqrt(size);
		checkSizeSquare();
		setInitialValues(initialValues, solutionValues);
	}
	
	public void setCellValue(int row, int col, int value){
		currentGrid[row][col].setValue(value);
	}
	
	public int getSize(){
		return size;
	}
	
	public Difficulty getDifficulty(){
		return difficulty;
	}
	
	public Hint getHint(int row, int col) {
		Cell cell = currentGrid[row][col];
		if(cell.getValue() == 0){
			int value = solutionGrid[row][col].getValue();
			cell.setValue(value);
			return new Hint(row, col, value);
		}
		return null;
	}
	
	public Hint getHint(){
		Hint hint = null;
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				if(cell.getValue() == 0){
					int value = solutionGrid[row][col].getValue();
					cell.setValue(value);
					return new Hint(row, col, value);
				}
			}
		}
		return hint;
	}
	
	/**
	 * This function resets the SudokuPuzzle to its original state
	 * @return the SudokuPuzzle as it was created
	 */
	public int[][] reset(){
		int[][] values = new int[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				cell.clearValue();
				int value = cell.getValue();
				values[row][col] = value;
			}
		}
		return values;
	}
	
	public String getCellValue(int row, int col){
		int val = currentGrid[row][col].getValue();
		if(val != 0){
			return String.valueOf(val);
		}else{
			return "";
		}
	}
	
	/**
	 * Returns the solution and resets the state of the current Sudoku board 
	 * to its original state
	 * @return the values of the solution
	 */
	public String[][] getSolutionAsString(){
		String[][] values = new String[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = solutionGrid[row][col];
				int value = cell.getValue();
				values[row][col] = String.valueOf(value);
				
				Cell currentCell = currentGrid[row][col];
				currentCell.clearValue();
			}
		}
		return values;
	}
	
	public int[][] getSolution(){
		int[][] values = new int[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = solutionGrid[row][col];
				values[row][col] = cell.getValue();
				
				Cell currentCell = currentGrid[row][col];
				currentCell.clearValue();
			}
		}
		return values;
	}
	
	
	public boolean getUserSolved(){
		return userSolved;
	}
	
	/**
	 * Checks the solution, if valid this SudokuPuzzle will be set to user solved
	 * @return
	 */
	public boolean checkSolution(){
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				Cell solutionCell = solutionGrid[row][col];
				if(cell.getValue() != solutionCell.getValue()){
					return false;
				}
			}
		}
		userSolved = true;
		return true;
	}
	
	public String[][] getCurrentBoardAsString(){
		String[][] values = new String[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				int val = cell.getValue();
				if(val == 0){
					values[row][col] = "";
				}else{
					values[row][col] = String.valueOf(val);
				}
			}
		}
		return values;
	}
	
	public int[][] getCurrentBoard(){
		int[][] values = new int[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				values[row][col] = cell.getValue();
			}
		}
		return values;
	}
	
	/**
	 * Checks whether a user has already solved this puzzle
	 * @return
	 */
	public boolean userSolved(){
		return userSolved;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(solutionGrid);
		return result;
	}
	
	private boolean boxLine(int num){
		return (num + 1) % boxSize == 0 && (num + 1) != size;
	}
	
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		for(int row = 0; row < size; row++){
			sBuilder.append("||");
			for(int col =0; col<size; col++){
				sBuilder.append(currentGrid[row][col].toString());
				if(boxLine(col)){
					sBuilder.append("||");
				}else if(col < size - 1){
					sBuilder.append("|");
				}
			}
			sBuilder.append("||\n");
		}
		return sBuilder.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SudokuPuzzle other = (SudokuPuzzle) obj;
		if (!Arrays.deepEquals(solutionGrid, other.solutionGrid)) {
			return false;
		}
		return true;
	}

	private void checkSizeSquare(){
		if(boxSize*boxSize != size){
			throw new IllegalArgumentException("Only square puzzles are supported at this time");
		}
	}
	
	private void setInitialValues(int[][] init, int[][] solut){
		if(init.length != solut.length){
			throw new IllegalArgumentException();
		}
		currentGrid = new Cell[size][size];
		solutionGrid = new Cell[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				currentGrid[row][col] = new Cell(init[row][col], size);
				solutionGrid[row][col] = new Cell(solut[row][col], size);
			}
		}
	}

}