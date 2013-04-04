package com.farrellcrafts.sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SudokuBoard extends JPanel {

	private static final long serialVersionUID = 3242846960946212517L;
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	public static final int SIZE = 400;
	private final ChildBoard[][] subBoards;

	public SudokuBoard() {
		setPreferredSize(new Dimension(SIZE, SIZE));
		setBorder(new EmptyBorder(4, 4, 4, 4));
		subBoards = new ChildBoard[ROWS][COLUMNS];
		setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				ChildBoard board = new ChildBoard(3, 3);
				board.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
				subBoards[row][col] = board;
				add(board);
			}
		}
	}

}