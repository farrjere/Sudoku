package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuBoard;

public class NewActionListener implements ActionListener {
	private SudokuPuzzleLoader loader;
	private SudokuBoard board;
	private SudokuPuzzle puzzle;
	
	public NewActionListener(SudokuPuzzleLoader puzzleLoader, 
			SudokuBoard board, 
			SudokuPuzzle puzzle){
		this.loader = puzzleLoader;
		this.puzzle = puzzle;
		this.board = board;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		puzzle = loader.getNextPuzzle();
		String[][] newBoard = puzzle.getCurrentBoard();
		board.setBoardValues(newBoard);
	}

}
