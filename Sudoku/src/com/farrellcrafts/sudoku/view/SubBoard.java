package com.farrellcrafts.sudoku.view;

import java.awt.GridLayout;
import javax.swing.JPanel;

class SubBoard extends JPanel {

	private static final long serialVersionUID = -2922144892905839732L;

	public SubBoard() {
		setLayout(new GridLayout(3, 3, 2, 2));

		for (int index = 0; index < 1; index++) {
			add(new ChildBoard(3, 3));
		}

	}
}