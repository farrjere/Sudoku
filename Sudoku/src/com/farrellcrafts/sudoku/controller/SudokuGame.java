package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.listeners.game.HintActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.NewActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.ResetActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.SolveActionListener;

public class SudokuGame {
	private static SudokuGame game;
	
	private SudokuFrame sFrame;
	
	private SudokuPuzzleLoader loader;
	
	private SudokuPuzzle currentPuzzle;
	
	private NewActionListener newListener;
	private ResetActionListener resetListener;
	private HintActionListener hintListener;
	private SolveActionListener solveListener;
	
	protected SudokuGame(SudokuFrame frame){
		game = this;
		sFrame = frame;
		initializeGameMode();
	}
	
	private void initializeGameMode(){
		loader = new SudokuPuzzleLoader();
		currentPuzzle = loader.getNextPuzzle(Difficulty.EASY);
		sFrame.setBoardValues(currentPuzzle.getCurrentBoard());
		hintListener = new HintActionListener(sFrame, currentPuzzle);
		newListener = new NewActionListener(loader, sFrame, currentPuzzle);
		resetListener = new ResetActionListener(sFrame, currentPuzzle);
		solveListener = new SolveActionListener(sFrame, currentPuzzle);
		sFrame.setListenersOnGameMenu(hintListener, newListener, resetListener, solveListener);
		sFrame.setGameModeVisible();
	}
	
	protected void updateCurrentPuzzle(){
		currentPuzzle = loader.getCurrentPuzzle();
		hintListener.updateSudokuPuzzle(currentPuzzle);
		resetListener.updateSudokuPuzzle(currentPuzzle);
		solveListener.updateSudokuPuzzle(currentPuzzle);
	}
	
	public static void updatePuzzle(){
		game.updateCurrentPuzzle();
	}
	
}
