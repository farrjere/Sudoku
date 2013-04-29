package com.farrellcrafts.sudoku.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class IntroScreen extends MenuPanel {
	private static final long serialVersionUID = 5522752020898125442L;
	public static final int SIZE = 400;
	
	private JButton gameMode;
	private JButton entryMode;
	
	
	public IntroScreen(ActionListener emList, ActionListener gmList){
		super(new EmptyBorder(4, 4, 4, 4), GridBagConstraints.NONE);
		gameMode.addActionListener(gmList);
		entryMode.addActionListener(emList);
		addTitle();
		setPreferredSize(new Dimension(SIZE, SIZE));
	}
	
	private void addTitle(){
		JLabel title = new JLabel("SUDOKU!", JLabel.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setPreferredSize(new Dimension(400, 200));
		add(title);
	}
	
	@Override
	protected void initializeButtons() {
		gameMode = new JButton("Play A Game");
		gameMode.setPreferredSize(new Dimension(40, 40));
		entryMode = new JButton("Enter A Puzzle");
		entryMode.setPreferredSize(new Dimension(40, 40));
		addComponents(new Component[]{gameMode, entryMode});
	}	
	
}
