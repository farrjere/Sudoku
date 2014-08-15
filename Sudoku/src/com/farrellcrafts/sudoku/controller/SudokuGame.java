package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.game.listeners.GameMenuListeners;

public class SudokuGame {
	private static SudokuGame game;
	
	private SudokuFrame sFrame;
	
	private SudokuPuzzleLoader loader;
	
	private SudokuPuzzle currentPuzzle;
	private GameMenuListeners listeners;
	
	protected SudokuGame(SudokuFrame frame){
		game = this;
		sFrame = frame;
		initializeGameMode();
	}
	
	private void initializeGameMode(){
		loader = new SudokuPuzzleLoader();
		currentPuzzle = loader.getNextPuzzle(Difficulty.EASY);
		listeners = new GameMenuListeners(sFrame, currentPuzzle, loader);
		sFrame.setListenersOnGameMenu(listeners);
		sFrame.setBoardValues(currentPuzzle.getCurrentBoard());
		
		sFrame.setGameModeVisible();
	}
	
	protected void updateCurrentPuzzle(){
		listeners.updatePuzzle();
	}
	
	public static void updatePuzzle(){
		game.updateCurrentPuzzle();
	}
	
}
