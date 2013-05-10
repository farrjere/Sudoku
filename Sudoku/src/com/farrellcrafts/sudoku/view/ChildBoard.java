package com.farrellcrafts.sudoku.view;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class ChildBoard extends JPanel {

	private static final long serialVersionUID = -1807083097488271435L;
	private final JTextField[][] fields;
	private SudokuBoard board;
	

	public ChildBoard(SudokuBoard board, int rows, int cols, int boardRow, int boardCol) {
		this.board = board;
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(new GridLayout(rows, cols, 2, 2));
		fields = new JTextField[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				JTextField field = new SudokuTextField((row+rows*boardRow), (col + cols*boardCol));
				fields[row][col] = field;
				add(field);
			}
		}
	}
	
	public void setCellValue(int row, int col, int value, boolean editable){
		String val = board.valueInRange(value) ? String.valueOf(value) : "";
		JTextField field = fields[row][col];
		//first clear the cell of its original contents
		field.setText("");
		field.setEditable(editable);
		field.setFocusable(editable);
		field.setText(val);
	}

	public int getCellValue(int i, int j) {
		Document doc = fields[i][j].getDocument();
		try {
			return Integer.valueOf(doc.getText(0, doc.getLength()));
		} catch (Exception e) {
			return 0;
		}
	}

}