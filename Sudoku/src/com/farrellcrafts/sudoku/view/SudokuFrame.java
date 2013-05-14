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
import com.farrellcrafts.sudoku.view.entry.EntryMenu;
import com.farrellcrafts.sudoku.view.entry.listeners.NextListener;
import com.farrellcrafts.sudoku.view.entry.listeners.PrevListener;
import com.farrellcrafts.sudoku.view.entry.listeners.SaveActionListener;
import com.farrellcrafts.sudoku.view.game.GameMenu;
import com.farrellcrafts.sudoku.view.game.listeners.CellListener;
import com.farrellcrafts.sudoku.view.game.listeners.GameMenuListeners;
import com.farrellcrafts.sudoku.view.intro.IntroScreen;

public class SudokuFrame extends JFrame implements Runnable{

	private static final String TITLE = "Sudoku";
	private static final Component NO_SOLUTIONS = new JLabel("There were no solutions for the given puzzle");
	private enum Mode{
		GAME, ENTRY;
	}
	
	private int solutionIndex = -1;
	private Mode mode;
	private EntryMenu entryMenu;
	private GameMenu gameMenu;
	private SudokuBoard boardPanel;
	private IntroScreen intro;
	private List<int[][]> solutions;
	private CellListener cellListener;
	
	public SudokuFrame(ActionListener entryModeListener, ActionListener gameModeListener){
		intro = new IntroScreen(entryModeListener, gameModeListener);
		gameMenu = new GameMenu();
		entryMenu = new EntryMenu();
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
	
	public void setListenersOnGameMenu(GameMenuListeners listeners){
		gameMenu.addListeners(listeners);
	}
	
	public void setListenersOnEntryMenu(
			com.farrellcrafts.sudoku.view.entry.listeners.ResetActionListener reset,
			SaveActionListener save,
			com.farrellcrafts.sudoku.view.entry.listeners.SolveActionListener solve){
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
		boardPanel = new SudokuBoard(initialValues, cellListener);
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
		checkEntryMode();
		if(solutions.size() == 0){
			handleNoSolutions();
		}else if(solutions.size() == 1){
			handleSolution();
		}else{
			handleMultipleSolutions();
		}
	}
	
	private void handleNoSolutions(){
		System.out.println("No Solution");
		showNoSolutionsMessage();
		entryMenu.setMultipleSolutionButtonsVisibility(false);
	}
	
	private void handleSolution(){
		System.out.println("One Solution");
		boardPanel.setBoardValues(solutions.get(0));
		entryMenu.setMultipleSolutionButtonsVisibility(false);
	}
	
	private void handleMultipleSolutions(){
		System.out.println("Multiple Solutions");
		setSolutionIndex(0);
		boardPanel.setBoardValues(solutions.get(0));
		entryMenu.addListenerToNext(new NextListener(this));
		entryMenu.addListenerToPrev(new PrevListener(this));
		entryMenu.setMultipleSolutionButtonsVisibility(true);
	}
	
	private void checkEntryMode() throws IllegalAccessException{
		if(mode != Mode.ENTRY){
			throw new IllegalAccessException();
		}
	}

	private void setSolutionIndex(int index) {
		solutionIndex = index;
	}

	private void showNoSolutionsMessage() {
		this.add(NO_SOLUTIONS);
	}
	
	public void nextSolution(){
		if(solutions != null && solutions.size() > 1){
			int[][] solution = solutions.get(getNextSolutionIndex());
			boardPanel.setBoardValues(solution);
		}
	}
	
	public void previousSolution(){
		if(solutions != null && solutions.size() > 1){
			int[][] solution = solutions.get(getPrevSolutionIndex());
			boardPanel.setBoardValues(solution);
		}
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

	public void solvedPuzzle(){
		// TODO Auto-generated method stub
		
	}

	public void setCellListener(CellListener cellListener) {
		this.cellListener = cellListener;
	}
}
