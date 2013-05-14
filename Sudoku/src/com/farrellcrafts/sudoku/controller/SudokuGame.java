package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.game.listeners.CellListener;
import com.farrellcrafts.sudoku.view.game.listeners.GameMenuListeners;
import com.farrellcrafts.sudoku.view.game.listeners.HintActionListener;
import com.farrellcrafts.sudoku.view.game.listeners.NewActionListener;
import com.farrellcrafts.sudoku.view.game.listeners.ResetActionListener;
import com.farrellcrafts.sudoku.view.game.listeners.SolveActionListener;

public class SudokuGame {
	private static SudokuGame game;
	
	private SudokuFrame sFrame;
	
	private SudokuPuzzleLoader loader;
	
	private SudokuPuzzle currentPuzzle;
	private GameMenuListeners listeners;
	private CellListener cellListener;
	
	protected SudokuGame(SudokuFrame frame){
		game = this;
		sFrame = frame;
		initializeGameMode();
	}
	
	private void initializeGameMode(){
		loader = new SudokuPuzzleLoader();
		currentPuzzle = loader.getNextPuzzle(Difficulty.EASY);
		sFrame.setBoardValues(currentPuzzle.getCurrentBoard());
		sFrame.setCellListener(cellListener);
		listeners = new GameMenuListeners(sFrame, currentPuzzle, loader);
		sFrame.setListenersOnGameMenu(listeners);
		sFrame.setGameModeVisible();
	}
	
	protected void updateCurrentPuzzle(){
		listeners.updatePuzzle();
	}
	
	public static void updatePuzzle(){
		game.updateCurrentPuzzle();
	}
	
}
