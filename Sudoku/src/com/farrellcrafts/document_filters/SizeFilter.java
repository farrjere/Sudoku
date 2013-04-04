package com.farrellcrafts.document_filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/**
 * This class is a document filter that limits the size of a given field,
 * no restriction is placed on removing text
 * This class extends ChainedDocumentFilter instead of DocumentFilter
 * so that we can chain filters together easily
 * @author Jeremy Farrell farrjere@isu.edu
 */
public class SizeFilter extends ChainedDocumentFilter {
	private static final int MAX_UNLIMITED = -1;
	private static final int MIN_UNLIMITED = 0;
	private final int minCharacters;
	private final int maxCharacters;
	
	/**
	 * A convenience method for producing a SizeFilter only limiting the maximum number of characters
	 * @param max - the maximum number of characters allowed in the field
	 * @return a standalone SizeFilter
	 */
	public static SizeFilter maxSizeFilter(int max){
		return new SizeFilter(max, MIN_UNLIMITED);
	}
	
	/**
	 * A convenience method for producing a SizeFilter only limiting the minimum number of characters
	 * @param min - minimum number of characters
	 * @return a standalone SizeFilter
	 */
	public static SizeFilter minSizeFilter(int min){
		return new SizeFilter(MAX_UNLIMITED, min);
	}
	
	/**
	 * A convenience method for producing a chained SizeFilter only limiting the maximum number of characters
	 * @param max - the maximum number of characters allowed in the field
	 * @param filter - the next filter to be called
	 * @return a chained SizeFilter
	 */
	public static SizeFilter maxChainSizeFilter(int max, DocumentFilter filter){
		return new SizeFilter(max, MIN_UNLIMITED, filter);
	}
	
	/**
	 * A convenience method for producing a chained SizeFilter only limiting the minimum number of characters
	 * @param min - the maximum number of characters allowed in the field
	 * @param filter - the next filter to be called
	 * @return a chained SizeFilter
	 */
	public static SizeFilter minChainSizeFilter(int min, DocumentFilter filter){
		return new SizeFilter(MAX_UNLIMITED, min, filter);
	}
	
	/**
	 * This creates a stand alone size filter
	 * @param max
	 * @param min
	 */
	public SizeFilter(int max, int min){
		minCharacters = min;
		maxCharacters = max;
	}
	
	/**
	 * This creates a size filter that will be chained with other filters
	 * @param max
	 * @param min
	 * @param filter
	 */
	public SizeFilter(int max, int min, DocumentFilter filter){
		super(filter);
		minCharacters = min;
		maxCharacters = max;
	}
	
	@Override
	/**
	 * If the size of the string is within the bounds of minCharacters and maxCharacters 
	 * then keep filtering or insert otherwise stop 
	 */
	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
			throws BadLocationException {
		if(sizeInRange(fb, str)){
			super.insertString(fb, offs, str, a);
		}
	}

	@Override
	/**
	 *If the size of the string is within the bounds of minCharacters and maxCharacters 
	 * then keep filtering or replace otherwise stop  
	 */
	public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
		if(sizeInRange(fb, str)){
			super.replace(fb, offs, length, str, a);
		}
	}
	
	private boolean sizeInRange(FilterBypass fb, String str){
		int totalLen = fb.getDocument().getLength() + str.length();
		return totalLen <= maxCharacters && totalLen >= minCharacters;
	}

	@Override
	/**
	 * Keep filtering or remove
	 */
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		super.remove(fb, offset, length);
	}
}