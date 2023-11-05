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
	private JLabel backgroundJLabel;

	public CreatorInformation(ActionListener listener) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(814, 591));
		setLayout(null);
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		JLabel photoCreator = new JLabel("");
		photoCreator.setBounds(455, 256, 239, 124);
		this.setImageLabel(photoCreator, "resources/LogoUPTC.png");
		add(photoCreator);
		
		JLabel infNameLabel = new JLabel("Name: ");
		infNameLabel.setForeground(new Color(255, 255, 255));
		infNameLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infNameLabel.setBounds(159, 176, 108, 29);
		add(infNameLabel);
		
		JLabel infIdLabel = new JLabel("ID: ");
		infIdLabel.setForeground(new Color(255, 255, 255));
		infIdLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infIdLabel.setBounds(159, 216, 108, 29);
		add(infIdLabel);
		
		JLabel infFacultyLabel = new JLabel("Faculty: ");
		infFacultyLabel.setForeground(new Color(255, 255, 255));
		infFacultyLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infFacultyLabel.setBounds(159, 256, 108, 29);
		add(infFacultyLabel);
		
		JLabel infSchoolLabel = new JLabel("school: ");
		infSchoolLabel.setForeground(new Color(255, 255, 255));
		infSchoolLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infSchoolLabel.setBounds(159, 296, 108, 29);
		add(infSchoolLabel);
		
		JLabel infYearLabel = new JLabel("Year: ");
		infYearLabel.setForeground(new Color(255, 255, 255));
		infYearLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infYearLabel.setBounds(159, 336, 108, 29);
		add(infYearLabel);
		
		JLabel infCourseLabel = new JLabel("Course: ");
		infCourseLabel.setForeground(new Color(255, 255, 255));
		infCourseLabel.setFont(new Font("balloons", Font.PLAIN, 25));
		infCourseLabel.setBounds(159, 376, 108, 29);
		add(infCourseLabel);
		
		MyButton backButton = new MyButton("BACK", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 147, 48);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		add(backButton);
		
		JLabel lblKarenJulianaPea = new JLabel("Karen Juliana Peña  Suarez");
		lblKarenJulianaPea.setForeground(Color.WHITE);
		lblKarenJulianaPea.setFont(new Font("balloons", Font.PLAIN, 25));
		lblKarenJulianaPea.setBounds(286, 176, 279, 29);
		add(lblKarenJulianaPea);
		
		JLabel infIdLabel_1 = new JLabel("202212066");
		infIdLabel_1.setForeground(Color.WHITE);
		infIdLabel_1.setFont(new Font("balloons", Font.PLAIN, 25));
		infIdLabel_1.setBounds(286, 216, 108, 29);
		add(infIdLabel_1);
		
		JLabel lblSistemas = new JLabel("Sistemas");
		lblSistemas.setForeground(Color.WHITE);
		lblSistemas.setFont(new Font("balloons", Font.PLAIN, 25));
		lblSistemas.setBounds(286, 256, 108, 29);
		add(lblSistemas);
		
		JLabel lblIngenieria = new JLabel("Ingenieria");
		lblIngenieria.setForeground(Color.WHITE);
		lblIngenieria.setFont(new Font("balloons", Font.PLAIN, 25));
		lblIngenieria.setBounds(286, 296, 108, 29);
		add(lblIngenieria);
		
		JLabel infYearLabel_1 = new JLabel("2023");
		infYearLabel_1.setForeground(Color.WHITE);
		infYearLabel_1.setFont(new Font("balloons", Font.PLAIN, 25));
		infYearLabel_1.setBounds(286, 336, 108, 29);
		add(infYearLabel_1);
		
		JLabel infCourseLabel_1 = new JLabel("Course: ");
		infCourseLabel_1.setForeground(Color.WHITE);
		infCourseLabel_1.setFont(new Font("balloons", Font.PLAIN, 25));
		infCourseLabel_1.setBounds(286, 376, 108, 29);
		add(infCourseLabel_1);
		
		backgroundJLabel = new JLabel("");
		backgroundJLabel.setBounds(0, 0, 814, 591);
		this.setImageLabel(backgroundJLabel, "resources/backgroundInformation.jpeg");
		add(backgroundJLabel);
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
