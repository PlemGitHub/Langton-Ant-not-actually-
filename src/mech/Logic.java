package mech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import screen.Screen;

public class Logic implements ActionListener, Constants {
	private Screen scr;
	public MyTimer myTimer;
	
	public Logic(Screen scr) {
		this.scr = scr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(scr.addLBtn))
			scr.setText(scr.getText()+"L");
		
		if (e.getSource().equals(scr.addRBtn))
			scr.setText(scr.getText()+"R");
		
		if (e.getSource().equals(scr.clearLastBtn))
			scr.setText(scr.getText().substring(0, scr.getText().length()-1));
		
		if (e.getSource().equals(scr.clearAllBtn))
			scr.setText("");
		
		if (e.getSource().equals(scr.startBtn)){
			scr.createAntField();
			myTimer = new MyTimer(DELAY, null, scr);
			myTimer.addActionListener(myTimer);
			myTimer.start();
			scr.switchButtonsOnStart();
		}
		
		if (e.getSource().equals(scr.stopBtn)){
			myTimer.stop();
			scr.switchButtonsOnStart();
		}
		
		if (e.getSource().equals(scr.pauseBtn)){
			if (myTimer.isRunning()){
				myTimer.paused = true;
				myTimer.stop();
			}else{
				myTimer.paused = false;
				myTimer.start();
			}
		}
	}
	
	
}
