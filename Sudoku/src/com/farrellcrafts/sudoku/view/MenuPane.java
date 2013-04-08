package com.farrellcrafts.sudoku.view;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.action_listeners.HintActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.NewActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.ResetActionListener;
import com.farrellcrafts.sudoku.view.action_listeners.SolveActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class MenuPane extends JPanel {
	private static final long serialVersionUID = 678727189285841459L;
	private JButton solveButton;
	private JButton newButton;
	private JButton hintButton;
	private JButton resetButton;
	private ButtonGroup group;
	
	public MenuPane() {
		setBorder(new EmptyBorder(4, 4, 4, 4));
		setLayout(new GridBagLayout());
		initializeButtons();
	}
	

	private void initializeButtons() {		
	    GridBagConstraints gbc = setupConstraints();
		
	    group = new ButtonGroup();
	    JRadioButton easy = new JRadioButton(Difficulty.EASY.toString());
	    easy.setSelected(true);
	    JRadioButton medium = new JRadioButton(Difficulty.MEDIUM.toString());
	    JRadioButton hard = new JRadioButton(Difficulty.HARD.toString());
	    group.add(easy);
	    group.add(medium);
	    group.add(hard);
	    
	    solveButton = new JButton("Solve");
		newButton = new JButton("New");
		hintButton = new JButton("Hint");
		resetButton = new JButton("Reset");
	    //Add all buttons to out JPanel 
		add(easy, gbc);
		gbc.gridy++;
		add(medium, gbc);
		gbc.gridy++;
		add(hard, gbc);
		gbc.gridy++;
		add(newButton, gbc);
		gbc.gridy++;
		add(hintButton, gbc);
		gbc.gridy++;
		add(resetButton, gbc);
		gbc.gridy++;
		add(solveButton, gbc);
		
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
	
	public Difficulty getDifficulty(){
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return Difficulty.getDifficulty(button.getText());
            }
        }
        return null;
    }
	
}