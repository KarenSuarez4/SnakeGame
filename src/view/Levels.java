package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.MyComponents.MyButton;

public class Levels extends JPanel {

	private JLabel backgroundJLabel;

	public Levels(ActionListener listener) {
		this.setBackground(new Color(247, 215, 247));
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		MyButton easyButton = new MyButton("EASY", new Color(255,93,40,255), new Color(148,203,44), Color.WHITE, Color.WHITE, 25);
		easyButton.setBounds(62, 306, 199, 157);
		easyButton.setActionCommand("easyLevel");
		easyButton.addActionListener(listener);
		add(easyButton);
		
		MyButton mediumButton = new MyButton("MEDIUM", new Color(255,93,40,255), new Color(237,216,11), Color.WHITE, Color.WHITE, 25);
		mediumButton.setBounds(300, 306, 199, 157);
		mediumButton.setActionCommand("mediumLevel");
		mediumButton.addActionListener(listener);
		add(mediumButton);
		
		MyButton hardButton = new MyButton("HARD", new Color(255,93,40,255), new Color(237, 31,11), Color.WHITE, Color.WHITE, 25);
		hardButton.setBounds(548, 306, 199, 157);
		hardButton.setActionCommand("hardLevel");
		hardButton.addActionListener(listener);
		add(hardButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(241, 54, 310, 144);
		this.setImageLabel(lblNewLabel, "resources/titleGame.png");
		add(lblNewLabel);
		
		backgroundJLabel = new JLabel("");
		backgroundJLabel.setBounds(0, 0, 814, 591);
		this.setImageLabel(backgroundJLabel, "resources/backgroundLevelsPanel.jpeg");
		add(backgroundJLabel);	
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
