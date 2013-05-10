package com.farrellcrafts.sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.farrellcrafts.sudoku.model.Difficulty;

public class SudokuBoard extends JPanel  {

	private static final long serialVersionUID = 3242846960946212517L;
	public final int rows;
	public final int columns;
	public static final int SIZE = 400;
	private ChildBoard[][] subBoards;
	
	public SudokuBoard(int[][] initialValues){
		rows = columns = (int)Math.sqrt(initialValues.length);
		setupBoard(initialValues);
	}

	private void setupBoard(int[][] initialValues){
		setPreferredSize(new Dimension(SIZE, SIZE));
		setBorder(new EmptyBorder(4, 4, 4, 4));
		subBoards = new ChildBoard[rows][columns];
		setLayout(new GridLayout(rows, columns, 2, 2));
		initializeChildBoards();
		setBoardValues(initialValues);
	}
	
	public void setCellValue(int row, int col, int value){
		setCellValue(row, col, value, true);
	}
	
	public void setBoardValues(int[][] values){
		int size = values.length;
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				int value = values[row][col];
				if(!valueInRange(value)){
					setCellValue(row, col, value, true);
				}else{
					setCellValue(row, col, value, false);
				}
			}
		}
	}
	
	protected boolean valueInRange(int value) {
		return value > 0 && value <= rows * rows;
	}

	private void initializeChildBoards(){
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				ChildBoard board = new ChildBoard(this, rows, columns, row, col);
				board.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
				subBoards[row][col] = board;
				add(board);
			}
		}
	}

	private void setCellValue(int row, int column, int value, boolean editable) {
		int boardRow = row / rows;
		int boardCol = column / columns;
		int subRow = row % rows;
		int subCol = column % columns;
		setCellValue(boardRow, boardCol, subRow, subCol, value, editable);
	} 
	
	private void setCellValue(int boardRow,
			int boardCol, 
			int subRow, 
			int subCol, 
			int value,
			boolean editable){
		
		subBoards[boardRow][boardCol].setCellValue(subRow, subCol, value, editable);
	}
	
	/**
	 * Returns the currently set board values as a 2d int array
	 * @return
	 */
	public int[][] getBoardValues(){
		int[][] values = new int[rows*rows][columns*columns];
		for(int boardRow = 0; boardRow < rows; boardRow++){
			for(int boardCol = 0; boardCol < columns; boardCol++){
				ChildBoard subBoard = subBoards[boardRow][boardCol];
				for(int i = 0; i < rows; i++){
					for(int j = 0; j < columns; j++){
						values[i+rows*boardRow][j+columns*boardCol] = subBoard.getCellValue(i, j);
					}
				}
			}
		}
		return values;
	}
}