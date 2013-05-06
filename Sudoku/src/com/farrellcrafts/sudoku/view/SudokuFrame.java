package com.farrellcrafts.sudoku.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.listeners.entry.SaveActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.HintActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.NewActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.ResetActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.SolveActionListener;

public class SudokuFrame extends JFrame implements Runnable{

	private static final long serialVersionUID = -1266589437727628251L;
	private static final String TITLE = "Sudoku";
	private enum Mode{
		GAME, ENTRY;
	}
	
	private Mode mode;
	private EntryMenuPane entryMenu;
	private GameMenuPane gameMenu;
	private SudokuBoard boardPanel;
	private IntroScreen intro;
	
	public SudokuFrame(ActionListener entryModeListener, ActionListener gameModeListener){
		intro = new IntroScreen(entryModeListener, gameModeListener);
		gameMenu = new GameMenuPane();
		entryMenu = new EntryMenuPane();
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

		JFrame frame = this;
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(intro);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setListenersOnGameMenu(HintActionListener hint,
			NewActionListener newAction,
			ResetActionListener reset,
			SolveActionListener solve){
		gameMenu.addListener(hint);
		gameMenu.addListener(newAction);
		gameMenu.addListener(reset);
		gameMenu.addListener(solve);
	}
	
	public void setListenersOnEntryMenu(
			com.farrellcrafts.sudoku.view.listeners.entry.ResetActionListener reset,
			SaveActionListener save,
			com.farrellcrafts.sudoku.view.listeners.entry.SolveActionListener solve){
		entryMenu.addListenerToReset(reset);
		entryMenu.addListenerToSave(save);
		entryMenu.addListenerToSolve(solve);
	}
	
	private void buildAndSetVisible(){
		EventQueue.invokeLater(this);
	}
	
	public Difficulty getDifficulty(){
		return gameMenu.getDifficulty();
	}
	
	private SudokuBoard getBoard(String[][] initialValues){
		boardPanel = new SudokuBoard(initialValues);
		return boardPanel;
	}
	
	public void setGameModeVisible(){
		mode = Mode.GAME;
		getContentPane().removeAll();
		getContentPane().add(boardPanel);
		getContentPane().add(gameMenu, BorderLayout.AFTER_LINE_ENDS);
		pack();
		setVisible(true);
	}
	
	public void setEntryModeVisible(){
		mode = Mode.ENTRY;
		String[][] values = new String[9][9];
		setBoardValues(values);
		getContentPane().removeAll();
		getContentPane().add(boardPanel);
		getContentPane().add(entryMenu, BorderLayout.AFTER_LINE_ENDS);
		pack();
		setVisible(true);
	}

	public void setBoardValues(String[][] newBoard) {
		if(boardPanel != null){
			boardPanel.setBoardValues(newBoard);
		}else{
			getBoard(newBoard);
		}
	}

	public void setCellValue(int row, int column, String value) {
		if(boardPanel != null && mode == Mode.GAME){
			boardPanel.setCellValue(row, column, value);
		}
	}

	public int[][] getBoardValues() {
		return boardPanel.getBoardValues();
	}

	public void setSolutions(List<int[][]> solutions) throws IllegalAccessException {
		if(mode != Mode.ENTRY){
			throw new IllegalAccessException();
		}
		if(solutions.size() == 0){
			//Display no solutions message?
		}else if(solutions.size() == 1){
			//Display solution
		}else{
			//Display 1st solution and buttons that allow you to go back and forth through the solutions
		}
	}
}
