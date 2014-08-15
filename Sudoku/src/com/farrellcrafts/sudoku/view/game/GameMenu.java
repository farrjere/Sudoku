package com.farrellcrafts.sudoku.view.game;

import java.awt.GridBagConstraints;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.MenuPanel;
import com.farrellcrafts.sudoku.view.game.listeners.GameMenuListeners;

public class GameMenu extends MenuPanel {
	private static final long serialVersionUID = 678727189285841459L;
	private JButton solveButton;
	private JButton newButton;
	private JButton hintButton;
	private JButton resetButton;
	private ButtonGroup group;
	
	public GameMenu() {
		super(new EmptyBorder(4, 4, 4, 4), GridBagConstraints.HORIZONTAL);
	}
	
	@Override
	protected void initializeButtons() {		
	    group = new ButtonGroup();
	    JRadioButton easy = new JRadioButton(Difficulty.EASY.toString());
	    easy.setSelected(true);
	    JRadioButton medium = new JRadioButton(Difficulty.MEDIUM.toString());
	    JRadioButton hard = new JRadioButton(Difficulty.HARD.toString());
	    group.add(easy);
	    group.add(medium);
	    group.add(hard);
	    
	    newButton = new JButton("New");
	    hintButton = new JButton("Hint");
	    resetButton = new JButton("Reset");
	    solveButton = new JButton("Solve");
		
	    //Add all buttons to out JPanel 
		addComponents(new AbstractButton[]{easy, medium, hard, newButton, hintButton, resetButton, solveButton});
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

	public void addListeners(GameMenuListeners listeners) {	
		newButton.addActionListener(listeners.getNewActionListener());
		hintButton.addActionListener(listeners.getHintActionListener());
		resetButton.addActionListener(listeners.getResetActionListener());
		solveButton.addActionListener(listeners.getSolveActionListener());
	}
	
}