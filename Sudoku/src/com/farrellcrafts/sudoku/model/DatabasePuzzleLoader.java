package com.farrellcrafts.sudoku.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DatabasePuzzleLoader implements PuzzleLoader {
	private static final String DRIVER = "org.h2.Driver";
	private static final String CONN_URL = "jdbc:h2:"+System.getProperty("user.dir")+"/puzzles";
	

	public DatabasePuzzleLoader() throws LoadDataException{
		Connection conn = null;
		try{
			conn = getConnection();
			
		}catch(Exception e){
			throw new LoadDataException(e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw new LoadDataException(e.getMessage());
			}
		}
	}
	
	
	//Returns a connection to the puzzles database 
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(CONN_URL); 
		return conn;
	}
	
	private Map<Integer, SudokuPuzzle> getPuzzles(Connection conn) throws SQLException{
		Statement state = conn.createStatement();
		String puzzleQuery = "SELECT PUZZLE.DIFFICULTY, PUZZLE.USER_SOLVED, " +
				"BOARD.SIZE, START_CELL.COLUMN, START_CELL.ROW, START_CELL.VALUE, " +
				"SOL_CELL.COLUMN AS S_COL, SOL_CELL.ROW AS S_ROW, SOL_CELL.VALUE AS S_VAL" +
				"FROM PUZZLE INNER JOIN BOARD ON PUZZLE.ID = BOARD.ID " +
				"INNER JOIN BOARD SOL ON BOARD.ID = SOL.START" +
				"INNER JOIN CELL SOL_CELL ON SOL.ID = SOL_CELL.BOARD" +
				"INNER JOIN CELL START_CELL ON BOARD.ID = START_CELL.BOARD";
		ResultSet rs = state.executeQuery(puzzleQuery);
		while(rs.next()){
			
		}
		return null;
		
	}
	
	private String getBoardsQuery(int puzzleId){
		return "SELECT * FROM BOARD B WHERE B.puzzle = " + puzzleId;
	}
	
	private String getCellsQuery(int boardId){
		return "SELECT * FROM CELL WHERE CELL.board = " + boardId;
	}
	
	private String getSolutionQuery(){
		return null;
	}

	@Override
	public Map<Integer, SudokuPuzzle> getPuzzles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class LoadDataException extends Exception{
		LoadDataException(String message){
			super(message);
		}
	}
	
	
}
