package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.ActionEvent;

import javax.swing.text.TextAction;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.SudokuTextField;

/**
 * This class handles a cell being updated, checking for a solved puzzle
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class CellListener extends TextAction {
	
	private SudokuPuzzle puzzle;
	private SudokuFrame frame;
	
	CellListener(SudokuFrame frame, SudokuPuzzle puzzle){
		super("Checks for end game");
		this.frame = frame;
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		SudokuTextField textField = (SudokuTextField)getFocusedComponent();
		if(textField != null){
			int value = Integer.parseInt(textField.getText());
			handleCellUpdate(textField.getRow(), textField.getCol(), value);
		}
	}
	
	private void handleCellUpdate(int row, int col, int value){
		puzzle.setCellValue(row, col, value);
		if(puzzle.checkSolution()){
			frame.solvedPuzzle();
		}
	}
	
	

}
