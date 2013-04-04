package com.farrellcrafts.document_filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberFilter extends ChainedDocumentFilter {
	//as always regex tested with http://regexpal.com/
	private static final String NUMERIC_PATTERN ="(-?\\d+(\\.\\d+)?)|(-?\\.\\d+)";
	private boolean decimalAllowed = false;
	private boolean allowNegative = false;
	
	/**
	 * Creates a stand alone NumberFilter, 
	 * with defaults set for allowing negatives and decimal precision
	 */
	public NumberFilter() {
	}
	
	/**
	 * Creates a chainable NumberFilter, 
	 * with defaults set for allowing negatives and decimal precision
	 */
	public NumberFilter(DocumentFilter filter){
		super(filter);
	}
	
	/**
	 * Creates a chainable NumberFilter
	 * @param filter
	 */
	public NumberFilter(int decimals, boolean negatives, DocumentFilter filter){
		super(filter);
	}
	
	/**
	 * Creates a stand alone NumberFilter 
	 * @param decimals - whether decimals are allowed
	 * @param negatives - whether negatives are allowed or not
	 */
	public NumberFilter(boolean decimals, boolean negatives) {
		decimalAllowed = decimals;
		allowNegative = negatives;
	}
	
	@Override
	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
		if(isNumeric(str)){
			super.insertString(fb, offs, str, a);
		}
	}

	@Override
	public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
		if(isNumeric(str)){
			super.replace(fb, offs, length, str, a);
		}
	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		super.remove(fb, offset, length);
	}
	
	protected boolean accept(FilterBypass fb, int offset, String str) throws BadLocationException {
		boolean accept = false;
		int length = fb.getDocument().getLength();
		String currentText = fb.getDocument().getText(0, length);
		if(validNegativeSign(str, currentText)){
			accept = true;
		}else if(validDecimal(str, currentText)){
			accept = true;
		}else if(isNumeric(currentText+str)){
			accept = true;
		}
		return accept;
	}
	
	/**
	 * Checks whether a decimal is allowed
	 * @param str - the string types by the user
	 * @param currentText - the text already in the field
	 */
	private boolean validDecimal(String str, String currentText) {
		if(decimalAllowed){
			boolean strOnlyDecimal = str.equals(".");
			boolean firstDecimal = strOnlyDecimal && currentText.length() == 0;
			boolean numTextTrailingDecimal = isNumeric(currentText) && strOnlyDecimal;
			boolean negTrailingDecimal = currentText.equals("-") && strOnlyDecimal;
			return firstDecimal || numTextTrailingDecimal || negTrailingDecimal;
		}
		return false;
	}

	
	//
	/**
	 * Returns whether the given string is only numeric
	 * @param str - the string to be checked
	 */
	private boolean isNumeric(String str) {
		return str.matches(NUMERIC_PATTERN);
	}
	
	/**
	 * Checks whether the given string is a valid negative sign
	 * @param str
	 * @param currentText
	 * @return
	 */
	public boolean validNegativeSign(String str, String currentText){
		return str.equals("-") && currentText.length() == 0 && allowNegative;
	}
}