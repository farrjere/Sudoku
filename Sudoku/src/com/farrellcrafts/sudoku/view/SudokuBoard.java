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
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	public static final int SIZE = 400;
	private ChildBoard[][] subBoards;
	
	public SudokuBoard(String[][] initialValues){
		setupBoard(initialValues);
	}

	private void setupBoard(String[][] initialValues){
		setPreferredSize(new Dimension(SIZE, SIZE));
		setBorder(new EmptyBorder(4, 4, 4, 4));
		subBoards = new ChildBoard[ROWS][COLUMNS];
		setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
		initializeChildBoards();
		setBoardValues(initialValues);
	}
	
	public void setCellValue(int row, int col, String value){
		setCellValue(row, col, value, true);
	}
	
	public void setBoardValues(String[][] values){
		int size = values.length;
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				String value = values[row][col];
				if(value == "" || value == null){
					setCellValue(row, col, value, true);
				}else{
					setCellValue(row, col, value, false);
				}
			}
		}
	}
	
	private void initializeChildBoards(){
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				ChildBoard board = new ChildBoard(ROWS, COLUMNS);
				board.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
				subBoards[row][col] = board;
				add(board);
			}
		}
	}

	private void setCellValue(int row, int column, String value, boolean editable) {
		int boardRow = row / ROWS;
		int boardCol = column / COLUMNS;
		int subRow = row % ROWS;
		int subCol = column % COLUMNS;
		setCellValue(boardRow, boardCol, subRow, subCol, value, editable);
	} 
	
	private void setCellValue(int boardRow,
			int boardCol, 
			int subRow, 
			int subCol, 
			String value,
			boolean editable){
		
		subBoards[boardRow][boardCol].setCellValue(subRow, subCol, value, editable);
	}
}