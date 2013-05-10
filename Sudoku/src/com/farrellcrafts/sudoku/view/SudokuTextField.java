package com.farrellcrafts.sudoku.view;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import com.farrellcrafts.document_filters.NumberFilter;
import com.farrellcrafts.document_filters.SizeFilter;

public class SudokuTextField extends JTextField {
	private final DocumentFilter filter = setFilter();
	private int row;
	private int col;
	public SudokuTextField(int row, int col){
		super(4);
		this.row = row;
		this.col = col;
		((AbstractDocument) this.getDocument()).setDocumentFilter(filter);
	}
	
	private DocumentFilter setFilter() {
		NumberFilter numFilter = new NumberFilter(false, false);
		SizeFilter sizeFilter = SizeFilter.maxChainSizeFilter(1, numFilter);
		
		return sizeFilter;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
}