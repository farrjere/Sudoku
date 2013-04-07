package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuBoard;
/**
 * Handles all reset button pushes
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class ResetActionListener implements ActionListener{
	private SudokuBoard board;
	private SudokuPuzzle puzzle;
	
	public ResetActionListener(SudokuBoard board, SudokuPuzzle puzzle){
		this.puzzle = puzzle;
		this.board = board;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[][] resetValues = puzzle.reset();
		board.setBoardValues(resetValues);
	}

}
