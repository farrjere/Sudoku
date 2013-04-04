package com.farrellcrafts.sudoku.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.farrellcrafts.sudoku.view.MenuPane;
import com.farrellcrafts.sudoku.view.SudokuBoard;

public class Sudoku {
	private SudokuBoard board;
	public static void main(String[] args) {
		new Sudoku();
	}

	public Sudoku() {
		board = new SudokuBoard();
		buildAndSetVisible();
	}
	
	private void buildAndSetVisible(){
		EventQueue.invokeLater(new Runnable() {
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
				frame.add(board);
				frame.add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
