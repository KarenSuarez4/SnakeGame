package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SnakeGamePanel extends JPanel{
	
	public SnakeGamePanel(ActionListener listener) {
		setBackground(Color.ORANGE);
		setPreferredSize(new Dimension(814, 591));
		setLayout(null);
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		
	}
	
	
}
