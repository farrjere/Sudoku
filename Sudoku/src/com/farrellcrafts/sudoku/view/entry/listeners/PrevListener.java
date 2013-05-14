package com.farrellcrafts.sudoku.view.entry.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.view.SudokuFrame;

/**
 * This class handles the user pressing the previous button
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class PrevListener implements ActionListener {
	
	private SudokuFrame frame;

	public PrevListener(SudokuFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.previousSolution();
	}

}
