package com.farrellcrafts.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private static final Component NO_SOLUTIONS = new JLabel("There were no solutions for the given puzzle");
	private enum Mode{
		GAME, ENTRY;
	}
	private int solutionIndex = -1;
	private Mode mode;
	private EntryMenuPane entryMenu;
	private GameMenuPane gameMenu;
	private SudokuBoard boardPanel;
	private IntroScreen intro;
	private List<int[][]> solutions;
	
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
	
	private SudokuBoard getBoard(int[][] initialValues){
		System.out.println(initialValues.length);
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
		int[][] values = new int[9][9];
		setBoardValues(values);
		getContentPane().removeAll();
		getContentPane().add(boardPanel);
		getContentPane().add(entryMenu, BorderLayout.AFTER_LINE_ENDS);
		pack();
		setVisible(true);
	}

	public void setBoardValues(int[][] newBoard) {
		if(boardPanel != null){
			boardPanel.setBoardValues(newBoard);
		}else{
			getBoard(newBoard);
		}
	}

	public void setCellValue(int row, int column, int value) {
		if(boardPanel != null && mode == Mode.GAME){
			boardPanel.setCellValue(row, column, value);
		}
	}

	public int[][] getBoardValues() {
		return boardPanel.getBoardValues();
	}

	public void setSolutions(List<int[][]> solutions) throws IllegalAccessException {
		this.solutions= solutions;  
		remove(NO_SOLUTIONS);
		if(mode != Mode.ENTRY){
			throw new IllegalAccessException();
		}
		if(solutions.size() == 0){
			showNoSolutionsMessage();
		}else if(solutions.size() == 1){
			boardPanel.setBoardValues(solutions.get(0));
		}else{
			setSolutionIndex(0);
			boardPanel.setBoardValues(solutions.get(0));
		}
	}

	private void setSolutionIndex(int index) {
		solutionIndex = index;
	}

	private void showNoSolutionsMessage() {
		this.add(NO_SOLUTIONS);
	}
	
	private int getNextSolutionIndex(){
		if(solutionIndex == solutions.size() -1){
			solutionIndex = 0;
		}else{
			solutionIndex++;
		}
		return solutionIndex;
	}
	
	private int getPrevSolutionIndex(){
		if(solutionIndex == 0){
			solutionIndex = solutions.size()-1;
		}else{
			solutionIndex--;
		}
		return solutionIndex;
	}
}
