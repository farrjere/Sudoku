package com.farrellcrafts.sudoku.view;

public class GridDimensions {
	
	private int rows;
	private int columns;
	private int gridRow;
	private int gridColumn;

	public GridDimensions(int rows, int cols, int gridRow, int gridCol){
		setRows(rows);
		setColumns(cols);
		setGridRow(gridRow);
		setGridColumn(gridCol);
	}
	
	public int getRows(){
		return rows;
	}
	
	private void setRows(int rows) {
		if(rows > 0){
			this.rows = rows;
		}
	}
	
	public int getColumns(){
		return columns;
	}

	private void setColumns(int cols) {
		if(cols > 0){
			this.columns = cols;
		}
	}
	
	public int getGridRow(){
		return gridRow;
	}
	
	private void setGridRow(int gridRow) {
		if(gridRow > -1 && gridRow < rows){
			this.gridRow = gridRow;
		}
	}
	
	public int getGridColumn(){
		return gridColumn;
	}

	private void setGridColumn(int gridCol) {
		if(gridCol > -1 && gridCol < columns){
			this.gridColumn = gridCol;
		}
	}
	
}
