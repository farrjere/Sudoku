package com.farrellcrafts.sudoku.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.action_listeners.HintActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.NewActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.ResetActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.SolveActionListener;

public class SudokuFrame extends JFrame implements Runnable{
	private MenuPane gameMenu;
	private MenuPane entryMenu;
	JPanel gamePanel;
	JPanel menuPanel;
	JPanel entryPanel;
	
	SudokuFrame(){
		
		gamePanel = new SudokuBoard();
		this.add(menuPanel);
		buildAndSetVisible();
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
		frame.add(menuPanel, BorderLayout.AFTER_LINE_ENDS);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setListenersOnMenu(HintActionListener hint,
			NewActionListener newAction,
			ResetActionListener reset,
			SolveActionListener solve){
		menuPanel.addListener(hint);
		menuPanel.addListener(newAction);
		menuPanel.addListener(reset);
		menuPanel.addListener(solve);
	}
	
	private void buildAndSetVisible(){
		EventQueue.invokeLater(this);
	}
	
	public Difficulty getDifficulty(){
		return menu.getDifficulty();
	}s
	
}
