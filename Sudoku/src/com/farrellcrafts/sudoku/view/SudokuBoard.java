package com.farrellcrafts.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.action_listeners.*;

public class SudokuBoard extends JPanel implements Runnable {

	private static final long serialVersionUID = 3242846960946212517L;
	public static final int ROWS = 3;
	public static final int COLUMNS = 3;
	public static final int SIZE = 400;
	private ChildBoard[][] subBoards;
	private MenuPane menu;
	public SudokuBoard(String[][] initialValues) {
		setupBoard(initialValues);
		buildAndSetVisible();
	}
	
	private void setupBoard(String[][] initialValues){
		menu = new MenuPane();
		setPreferredSize(new Dimension(SIZE, SIZE));
		setBorder(new EmptyBorder(4, 4, 4, 4));
		subBoards = new ChildBoard[ROWS][COLUMNS];
		setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLUMNS; col++) {
				ChildBoard board = new ChildBoard(ROWS, COLUMNS);
				board.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
				subBoards[row][col] = board;
				add(board);
			}
		}
		for(int row = 0; row < initialValues.length; row++){
			for(int col = 0; col < initialValues.length; col++){
				String value = initialValues[row][col];
				if(value.matches("[0-9]")){
					setCellValue(row, col, value, false);
				}else{
					setCellValue(row, col, value, true);
				}
			}
		}
	}
	
	private void buildAndSetVisible(){
		EventQueue.invokeLater(this);
	}

	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (UnsupportedLookAndFeelException ex) {
		}

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this);
		frame.add(menu, BorderLayout.AFTER_LINE_ENDS);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setListenersOnMenu(HintActionListener hint,
			NewActionListener newAction,
			ResetActionListener reset,
			SolveActionListener solve){
		menu.addListener(hint);
		menu.addListener(newAction);
		menu.addListener(reset);
		menu.addListener(solve);
	}
	
	public void setCellValue(int row, int col, String value){
		setCellValue(row, col, value, true);
	}
	
	public Difficulty getDifficulty(){
		return menu.getDifficulty();
	}
	
	public void setBoardValues(String[][] values){
		int size = values.length;
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				String value = values[row][col];
				if(value == ""){
					setCellValue(row, col, value, true);
				}else{
					setCellValue(row, col, value, false);
				}
			}
		}
	}

	private void setCellValue(int row, int column, String value, boolean editable) {
		int boardRow = row / ROWS;
		int boardCol = column / COLUMNS;
		int subRow = row % ROWS;
		int subCol = column % COLUMNS;
		setCellValue(boardRow, boardCol, subRow, subCol, value, editable);
	} 
	
	private void setCellValue(int boardRow,
			int boardCol, 
			int subRow, 
			int subCol, 
			String value,
			boolean editable){
		
		subBoards[boardRow][boardCol].setCellValue(subRow, subCol, value, editable);
	}

}