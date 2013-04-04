package com.farrellcrafts.sudoku.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPane extends JPanel {

	private static final long serialVersionUID = -6468789670881421118L;
	public MenuPane() {
		setBorder(new EmptyBorder(4, 4, 4, 4));
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton solveButton = new JButton("Solve");
		JButton newButton = new JButton("New");
		JButton hintButton = new JButton("Hint");
		JButton resetButton = new JButton("Reset");
		solveButton.addActionListener(new SolveAction());
		newButton.addActionListener(new NewAction());
		hintButton.addActionListener(new HintAction());
		resetButton.addActionListener(new ResetAction());
		add(solveButton, gbc);
		gbc.gridy++;
		add(newButton, gbc);
		gbc.gridy++;
		add(hintButton, gbc);
		gbc.gridy++;
		add(resetButton, gbc);
	}
	
	private class SolveAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class HintAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class NewAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class ResetAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}