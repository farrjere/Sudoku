package com.farrellcrafts.sudoku.controller;

import java.util.List;

import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.entry.listeners.ResetActionListener;
import com.farrellcrafts.sudoku.view.entry.listeners.SaveActionListener;
import com.farrellcrafts.sudoku.view.entry.listeners.SolveActionListener;

public class SudokuEntry {
	
	private SudokuFrame sudokuFrame;
	
	private SolveActionListener solve;
	private ResetActionListener reset;
	private SaveActionListener save;
	
	protected SudokuEntry(SudokuFrame frame){
		sudokuFrame = frame;
		initializeEntryMode();
	}
	
	private void initializeEntryMode(){
		reset = new ResetActionListener(sudokuFrame);
		save = new SaveActionListener();
		solve = new SolveActionListener(this, sudokuFrame);
		sudokuFrame.setListenersOnEntryMenu(reset, save, solve);
		sudokuFrame.setEntryModeVisible();
	}

	public void setSolutions(int[][] values, List<int[][]> solutions) {
		// I intend to have this call whatever saves the puzzle and solutions to the database
		//sudokuFram
	}
}
