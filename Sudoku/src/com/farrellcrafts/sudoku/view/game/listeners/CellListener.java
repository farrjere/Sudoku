package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.SudokuTextField;

/**
 * This class handles a cell being updated, checking for a solved puzzle
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class CellListener implements FocusListener{
	
	private SudokuPuzzle puzzle;
	private SudokuFrame frame;
	
	public CellListener(SudokuFrame frame, SudokuPuzzle puzzle){
		
		this.frame = frame;
		this.puzzle = puzzle;
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Cell action fired");
		SudokuTextField textField = (SudokuTextField)getFocusedComponent();
		if(textField != null){
			int value = Integer.parseInt(textField.getText());
			handleCellUpdate(textField.getRow(), textField.getCol(), value);
		}
	}
	*/
	private void handleCellUpdate(int row, int col, int value){
		puzzle.setCellValue(row, col, value);
		if(puzzle.checkSolution()){
			frame.solvedPuzzle();
		}
	}

	public void updateSudokuPuzzle(SudokuPuzzle current) {
		puzzle = current;
	}

	@Override
	public void focusGained(FocusEvent e) {
		//Do nothing
	}

	@Override
	public void focusLost(FocusEvent e) {
		SudokuTextField textField = (SudokuTextField)e.getComponent();
		printDebugMsg(textField);
		if(textField != null){
			try{
				int value = Integer.parseInt(textField.getText());
				handleCellUpdate(textField.getRow(), textField.getCol(), value);
			}catch(NumberFormatException ex){
				//Thats ok just ignore
			}
		}
	}
	
	private void printDebugMsg(SudokuTextField textField){
		StringBuilder builder = new StringBuilder("Captain, cell ").append(textField.getRow()).append(", ").append(textField.getCol()).append(" has lost focus");
		System.out.println(builder.toString());
		System.out.println("Text value: " +textField.getText());
	}
	
	

}
