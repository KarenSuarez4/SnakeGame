package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.User;
import view.MyComponents.MyButton;

public class ScorePanel extends JPanel {
	private JTable table;
	private DefaultTableModel modelTableModel;
	private JLabel backgroundJLabel;

	public ScorePanel(ActionListener listener) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(814, 591));
		setLayout(null);
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		table = new JTable();
		
		modelTableModel = new DefaultTableModel(new Object[][] {{"", "", ""},{"", "", ""}} ,new String[] {"Name", "Score", "Time"});
		table.setModel(modelTableModel);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 128, 734, 402);
		add(scrollPane);
		
		MyButton backButton = new MyButton("BACK", new Color(244,16,244), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 147, 48);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		add(backButton);
		
		backgroundJLabel = new JLabel("");
		backgroundJLabel.setBounds(0, 0, 814, 591);
		this.setImageLabel(backgroundJLabel, "resources/backgroundGamePanel.jpeg");
		add(backgroundJLabel);
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
	
	public void setInformationModel(ArrayList<User> userList) {
		modelTableModel.setRowCount(0);
		for (User user : userList) {
			modelTableModel.addRow(new String[] {user.getName(), user.getScore()+"" , user.getTime()});
		}
		revalidate();
		repaint();
	}
	
	
}
