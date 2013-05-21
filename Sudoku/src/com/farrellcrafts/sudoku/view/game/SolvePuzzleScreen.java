package com.farrellcrafts.sudoku.view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SolvePuzzleScreen extends JPanel implements ActionListener {
	
	private GameMenu menu;
	private Timer timer;
	private List<Firework> fireworks = new ArrayList<Firework>();
	
	
	public SolvePuzzleScreen(GameMenu menu){
		this.menu = menu;
		setPreferredSize(new Dimension(400, 400));
		setBackground();
		addFireworks();
		addTitle();
	}

	private void addFireworks() {
		fireworks.add(new Firework());
		fireworks.add(new Firework());
		fireworks.add(new Firework());
		fireworks.add(new Firework());
		fireworks.add(new Firework());
		
		timer = new Timer(100, this);
		timer.start();
	}

	private void addTitle(){
		JLabel title = new JLabel("Congratulations!", JLabel.CENTER);
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setPreferredSize(new Dimension(400, 200));
		add(title);
	}
	
	private void setBackground(){
		setBackground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fireworks = new CopyOnWriteArrayList<Firework>(fireworks);
		for(Firework firework : fireworks){
			firework.updateCoordinates();
			if(checkOutOfBounds(firework)){
				fireworks.remove(firework);
			}
		}
		fireworks.add(new Firework());
		repaint();
	}
	
	private boolean checkOutOfBounds(Firework firework){
		return firework.getX() > this.getSize().getHeight() 
				|| firework.getY() > this.getSize().getWidth()
				|| firework.getY() < 0 
				|| firework.getX() < 0;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		for(Firework firework : fireworks){
			g2d.setColor(firework.getColor());
			g2d.drawLine(firework.getX(), firework.getY(), firework.getX1(), firework.getY1());
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
}
