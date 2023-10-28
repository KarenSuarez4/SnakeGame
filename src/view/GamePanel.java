package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.MyComponents.MyButton;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public GamePanel(ActionListener listener) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(814, 591));
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		
		
		
		MyButton backButton = new MyButton("BACK", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 119, 35);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		setLayout(null);
		add(backButton);
		
		SnakeGamePanel snakeGamePanel = new SnakeGamePanel((ActionListener) null);
		snakeGamePanel.setBounds(42, 106, 736, 452);
		add(snakeGamePanel);
	}
}
