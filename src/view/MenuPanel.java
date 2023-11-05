package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MyComponents.CustomFont;
import view.MyComponents.MyButton;
import view.MyComponents.MyJTextField;

import java.awt.Color;
import java.awt.Font;

public class MenuPanel extends JPanel {
	private JLabel background;
	private CustomFont customFont;
	private JLabel infName;
	private MyJTextField namePlayer;

	public MenuPanel(ActionListener listener) {
		this.setBackground(Color.ORANGE);
		this.setPreferredSize(new Dimension(814, 591));
		this.setLayout(null);
		this.initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {	
		MyButton playButton = new MyButton("PLAY", new Color(255,93,40,255), new Color(237,116,50,255), Color.white, Color.white, 25);
		playButton.setBounds(473, 241, 222, 48);
		playButton.addActionListener(listener);
		playButton.setActionCommand("playButtonMenu");
		add(playButton);
		
		MyButton scoreButton = new MyButton("SCORE", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		scoreButton.setBounds(473, 312, 222, 48);
		scoreButton.addActionListener(listener);
		scoreButton.setActionCommand("scoreButtonMenu");
		add(scoreButton);
		
		MyButton infButton = new MyButton("CREATOR INFORMATION", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		infButton.setBounds(473, 385, 222, 48);
		infButton.addActionListener(listener);
		infButton.setActionCommand("creatorInformationMenu");
		add(infButton);
		
		namePlayer = new MyJTextField();
		namePlayer.setBounds(473, 495, 222, 34);
		add(namePlayer);
		
		infName = new JLabel("Nombre del jugador:");
		infName.setFont(new Font("balloons", Font.PLAIN, 17));
		infName.setForeground(Color.WHITE);
		infName.setBounds(487, 471, 193, 23);
		add(infName);
		
		background = new JLabel("");
		background.setBounds(0,0,814,591);
		this.setImageLabel(background, "resources/BackgroundMenu.png");
		add(background);
		
		
		
	}
	
	public String infName() {
		return namePlayer.getText();
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
