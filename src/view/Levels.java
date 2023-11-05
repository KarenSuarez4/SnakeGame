package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import view.MyComponents.MyButton;

public class Levels extends JPanel {

	private static final long serialVersionUID = 1L;

	public Levels(ActionListener listener) {
		this.setBackground(new Color(247, 215, 247));
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		MyButton easyButton = new MyButton("EASY", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		easyButton.setBounds(68, 198, 199, 157);
		easyButton.setActionCommand("easyLevel");
		easyButton.addActionListener(listener);
		add(easyButton);
		
		MyButton mediumButton = new MyButton("MEDIUM", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		mediumButton.setBounds(306, 198, 199, 157);
		mediumButton.setActionCommand("mediumLevel");
		mediumButton.addActionListener(listener);
		add(mediumButton);
		
		MyButton hardButton = new MyButton("HARD", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		hardButton.setBounds(554, 198, 199, 157);
		hardButton.setActionCommand("hardLevel");
		hardButton.addActionListener(listener);
		add(hardButton);
	}
	
	
}
