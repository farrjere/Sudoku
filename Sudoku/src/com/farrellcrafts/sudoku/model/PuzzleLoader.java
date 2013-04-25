package com.farrellcrafts.sudoku.model;

import java.util.Map;

public interface PuzzleLoader {
	public Map<Integer, SudokuPuzzle> getPuzzles();
}
