package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuBoard;

public class SolveActionListener implements ActionListener{
	
	private SudokuBoard board;
	private SudokuPuzzle puzzle;
	
	public SolveActionListener(SudokuBoard board, SudokuPuzzle puzzle){
		this.puzzle = puzzle;
		this.board = board;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[][] solution = puzzle.getSolution();
		board.setBoardValues(solution);
	}

}
