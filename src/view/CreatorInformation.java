package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import view.MyComponents.MyButton;

public class CreatorInformation extends JPanel {

	public CreatorInformation(ActionListener listener) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(814, 591));
		setLayout(null);
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		JLabel photoCreator = new JLabel("");
		photoCreator.setBounds(470, 164, 239, 124);
		this.setImageLabel(photoCreator, "resources/LogoUPTC.png");
		add(photoCreator);
		
		JLabel infNameLabel = new JLabel("Name: ");
		infNameLabel.setForeground(Color.BLACK);
		infNameLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infNameLabel.setBounds(95, 225, 108, 29);
		add(infNameLabel);
		
		JLabel infIdLabel = new JLabel("ID: ");
		infIdLabel.setForeground(Color.BLACK);
		infIdLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infIdLabel.setBounds(95, 265, 108, 29);
		add(infIdLabel);
		
		JLabel infFacultyLabel = new JLabel("Faculty: ");
		infFacultyLabel.setForeground(Color.BLACK);
		infFacultyLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infFacultyLabel.setBounds(95, 305, 108, 29);
		add(infFacultyLabel);
		
		JLabel infSchoolLabel = new JLabel("school: ");
		infSchoolLabel.setForeground(Color.BLACK);
		infSchoolLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infSchoolLabel.setBounds(95, 345, 108, 29);
		add(infSchoolLabel);
		
		JLabel infYearLabel = new JLabel("Year: ");
		infYearLabel.setForeground(Color.BLACK);
		infYearLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infYearLabel.setBounds(95, 385, 108, 29);
		add(infYearLabel);
		
		JLabel infCourseLabel = new JLabel("Course: ");
		infCourseLabel.setForeground(Color.BLACK);
		infCourseLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infCourseLabel.setBounds(95, 425, 108, 29);
		add(infCourseLabel);
		
		MyButton backButton = new MyButton("BACK", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 147, 48);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		add(backButton);
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
