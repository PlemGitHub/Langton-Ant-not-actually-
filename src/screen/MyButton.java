package screen;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import mech.Constants;
import mech.Logic;

public class MyButton extends JButton implements Constants{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param name - button's label;
	 * @param x - x coordinate;
	 */
	public MyButton(String name, int x, Logic lgc) {
		setName(BUTTONNAME);
		setText(name);
		setBounds(x, 0, 100, 50);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setForeground(Color.RED);
		setFont(BUTTONFONT);
		setFocusable(false);
		addActionListener(lgc);
	}
}
