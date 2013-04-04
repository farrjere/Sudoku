package com.farrellcrafts.sudoku.model;

/**
 * This class represents a sudoku cell
 * The value if set originally cannot be changed
 * The value cannot be more than the maximum
 * @author jeremy
 *
 */
final class Cell {

	private boolean editable = true;
	private int value;
	private int maxValue;
	
	public Cell(int initialValue, int maxValue) {
		this.maxValue = maxValue; 
		setValue(initialValue);
		if(value > 0){
			editable = false;
		}
	}

	/**
	 * Clears the value if its editable
	 */
	public void clearValue() {
		if(editable){
			value = 0;
		}
	}

	public void setValue(int value) {
		if(editable && inRange(value)){
			this.value = value;
		}
	}

	public int getValue() {
		return value;
	}
	
	private boolean inRange(int value) {
		return value > -1 && value <= maxValue;
	}
	
	@Override
	public String toString(){
		if(value==0){
			return " ";
		}
		return String.valueOf(value);
	}

}
