package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.MyComponents.MyButton;

public class GamePanel extends JPanel {
	private SnakeGamePanel snakeGamePanel;

	public GamePanel(ActionListener listener) {
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		snakeGamePanel = new SnakeGamePanel(listener);
		snakeGamePanel.setBounds(42, 106, 736, 452);
		add(snakeGamePanel);
		
		MyButton backButton = new MyButton("BACK", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 119, 35);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		backButton.setFocusable(false);
		add(backButton);
	
	}
	
	public void moveSnake(int move) {
		snakeGamePanel.moveSnake(move);
	}
}
