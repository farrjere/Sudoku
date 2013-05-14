package com.farrellcrafts.sudoku.view.game.listeners;

import java.awt.event.ActionEvent;

import javax.swing.text.TextAction;

import com.farrellcrafts.sudoku.model.Hint;
import com.farrellcrafts.sudoku.model.SudokuPuzzle;
import com.farrellcrafts.sudoku.view.SudokuFrame;
import com.farrellcrafts.sudoku.view.SudokuTextField;

public class HintActionListener extends TextAction {
	private SudokuFrame frame;
	private SudokuPuzzle puzzle;
	public HintActionListener(SudokuFrame frame, SudokuPuzzle puzzle){
		super("Click to get a hint");
		this.frame = frame;
		this.puzzle = puzzle;
	}
	
	public void updateSudokuPuzzle(SudokuPuzzle puzzle){
		this.puzzle = puzzle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		handleHint(getHint());
	}
	
	/**
	 * Returns a hint, if the user had clicked in a text field 
	 * before hitting the hint button then try to return a hint 
	 * for that field
	 */
	private Hint getHint(){
		SudokuTextField textField = (SudokuTextField)getFocusedComponent();
		if(textField == null){
			return puzzle.getHint();
		}else{
			Hint hint = puzzle.getHint(textField.getRow(), textField.getCol());
			//Set a regular hint so something is returned
			if(hint == null){
				hint = puzzle.getHint();
			}
			return hint;
		}
	}
	
	private void handleHint(Hint hint){
		if(hint == null){
			System.out.println("This puzzle has been solved, there are no more hints to give");
		}else{
			frame.setCellValue(hint.getRow(), hint.getColumn(), hint.getValue());
		}
	}

}
