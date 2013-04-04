package com.farrellcrafts.sudoku.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void testClearValue() {
		Cell cell = new Cell(0, 9);
		cell.setValue(6);
		assertEquals(6, cell.getValue());
		cell.clearValue();
		assertEquals(0, cell.getValue());
	}
	
	@Test
	public void setOverMax(){
		Cell cell = new Cell(5, 4);
		assertEquals(0, cell.getValue());
		cell.setValue(4);
		assertEquals(4, cell.getValue());
	}
	
	@Test
	public void setInitialValue(){
		Cell cell = new Cell(3, 9);
		cell.setValue(6);
		assertEquals(3, cell.getValue());
	}
}
