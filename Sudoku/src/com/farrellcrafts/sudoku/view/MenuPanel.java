package com.farrellcrafts.sudoku.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

public abstract class MenuPanel extends JPanel {
	private GridBagConstraints gbc;
	protected MenuPanel(AbstractBorder border, int fill){
		setLayout(new GridBagLayout());
		setBorder(border);
		setupConstraints(fill);
		initializeButtons();
	}
	
	protected abstract void initializeButtons();
	
	protected void addComponent(Component comp){
		add(comp, gbc);
		gbc.gridy++;
	}
	
	protected void addComponents(Component[] components){
		for(Component comp : components){
			addComponent(comp);
		}
	}

	private GridBagConstraints setupConstraints(int fill){
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.fill = fill;
		return gbc;
	}
}
