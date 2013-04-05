package com.farrellcrafts.sudoku.model;

final public class Hint {
	private final int row;
	private final int col;
	private final String value;
	
	/**
	 * This class acts as a dto between the SudokuPuzzle model and the view
	 * @param row - the row of the value
	 * @param col - the col of the value
	 * @param value - the value for the cell
	 */
	public Hint(int row, int col, String value) {
		if(row > -1 && col > -1 && Integer.valueOf(value) > 0){
			this.row = row;
			this.col = col;
			this.value = value;
		}else{
			throw new IllegalArgumentException("row and col must be greater than -1 and value must be greater than 0");
		}
		
		
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return col;
	}
	
	public String getValue(){
		return value;
	}

}
