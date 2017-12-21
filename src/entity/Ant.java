package entity;

import java.awt.Point;
import mech.Constants;

public class Ant implements Constants {
	public int x, y;
	public Point directionPoint = DIRECTIONSLEFT[0];
	
	public Ant(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point defineDirection(char R){
		switch (R) {
		case 'L': defineDirectionLeft();
			break;
		case 'R': defineDirectionRight();
			break;
		}
		return directionPoint;
	}

	private void defineDirectionLeft() {
		int k = 0;
		for (Point p : DIRECTIONSLEFT) {
			if (p.equals(directionPoint)){
				k++;
				if (k < 4){
					directionPoint = DIRECTIONSLEFT[k];
					return;
				}else{
					directionPoint = DIRECTIONSLEFT[0];
					return;
				}
			}
			k++;				
		}
	}

	private void defineDirectionRight() {
		int k = 0;
		for (Point p : DIRECTIONSRIGHT) {
			if (p.equals(directionPoint)){
				k++;
				if (k < 4){
					directionPoint = DIRECTIONSRIGHT[k];
					return;
				}else{
					directionPoint = DIRECTIONSRIGHT[0];
					return;
				}
			}
			k++;				
		}
	}

	public void doMove() {
		x = x+directionPoint.x;
			if (x < 0)
				x = x+ANTFIELDWIDTH-STEP;
			if (x > ANTFIELDWIDTH-STEP)
				x = x-ANTFIELDWIDTH+STEP;
		y = y+directionPoint.y;
			if (y < 0)
				y = y+ANTFIELDHEIGHT-STEP;
			if (y > ANTFIELDHEIGHT-STEP)
				y = y-ANTFIELDHEIGHT+STEP;
	}
}
