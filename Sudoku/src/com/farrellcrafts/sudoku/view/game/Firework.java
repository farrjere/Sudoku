package com.farrellcrafts.sudoku.view.game;

import java.awt.Color;
import java.util.Random;

public class Firework {
	private static Color[] COLORS = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED};
	private static int colorInd = 0;
	private static Random rand = new Random();
	private static int multiplier = -1;
	private static Color getNextColor(){
		if(colorInd == COLORS.length - 1){
			colorInd = 0;
		}else{
			colorInd = colorInd + 1;
		}
		return COLORS[colorInd];
	}
	
	private static int getMultiplier(){
		int r = rand.nextInt();
		int mod = r % 3;
		if(mod == 0){
			return 0;
		}else if(mod == 1){
			return 1;
		}else{
			return -1;
		}
	}
	
	private int x;
	private int y;
	private int xDir;
	private Color color;
	private int size;
	private int yDir;
	
	
	public Firework(){
		color = getNextColor();
		x = y = 200;
		
		xDir = getMultiplier(); 
		yDir = getMultiplier();
		
		size = (colorInd%3)+1;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Color getColor(){
		return color;
	}

	public void updateCoordinates() {
		y += (5 * yDir);
		x += (5 * xDir);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + size;
		result = prime * result + x;
		result = prime * result + xDir;
		result = prime * result + y;
		result = prime * result + yDir;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Firework other = (Firework) obj;
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (xDir != other.xDir) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		if (yDir != other.yDir) {
			return false;
		}
		return true;
	}

	public int getY1(){
		return y + size;
	}

	public int getX1() {
		return x + size;
	}
	
}
