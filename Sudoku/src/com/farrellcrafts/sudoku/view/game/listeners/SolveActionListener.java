package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class SolveActionListener implements ActionListener{
	
	private SudokuFrame frame;
	private SudokuPuzzle puzzle;
	
	public SolveActionListener(SudokuFrame frame, SudokuPuzzle puzzle){
		this.puzzle = puzzle;
		this.frame = frame;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int[][] solution = puzzle.getSolution();
		frame.setBoardValues(solution);
	}

}
