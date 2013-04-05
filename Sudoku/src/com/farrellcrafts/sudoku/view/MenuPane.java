package com.farrellcrafts.sudoku.view;

import com.farrellcrafts.sudoku.view.action_listeners.HintActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.NewActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.ResetActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.SolveActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPane extends JPanel {
	private static final long serialVersionUID = 678727189285841459L;
	private JButton solveButton;
	private JButton newButton;
	private JButton hintButton;
	private JButton resetButton;
	
	public MenuPane() {
		setBorder(new EmptyBorder(4, 4, 4, 4));
		setLayout(new GridBagLayout());
		initializeButtons();
	}
	
	private void initializeButtons() {		
	    GridBagConstraints gbc = setupConstraints();
		solveButton = new JButton("Solve");
		newButton = new JButton("New");
		hintButton = new JButton("Hint");
		resetButton = new JButton("Reset");
	    //Add all buttons to out JPanel 
		add(solveButton, gbc);
		gbc.gridy++;
		add(newButton, gbc);
		gbc.gridy++;
		add(hintButton, gbc);
		gbc.gridy++;
		add(resetButton, gbc);
	}

	private GridBagConstraints setupConstraints(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		return gbc;
	}
	
	public void addListener(SolveActionListener listener){
		solveButton.addActionListener(listener);
	}
	
	public void addListener(ResetActionListener listener){
		resetButton.addActionListener(listener);
	}
	
	public void addListener(HintActionListener listener){
		hintButton.addActionListener(listener);
	}
	
	public void addListener(NewActionListener listener){
		newButton.addActionListener(listener);
	}
}