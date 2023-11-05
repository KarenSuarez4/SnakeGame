package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakeGamePanel extends JPanel{
	private Vector<JLabel> snake;
	private double xSnake;
	private double ySnake;
	private boolean flag;
	private int foodScore;
	private JLabel obstacleJLabel;
	private JLabel foodJLabel;
	private JLabel snakeBody;
	
	public SnakeGamePanel(ActionListener listener) {
		this.setBackground(new Color(247, 215, 247));
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.xSnake = 100;
		this.ySnake = 200;
		this.flag = true;
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		obstacleJLabel = new JLabel();
		obstacleJLabel.setBounds(316,244,35,35);
		this.setImageLabel(obstacleJLabel, "resources/usbVirus.png");
		add(obstacleJLabel);
		
		foodJLabel = new JLabel();
		foodJLabel.setBounds(434,367,50,50);
		this.setImageLabel(foodJLabel, "resources/mouseFood.png");
		add(foodJLabel);
		
		snakeBody = new JLabel();
		snakeBody.setBounds(434, 367, 30, 30); 
		this.setImageLabel(snakeBody, "resources/texSnake2.png");
		add(snakeBody);
		
		snake = new Vector<JLabel>();
		snake.add(snakeBody);
	}

	public void start() {
		for (JLabel jLabel : snake) {
			this.remove(jLabel);
		}
		snake.removeAll(snake);
		snakeBody = new JLabel();
		snakeBody.setBounds(434, 367, 30, 30); 
		this.setImageLabel(snakeBody, "resources/texSnake2.png");
		add(snakeBody);
		snake.add(snakeBody);
		flag=true;
		
		revalidate();
		repaint();
	}
	
	public void createInitialSnake(int intialSizeSnake) {
		for(int i = 0; i <= intialSizeSnake ; i++ ) {
			snakeGrowth();
		}
	}
	
	public void changePositionObstacle(int xObstacle, int yObstacle) {
		for (int i = 1 ; i < snake.size(); i++) {
	    	if(snake.get(i).getX() != xObstacle & snake.get(i).getY() != yObstacle & foodJLabel.getBounds().x != xObstacle & foodJLabel.getBounds().y != yObstacle) {
	    		obstacleJLabel.setLocation(xObstacle, yObstacle);
	    	}else {
	    		changeObstaclesScore();
	    	}
	    }
		repaint();
	}
	
	public void changePositionFood(int xFood, int yFood) {
		for (int i = 1 ; i < snake.size(); i++) {
	    	if(snake.get(i).getX() != xFood & snake.get(i).getY() != yFood & obstacleJLabel.getBounds().x != xFood & obstacleJLabel.getBounds().y != yFood) {
	    		foodJLabel.setLocation(xFood, yFood);
	    	} else {
	    		changeFoodScore();
	    	}
	    }
		repaint();
	}

	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
	
	private void snakeGrowth() {
	    JLabel newBodyPart = createBody();
	    snake.add(newBodyPart);
	}
	
	
	public void changeFoodScore() {
		foodJLabel.setLocation((int) (10 + Math.random() * (700 - 10 + 1)), (int) (10 + Math.random() * (400 - 10 + 1)));
	}
	
	public void changeObstaclesScore() {
		obstacleJLabel.setLocation((int) (10 + Math.random() * (700 - 10 + 1)), (int) (10 + Math.random() * (400 - 10 + 1)));
	}

	private JLabel createBody() {
	    JLabel bodyPart = new JLabel();
	    bodyPart.setBounds((int)xSnake, (int)ySnake, 30, 30);
	    setImageLabel(bodyPart, "resources/texSnake1.png");
	    add(bodyPart);
	    return bodyPart;
	}
	
	public void moveSquartSnake(double xSnake, double ySnake) {
	    if (snakeBody.getBounds().intersects(obstacleJLabel.getBounds())) {
	        flag = false;
	    }
	    
	    if (snakeBody.getBounds().intersects(foodJLabel.getBounds())) {
	        changeFoodScore();
	        snakeGrowth();
	        foodScore++;
	        
	    }
	    if ((this.xSnake) >= getWidth()) {
	        this.xSnake = 0;
	    }
	    if ((this.xSnake + 40) <= 0) {
	        this.xSnake = getWidth();
	    }
	    if ((this.ySnake) >= getHeight()) {
	        this.ySnake = 0;
	    }
	    if ((this.ySnake + 40) <= 0) {
	        this.ySnake = getHeight();
	    }
	    
	    for (int i = 1 ; i < snake.size(); i++) {
	    	snake.get(snake.size()-i).setLocation(snake.get(snake.size()-(i+1)).getX(), snake.get(snake.size()-(i+1)).getY());
	    }
	      
	    this.xSnake += xSnake;
	    this.ySnake += ySnake;
	    repaint();
	}

	public int getFoodScore() {
		return foodScore;
	}
	
	public void setFoodScore(int foodScore) {
		this.foodScore = foodScore;
	}
	
	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(Color.BLACK);
	    
	    snake.get(0).setLocation((int) xSnake, (int) ySnake);   
	    
	    for (int i = 8; i < snake.size(); i++) {
	    	if (snake.get(0).getBounds().intersects(snake.get(i).getBounds())) {
	    		flag = false;
	    		break;
	    	}
	    }
	    
	}
	
	
	 
	
}
