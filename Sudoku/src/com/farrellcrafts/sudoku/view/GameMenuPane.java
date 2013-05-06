package com.farrellcrafts.sudoku.view;

import com.farrellcrafts.sudoku.model.Difficulty;
import com.farrellcrafts.sudoku.view.listeners.game.HintActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.NewActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.ResetActionListener;
import com.farrellcrafts.sudoku.view.listeners.game.SolveActionListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class GameMenuPane extends MenuPanel {
	private static final long serialVersionUID = 678727189285841459L;
	private JButton solveButton;
	private JButton newButton;
	private JButton hintButton;
	private JButton resetButton;
	private ButtonGroup group;
	
	public GameMenuPane() {
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