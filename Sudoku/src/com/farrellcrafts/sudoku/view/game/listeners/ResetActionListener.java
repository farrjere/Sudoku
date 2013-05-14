package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;
/**
 * Handles all reset button pushes
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class ResetActionListener implements ActionListener{
	private SudokuFrame frame;
	private SudokuPuzzle puzzle;
	
	public ResetActionListener(SudokuFrame frame, SudokuPuzzle puzzle){
		this.puzzle = puzzle;
		this.frame = frame;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int[][] resetValues = puzzle.reset();
		frame.setBoardValues(resetValues);
	}

}
