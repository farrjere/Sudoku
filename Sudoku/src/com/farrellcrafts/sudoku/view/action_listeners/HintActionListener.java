package com.farrellcrafts.sudoku.view.action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farrellcrafts.sudoku.model.Hint;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;

public class HintActionListener implements ActionListener {
	private SudokuFrame frame;
	private SudokuPuzzle puzzle;
	public HintActionListener(SudokuFrame frame, SudokuPuzzle puzzle){
		this.frame = frame;
		this.puzzle = puzzle;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Hint hint = puzzle.getHint();
		if(hint == null){
			System.out.println("This puzzle has been solved, there are no more hints to give");
		}else{
			frame.setCellValue(hint.getRow(), hint.getColumn(), hint.getValue());
		}
	}

}
