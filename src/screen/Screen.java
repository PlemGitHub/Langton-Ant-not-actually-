package screen;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mech.Constants;
import mech.Logic;

public class Screen implements Constants {
	public Logic lgc;
	private MainFrame fr;
	private JPanel mp;
	private JLabel antRulesLbl;
	private JLabel numberStep;
	public AntField antField;
	public MyButton startBtn, stopBtn, pauseBtn;
	public MyButton addLBtn, addRBtn;
	public MyButton clearAllBtn, clearLastBtn;
	
	public Screen() {
		lgc = new Logic(this);
		fr = new MainFrame("Langton Ant (not actually)", this);
		createMainPanel();
		createAllLabels();
		createAllButtons();
		mp.repaint();
	}

	private void createMainPanel() {
		mp = new JPanel();
		mp.setLayout(null);
		mp.setBackground(Color.WHITE);
		fr.setContentPane(mp);
	}

	public void createAntField() {
		if (antField != null)
			mp.remove(antField);
		antField = new AntField();
		mp.add(antField);
		antField.repaint();
	}
	
	private void createAllLabels() {
		antRulesLbl = new MyLabel("RRRL", 400, LABELWIDTH);
		mp.add(antRulesLbl);
		
		numberStep = new MyLabel("0", 0, 200);
		numberStep.setVisible(false);
		numberStep.setName("Button");
		mp.add(numberStep);
	}
	
	public void setText(String s){
		antRulesLbl.setText(s);
		if (s.equals("")){
			startBtn.setEnabled(false);
			clearLastBtn.setEnabled(false);
			clearAllBtn.setEnabled(false);
		}else{
			startBtn.setEnabled(true);
			clearLastBtn.setEnabled(true);
			clearAllBtn.setEnabled(true);
		}
	}
		public String getText(){
			return antRulesLbl.getText();
		}

	private void createAllButtons() {
		addLBtn = new MyButton("+L", 0, lgc);
		mp.add(addLBtn);
		
		addRBtn = new MyButton("+R", 100, lgc);
		mp.add(addRBtn);
		
		clearLastBtn = new MyButton("-LAST", 200, lgc);
		mp.add(clearLastBtn);
		
		clearAllBtn = new MyButton("-ALL", 300, lgc);
		mp.add(clearAllBtn);
		
		startBtn = new MyButton("START", WINWIDTH-100, lgc);
		mp.add(startBtn);
		
		stopBtn = new MyButton("STOP", WINWIDTH-100, lgc);
		stopBtn.setVisible(false);
		mp.add(stopBtn);
		
		pauseBtn = new MyButton("PAUSE", WINWIDTH-200, lgc);
		pauseBtn.setVisible(false);
		mp.add(pauseBtn);
	}
	
	public void switchButtonsOnStart(){
		for (Component c: mp.getComponents()) {
			String name = c.getName();
			if (name != null){
				if (c.isVisible())
					c.setVisible(false);
				else
					c.setVisible(true);	
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Screen scr = new Screen();
	}
}
