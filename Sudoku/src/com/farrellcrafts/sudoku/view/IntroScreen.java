package com.farrellcrafts.sudoku.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroScreen extends JPanel{
	private static final int SIZE = 400;
	private final IntroMenu menu;
	
	public IntroScreen(ActionListener emList, ActionListener gmList){
		setLayout(new GridLayout(2,1));
		addTitle();
		setPreferredSize(new Dimension(SIZE, SIZE));
		menu = new IntroMenu(emList, gmList);
		add(menu);
	}
	
	private void addTitle(){
		JLabel title = new JLabel("SUDOKU!", JLabel.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setPreferredSize(new Dimension(400, 200));
		add(title);
	}
	
	
}
