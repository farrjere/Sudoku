package com.farrellcrafts.sudoku.view.intro.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.controller.Sudoku;

public class GameModeListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Sudoku.setGameMode();
	}

}
