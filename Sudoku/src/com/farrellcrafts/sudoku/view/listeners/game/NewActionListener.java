package com.farrellcrafts.sudoku.view.listeners.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.controller.SudokuGame;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class NewActionListener implements ActionListener {
	private SudokuPuzzleLoader loader;
	private SudokuFrame frame;
	private SudokuPuzzle puzzle;
	
	public NewActionListener(
			SudokuPuzzleLoader puzzleLoader, 
			SudokuFrame frame, 
			SudokuPuzzle puzzle){
		this.loader = puzzleLoader;
		this.puzzle = puzzle;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		puzzle = loader.getNextPuzzle(frame.getDifficulty());
		if(puzzle != null){
			String[][] newBoard = puzzle.getCurrentBoardAsString();
			frame.setBoardValues(newBoard);
			SudokuGame.updatePuzzle();
		}
	}

}
