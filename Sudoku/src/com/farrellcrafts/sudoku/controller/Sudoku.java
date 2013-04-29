package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuBoard;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.action_listeners.*;

public class Sudoku {
	private static Sudoku sudoku;
	
	private SudokuFrame sFrame;
	private SudokuBoard board;
	
	private SudokuPuzzleLoader loader;
	
	private SudokuPuzzle currentPuzzle;
	
	//Intro Screen listeners
	private EntryModeListener entryModeListener;
	private GameModeListener gameModeListener;
	
	//Game mode listeners
	private NewActionListener newListener;
	private ResetActionListener resetListener;
	private HintActionListener hintListener;
	private SolveActionListener solveListener;
	
	public static void main(String[] args) {
		new Sudoku();
	}
	
	public static void updatePuzzle(){
		sudoku.updateCurrentPuzzle();
	}
	
	public static void setGameMode(){
		sudoku.initializeGameMode();
	}
	
	public static void setEntryMode(){
		sudoku.initializeEntryMode();
	}
	
	private Sudoku() {
		initialize();
	}
	
	private void initialize(){
		sudoku = this;
		entryModeListener = new EntryModeListener();
		gameModeListener = new GameModeListener();
		sFrame = new SudokuFrame(entryModeListener, gameModeListener);
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
	
	private void initializeEntryMode(){
		sFrame.setEntryModeVisible();
	}
	
	private void updateCurrentPuzzle(){
		currentPuzzle = loader.getCurrentPuzzle();
		hintListener.updateSudokuPuzzle(currentPuzzle);
		resetListener.updateSudokuPuzzle(currentPuzzle);
		solveListener.updateSudokuPuzzle(currentPuzzle);
	}
	

}
