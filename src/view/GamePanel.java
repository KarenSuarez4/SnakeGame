package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.MyComponents.MyButton;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class GamePanel extends JPanel {
	private SnakeGamePanel snakeGamePanel;
	private JLabel secondScoreJLabel;
	private JLabel timeinfJLable;
	private JLabel scoreJLabel;
	private JLabel scoreInfJLabel;
	private int valueScore;
	private JLabel backgroundJLabel;

	public GamePanel(ActionListener listener) {
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.valueScore = 0;
		this.initComponent(listener);
		
	}
	
	public void initComponent(ActionListener listener) {
		snakeGamePanel = new SnakeGamePanel(listener);
		snakeGamePanel.setBounds(42, 106, 736, 452);
		add(snakeGamePanel);
		
		MyButton backButton = new MyButton("BACK", new Color(244,16,244), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 119, 35);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		backButton.setFocusable(false);
		add(backButton);
		
		secondScoreJLabel = new JLabel("");
		secondScoreJLabel.setForeground(new Color(255, 255, 255));
		secondScoreJLabel.setFont(new Font("balloons", Font.PLAIN, 19));
		secondScoreJLabel.setBounds(260, 42, 46, 23);
		add(secondScoreJLabel);
		
		timeinfJLable = new JLabel("TIME");
		timeinfJLable.setForeground(new Color(255, 255, 255));
		timeinfJLable.setFont(new Font("balloons", Font.PLAIN, 19));
		timeinfJLable.setBounds(211, 42, 46, 23);
		add(timeinfJLable);
		
		scoreJLabel = new JLabel(valueScore + "");
		scoreJLabel.setForeground(new Color(255, 255, 255));
		scoreJLabel.setFont(new Font("balloons", Font.PLAIN, 19));
		scoreJLabel.setBounds(425, 42, 46, 23);
		add(scoreJLabel);
		
		scoreInfJLabel = new JLabel("SCORE");
		scoreInfJLabel.setForeground(new Color(255, 255, 255));
		scoreInfJLabel.setFont(new Font("balloons", Font.PLAIN, 19));
		scoreInfJLabel.setBounds(376, 42, 46, 23);
		add(scoreInfJLabel);
		
		backgroundJLabel = new JLabel("");
		backgroundJLabel.setBounds(0, 0, 814, 591);
		this.setImageLabel(backgroundJLabel, "resources/backgroundGamePanel.jpeg");
		add(backgroundJLabel);
	
	}
	
	public void start() {
		valueScore = 0;
		scoreJLabel.setText(valueScore + "");
		snakeGamePanel.start();
	}
	
	public void createInitialSnake(int sizeSnake) {
		snakeGamePanel.createInitialSnake(sizeSnake);
	}
	
	public void setScore() {
		if ((snakeGamePanel.getFoodScore()==5)) {
			valueScore += 10;
			scoreJLabel.setText(valueScore + "");
			snakeGamePanel.setFoodScore(0);
		}
	}
	
	public int getValueScore() {
		return valueScore;
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
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
