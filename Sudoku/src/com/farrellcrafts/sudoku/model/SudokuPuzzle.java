package com.farrellcrafts.sudoku.model;

final public class SudokuPuzzle {
	private static final int MULTI = 7;
	private Cell[][] currentGrid;
	private Cell[][] solutionGrid;
	private Difficulty difficulty;
	private final int size;
	private final int boxSize;
	private boolean userSolved;
	
	public SudokuPuzzle(Difficulty difficulty, int[][] initialValues, int[][] solutionValues, boolean userSolved){
		this.difficulty = difficulty;
		this.userSolved = userSolved;
		size = initialValues.length;
		boxSize = (int)Math.sqrt(size);
		checkSizeSquare();
		setInitialValues(initialValues, solutionValues);
	}
	
	public void setCellValue(int row, int col, int value){
		currentGrid[row][col].setValue(value);
	}
	
	public int getSize(){
		return size;
	}
	
	public Difficulty getDifficulty(){
		return difficulty;
	}
	
	public Hint getHint(){
		Hint hint = null;
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				if(cell.getValue() == 0){
					int value = solutionGrid[row][col].getValue();
					cell.setValue(value);
					return new Hint(row, col, String.valueOf(value));
				}
			}
		}
		if(hint == null){
			
		}
		return hint;
	}
	
	/**
	 * This function resets the SudokuPuzzle to its original state
	 * @return the SudokuPuzzle as it was created
	 */
	public int[][] reset(){
		int[][] values = new int[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				cell.clearValue();
				values[row][col] = cell.getValue();
			}
		}
		return values;
	}
	
	public String getCellValue(int row, int col){
		int val = currentGrid[row][col].getValue();
		if(val != 0){
			return String.valueOf(val);
		}else{
			return " ";
		}
	}
	
	/**
	 * Returns the solution and sets the state of the current Sudoku board 
	 * to the solution
	 * @return the values of the solution
	 */
	public int[][] getSolution(){
		currentGrid = solutionGrid;
		int[][] values = new int[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				values[row][col] = cell.getValue();
			}
		}
		return values;
	}
	
	public boolean getUserSolved(){
		return userSolved;
	}
	
	/**
	 * Checks the solution, if valid this SudokuPuzzle will be set to user solved
	 * @return
	 */
	public boolean checkSolution(){
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				Cell solutionCell = solutionGrid[row][col];
				if(cell.getValue() != solutionCell.getValue()){
					return false;
				}
			}
		}
		userSolved = true;
		return true;
	}
	
	public String[][] getCurrentBoard(){
		String[][] values = new String[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				Cell cell = currentGrid[row][col];
				int val = cell.getValue();
				if(val == 0){
					values[row][col] = " ";
				}else{
					values[row][col] = String.valueOf(val);
				}
			}
		}
		return values;
	}
	
	/**
	 * Checks whether a user has already solved this puzzle
	 * @return
	 */
	public boolean userSolved(){
		return userSolved;
	}
	
	@Override
	public int hashCode(){
		int hashCode = 23;
		for(int row = 0; row<size; row++){
			for(int col =0; col<size; col++){
				hashCode = solutionGrid[row][col].getValue() * MULTI + row * MULTI + col * MULTI;						
			}
		}
		return hashCode;
	}
	
	private boolean boxLine(int num){
		return (num+1) % boxSize == 0 && (num+1) != size;
	}
	
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		for(int row = 0; row<size; row++){
			sBuilder.append("||");
			for(int col =0; col<size; col++){
				sBuilder.append(currentGrid[row][col].toString());
				if(boxLine(col)){
					sBuilder.append("||");
				}else if(col < size - 1){
					sBuilder.append("|");
				}
			}
			sBuilder.append("||\n");
		}
		return sBuilder.toString();
	}
	
	private void checkSizeSquare(){
		if(boxSize*boxSize != size){
			throw new IllegalArgumentException("Only square puzzles are supported at this time");
		}
	}
	
	private void setInitialValues(int[][] init, int[][] solut){
		if(init.length != solut.length){
			throw new IllegalArgumentException();
		}
		currentGrid = new Cell[size][size];
		solutionGrid = new Cell[size][size];
		for(int row = 0; row < size; row++){
			for(int col = 0; col < size; col++){
				currentGrid[row][col] = new Cell(init[row][col], size);
				solutionGrid[row][col] = new Cell(solut[row][col], size);
			}
		}
	}
}