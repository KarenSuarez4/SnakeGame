package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.MyComponents.MyButton;

public class ScorePanel extends JPanel {
	private JTable table;

	public ScorePanel(ActionListener listener) {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(814, 591));
		setLayout(null);
		initComponent(listener);
	}
	
	public void initComponent(ActionListener listener) {
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {{"", "", ""},{"", "", ""}} ,new String[] {"Name", "Score", "Time"}));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 128, 734, 402);
		add(scrollPane);
		
		MyButton backButton = new MyButton("BACK", new Color(255,93,40,255), new Color(237, 116, 50), Color.WHITE, Color.WHITE, 25);
		backButton.setBounds(42, 36, 147, 48);
		backButton.setActionCommand("backMenu");
		backButton.addActionListener(listener);
		add(backButton);
	}
}
