package com.farrellcrafts.document_filters;

import static org.junit.Assert.*;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter.FilterBypass;

import org.junit.BeforeClass;
import org.junit.Test;

public class SizeFilterTest {
	@BeforeClass
	public static void init(){
		//filter = new SizeFilter(1);
	}
	
	
	@Test
	public void testInsert() {
		JTextField field = new JTextField(4);
		AbstractDocument document = (AbstractDocument)field.getDocument();
		//document.setDocumentFilter(cFilter);
		//assertEquals(false, filter.insert(document.get, 0, "a test"));
	}

}
