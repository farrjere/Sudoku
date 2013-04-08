package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuBoard;
import com.farrellcrafts.sudoku.view.action_listeners.*;

public class Sudoku {
	private static Sudoku sudoku;
	private SudokuBoard board;
	private SudokuPuzzleLoader loader;
	private SudokuPuzzle currentPuzzle;
	private NewActionListener newListener;
	private ResetActionListener resetListener;
	private HintActionListener hintListener;
	private SolveActionListener solveListener;
	
	public static void main(String[] args) {
		new Sudoku();
	}

	private Sudoku() {
		initialize();
	}
	
	private void initialize(){
		sudoku = this;
		loader = new SudokuPuzzleLoader();
		currentPuzzle = loader.getNextPuzzle(Difficulty.EASY);
		board = new SudokuBoard(currentPuzzle.getCurrentBoard());
		hintListener = new HintActionListener(board, currentPuzzle);
		newListener = new NewActionListener(loader, board, currentPuzzle);
		resetListener = new ResetActionListener(board, currentPuzzle);
		solveListener = new SolveActionListener(board, currentPuzzle);
		board.setListenersOnMenu(hintListener, newListener, resetListener, solveListener);
	}
	
	private void updateCurrentPuzzle(){
		currentPuzzle = loader.getCurrentPuzzle();
		hintListener.updateSudokuPuzzle(currentPuzzle);
		resetListener.updateSudokuPuzzle(currentPuzzle);
		solveListener.updateSudokuPuzzle(currentPuzzle);
	}
	
	public static void updatePuzzle(){
		sudoku.updateCurrentPuzzle();
	}
	
	
}
