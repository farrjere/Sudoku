package com.farrellcrafts.sudoku.view;


import com.farrellcrafts.document_filters.NumberFilter;
import com.farrellcrafts.document_filters.SizeFilter;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class ChildBoard extends JPanel {

	private static final long serialVersionUID = -1807083097488271435L;
	private final JTextField[][] fields;
	private final DocumentFilter filter = setFilter();

	public ChildBoard(int rows, int cols) {
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(new GridLayout(rows, cols, 2, 2));
		fields = new JTextField[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				JTextField field = new JTextField(4);
				((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
				fields[row][col] = field;
				add(field);
			}
		}
	}

	private DocumentFilter setFilter() {
		NumberFilter numFilter = new NumberFilter(false, false);
		SizeFilter sizeFilter = SizeFilter.maxChainSizeFilter(1, numFilter);
		
		return sizeFilter;
	}

}