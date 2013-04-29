package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.controller.Sudoku;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class GameModeListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Sudoku.setGameMode();
	}

}
