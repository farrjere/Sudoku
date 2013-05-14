package com.farrellcrafts.sudoku.view.entry.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.controller.SudokuEntry;
import com.farrellcrafts.sudoku.model.PuzzleSolver;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class SolveActionListener implements ActionListener{
	
	private SudokuFrame frame;
	private SudokuEntry entry;

	public SolveActionListener(SudokuEntry entry, SudokuFrame frame){
		this.entry = entry;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int[][] values = frame.getBoardValues();
		PuzzleSolver solver = new PuzzleSolver(values, 1000*60);
		entry.setSolutions(values, solver.getSolutions());
		try {
			frame.setSolutions(solver.getSolutions());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
