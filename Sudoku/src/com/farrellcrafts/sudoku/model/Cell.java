package com.farrellcrafts.sudoku.model;

/**
 * This class represents a sudoku cell
 * The value if set originally cannot be changed
 * The value cannot be more than the maximum
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + maxValue;
		result = prime * result + value;
		return result;
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
		Cell other = (Cell) obj;
		if (editable != other.editable) {
			return false;
		}
		if (maxValue != other.maxValue) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

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
