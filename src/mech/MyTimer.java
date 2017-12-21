package mech;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import entity.Ant;
import screen.Screen;

public class MyTimer extends javax.swing.Timer implements Constants, ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel antField;
	private Graphics g;
	private Ant ant;
	public String directionChars;
	public Character newDirectionChar;
	public int currentPos;
	public BufferedImage buffImg;
	public boolean paused = false;
	/**
	 * 0 - white <br> 1 - black
	 */
	public int[][] antColors = new int[ANTFIELDWIDTH][ANTFIELDHEIGHT];

	public MyTimer(int delay, ActionListener listener, Screen scr) {
		super(delay, listener);
		antField = scr.antField;
		directionChars = scr.getText();
		newDirectionChar = directionChars.charAt(0);
		ant = new Ant(STEP*KWIDTH/2, STEP*KHEIGHT/2);
		initAntColors();
		buffImg = new BufferedImage(ANTFIELDWIDTH, ANTFIELDHEIGHT, BufferedImage.TYPE_INT_RGB);
		g = buffImg.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, ANTFIELDWIDTH, ANTFIELDHEIGHT);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, ANTFIELDWIDTH-1, ANTFIELDHEIGHT-1);
			
	}

	private void initAntColors() {
		for (int i = 0; i < ANTFIELDWIDTH; i++)
			for (int j = 0; j < ANTFIELDHEIGHT; j++)
				antColors[i][j] = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color newColor = defineNewColorUnderAnt();
		g.setColor(newColor);
		g.fillRect(ant.x, ant.y, STEP, STEP);
		
		if (newColor.equals(Color.BLACK)){
			increaseCurrentPos();
			newDirectionChar = directionChars.charAt(currentPos);
			ant.defineDirection(newDirectionChar);
		}
		ant.doMove();
		g.setColor(Color.RED);
		g.fillRect(ant.x, ant.y, STEP, STEP);
		drawBuffImage();
	}

	private Color defineNewColorUnderAnt() {
		if (antColors[ant.x][ant.y] == 0){
			antColors[ant.x][ant.y] = 1;
			return Color.BLACK;
		}
		else{
			antColors[ant.x][ant.y] = 0;
			return Color.WHITE;			
		}
	}

	private void increaseCurrentPos() {
		currentPos++;
		if (currentPos > directionChars.length()-1)
			currentPos = 0;
	}

	public void drawBuffImage() {
		antField.getGraphics().drawImage(buffImg, 0, 0, antField);
	}

}
