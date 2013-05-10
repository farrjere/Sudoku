package com.farrellcrafts.sudoku.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.view.SudokuFrame;

/**
 * This class handles the user pressing the next button during entry mode
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class NextListener implements ActionListener {
	
	private SudokuFrame frame;

	public NextListener(SudokuFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.previousSolution();
	}

}
