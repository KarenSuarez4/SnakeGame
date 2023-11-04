package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.MyComponents.MyButton;
import javax.swing.JLabel;

public class GamePanel extends JPanel {
	private SnakeGamePanel snakeGamePanel;
	private JLabel secondScoreJLabel;

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
		
		secondScoreJLabel = new JLabel("");
		secondScoreJLabel.setBounds(354, 46, 46, 14);
		add(secondScoreJLabel);
	
	}
	
	public void secondsScore(int secondScore) {
		secondScoreJLabel.setText(Integer.toString(secondScore));
		secondScoreJLabel.repaint();
	}
	
	public boolean flagFinishGame(){
		return snakeGamePanel.getFlag();
	}
	
	public void moveSquartSnake(double xSnake, double ySnake) {
		snakeGamePanel.moveSquartSnake(xSnake, ySnake);
	}
	
	public void changePositionObstacle(int xObstacle, int yObstacle) {
		snakeGamePanel.changePositionObstacle(xObstacle, yObstacle);
	}
	
	public void changePositionFood(int xFood, int yFood) {
		snakeGamePanel.changePositionFood(xFood, yFood);
	}
}
