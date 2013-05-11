package com.farrellcrafts.sudoku.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class IntroMenu extends MenuPanel {
	private JButton gameMode;
	private JButton entryMode;
	private Dimension buttonDim = new Dimension(40, 40);
	
	public IntroMenu(ActionListener emList, ActionListener gmList){
		super(new EmptyBorder(4, 4, 4, 4), GridBagConstraints.VERTICAL);
		gameMode.addActionListener(gmList);
		entryMode.addActionListener(emList);
		setPreferredSize(new Dimension(60, 60));
	}
	
	@Override
	protected void initializeButtons() {
		gameMode = new JButton("Play A Game");
		gameMode.setPreferredSize(buttonDim);
		entryMode = new JButton("Enter A Puzzle");
		entryMode.setPreferredSize(buttonDim);
		addComponents(new Component[]{gameMode, entryMode});

	}

}
