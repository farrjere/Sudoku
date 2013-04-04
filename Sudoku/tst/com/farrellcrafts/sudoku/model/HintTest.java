package com.farrellcrafts.sudoku.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HintTest {
	
	@Test
	public void illegalArguments(){
		try{
			new Hint(-1, 1, -5);
			fail();
		}catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	public void valuesSet(){
		int row = 1;
		int col = 1;
		int val = 6;
		Hint hint = new Hint(row, col, val);
		
		assertEquals(col, hint.getColumn());
		assertEquals(row, hint.getRow());
		assertEquals(val, hint.getValue());
	}
	
}
