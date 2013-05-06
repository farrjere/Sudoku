package com.farrellcrafts.sudoku.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class EntryMenuPane extends MenuPanel {
	private static final long serialVersionUID = 678727189285841459L;
	private JButton solveButton;
	private JButton saveButton;
	private JButton resetButton;
	
	public EntryMenuPane() {
		super(new EmptyBorder(4, 4, 4, 4), GridBagConstraints.HORIZONTAL);
	}
	
	@Override
	protected void initializeButtons() {		
	    resetButton = new JButton("Reset");
	    solveButton = new JButton("Solve");
		saveButton = new JButton("Save");
	    //Add all buttons to out JPanel 
		addComponents(new AbstractButton[]{resetButton, solveButton, saveButton});
	}
	
	public void addListenerToReset(ActionListener listener){
		resetButton.addActionListener(listener);
	}
	
	public void addListenerToSolve(ActionListener listener){
		solveButton.addActionListener(listener);
	}
	
	public void addListenerToSave(ActionListener listener){
		saveButton.addActionListener(listener);
	}
	
}