package com.farrellcrafts.sudoku.model;

public enum Difficulty {
	EASY("Easy"), MEDIUM("Medium"), HARD("Hard");
	private String value;
	
	private Difficulty(String stringValue){
		value = stringValue;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	public static Difficulty getDifficulty(String val){
		for(Difficulty diff : values()){
			if(diff.toString().equalsIgnoreCase(val)){
				return diff;
			}
		}
		return null;
	}
}
