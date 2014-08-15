package com.farrellcrafts.sudoku.view;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

import com.farrellcrafts.sudoku.view.game.listeners.CellListener;

public class Grid extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField[][] fields;
	private SudokuBoard board;
	private CellListener listener;

	public Grid(SudokuBoard board, GridDimensions gridDim, CellListener listener) {
		this.listener = listener;
		this.board = board;
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(new GridLayout(gridDim.getRows(), gridDim.getColumns(), 2, 2));
		initializeFields(gridDim);
	}
	
	private void initializeFields(GridDimensions gridDim){
		int rows = gridDim.getRows();
		int cols = gridDim.getColumns();
		int boardRow = gridDim.getGridRow();
		int boardCol = gridDim.getGridColumn();
		fields = new JTextField[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				JTextField field = new SudokuTextField((row+rows*boardRow), (col + cols*boardCol), listener);
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