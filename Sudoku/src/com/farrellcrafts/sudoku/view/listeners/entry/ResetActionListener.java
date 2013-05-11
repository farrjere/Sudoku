package com.farrellcrafts.sudoku.view.listeners.entry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.view.SudokuFrame;

public class ResetActionListener implements ActionListener{
	
	
	private SudokuFrame frame;

	public ResetActionListener(SudokuFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setBoardValues(new int[9][9]);
	}

}
