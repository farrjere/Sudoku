package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.controller.Sudoku;

public class EntryModeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Sudoku.setEntryMode();
	}

}