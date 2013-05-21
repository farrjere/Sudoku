package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.model.SudokuPuzzleLoader;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class GameMenuListeners {
	
	private HintActionListener hintListener;
	private NewActionListener newListener;
	private ResetActionListener resetListener;
	private SolveActionListener solveListener;
	private CellListener cellListener;
	private SudokuPuzzleLoader loader;

	public GameMenuListeners(SudokuFrame frame, SudokuPuzzle puzzle, SudokuPuzzleLoader loader){
		this.loader = loader;
		initializeListeners(frame, puzzle);
	}
	
	private void initializeListeners(SudokuFrame frame, SudokuPuzzle puzzle){
		hintListener = new HintActionListener(frame, puzzle);
		newListener = new NewActionListener(loader, frame, puzzle);
		resetListener = new ResetActionListener(frame, puzzle);
		solveListener = new SolveActionListener(frame, puzzle);
		cellListener = new CellListener(frame, puzzle);
	}
	
	public ActionListener getHintActionListener(){
		return hintListener;
	}
	
	public ActionListener getNewActionListener(){
		return newListener;
	}
	
	public ActionListener getResetActionListener(){
		return resetListener;
	}
	
	public ActionListener getSolveActionListener(){
		return solveListener;
	}

	public void updatePuzzle() {
		SudokuPuzzle current = loader.getCurrentPuzzle();
		solveListener.updateSudokuPuzzle(current);
		resetListener.updateSudokuPuzzle(current);
		hintListener.updateSudokuPuzzle(current);
		cellListener.updateSudokuPuzzle(current);
	}

	public CellListener getCellListener() {
		return cellListener;
	}
	
}
