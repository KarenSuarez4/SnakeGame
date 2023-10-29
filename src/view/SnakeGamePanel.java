package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SnakeGamePanel extends JPanel{
	private int withSnake;
	private int heightSnake;
	private double xSnake;
	private double ySnake;
	
	public SnakeGamePanel(ActionListener listener) {
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.xSnake = 100;
		this.ySnake = 200;
		this.withSnake = 40;
		this.heightSnake = 20;
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		
	}
	
	 @Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.BLACK);
	    g.fillRect((int)xSnake, (int)ySnake, withSnake, heightSnake);
	}
	 
	public void moveSquartSnake(double xSnake, double ySnake) {
		if ((this.xSnake) >= getWidth()) {
			this.xSnake = 0;
		}
		if ((this.xSnake + this.withSnake) <= 0) {
			this.xSnake = getWidth();
		}
		if ((this.ySnake) >= getHeight()) {
			this.ySnake = 0;
		}
		if ((this.ySnake + this.heightSnake) <= 0) {
			this.ySnake = getHeight();
		}
		this.xSnake += xSnake;
		this.ySnake += ySnake;
        repaint();
	}
	
	 
	public void moveSnake(int move) {
		switch (move) {
		case 87:
		case 38:
			this.moveSquartSnake(0, -5);
			break;
			
		case 65:
		case 37:
			this.moveSquartSnake(-5, 0);
			break;
			
		case 68:
		case 39:
			this.moveSquartSnake(5, 0);
			break;
			
		case 83:
		case 40:
			this.moveSquartSnake(0, 5);
			break;

		default:
			break;
	}
	}
	
}
