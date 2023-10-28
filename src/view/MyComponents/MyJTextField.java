package view.MyComponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;


import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyJTextField extends JTextField{
	private CustomFont customFont;
	
	public MyJTextField() {
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10,10,10,50));
		customFont = new CustomFont();
		this.setFont(customFont.loadFont(20f));
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		Graphics2D graphics2d = (Graphics2D) graphic;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
		Shape border = new RoundRectangle2D.Double(0, 0, getWidth()-2, getHeight()-2, getHeight(), getHeight());
		graphics2d.setColor(new Color(255,93,40,255)); 
		graphics2d.setStroke(new BasicStroke(2)); 
		graphics2d.draw(border);
		super.paintComponent(graphics2d);
	}

}
