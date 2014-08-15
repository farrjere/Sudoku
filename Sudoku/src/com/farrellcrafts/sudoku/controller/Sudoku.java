package com.farrellcrafts.sudoku.controller;

import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.intro.listeners.EntryModeListener;
import com.farrellcrafts.sudoku.view.intro.listeners.GameModeListener;

public class Sudoku {
	private static Sudoku sudoku;
	
	private SudokuFrame sFrame;
	private SudokuGame game;
	private SudokuEntry entry;
	//Intro Screen listeners
	private EntryModeListener entryModeListener;
	private GameModeListener gameModeListener;
	
	public static void main(String[] args) {
		new Sudoku();
	}
	
	public static void setGameMode(){
		sudoku.setupGame();
	}
	
	public static void setEntryMode(){
		sudoku.setupEntry();
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
	
	private void setupEntry(){
		entry = new SudokuEntry(sFrame);
	}
	
	private void setupGame(){
		game = new SudokuGame(sFrame);
	}

}
