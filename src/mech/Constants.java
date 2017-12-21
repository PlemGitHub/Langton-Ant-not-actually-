package mech;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

public interface Constants {
	int STEP = 5;
	int KWIDTH = 55;
	int KHEIGHT = 51;
	int WINWIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	int WINHEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	int ANTFIELDWIDTH = STEP*KWIDTH;
	int ANTFIELDHEIGHT = STEP*KHEIGHT;
	int DELAY = 1;
	Font LABELFONT = new Font ("TimesRoman", Font.BOLD, 25);
	int LABELWIDTH = WINWIDTH-600;
	Font BUTTONFONT = new Font ("TimesRoman", Font.BOLD, 20);
	String BUTTONNAME = "Button";
	Point[] DIRECTIONSLEFT = {new Point(0, -STEP), new Point(-STEP, 0), new Point(0, STEP), new Point(STEP, 0)};
	Point[] DIRECTIONSRIGHT = {new Point(0, -STEP), new Point(STEP, 0), new Point(0, STEP), new Point(-STEP, 0)};
}
