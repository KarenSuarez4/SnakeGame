package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.User;


public class MyFrame extends JFrame {
	private final static String CREATORINFORMATION = "creatorInformation";
	private final static String MENU = "menu";
	private final static String SCORE = "score";
	private final static String GAMEPANEL = "gamePanel";
	private final static String LEVELS = "levels";
	private MenuPanel menuPanel;
	private ScorePanel scorePanel;
	private CreatorInformation creatorInformation;
	private GamePanel gamePanel;
	private Levels levels;
	private JPanel cardLayout;
	private CardLayout card;
	
	public MyFrame(ActionListener listener) {
		super("Snake Game");
		this.setSize(830, 630);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.initComponent(listener);
		this.setVisible(true);
	}
	
	public void initComponent(ActionListener listener) {
		menuPanel = new MenuPanel(listener);
		menuPanel.setBounds(0, 0, 814, 591);
		
		creatorInformation = new CreatorInformation(listener);
		creatorInformation.setBounds(0, 0, 814, 591);
		
		scorePanel = new ScorePanel(listener);
		scorePanel.setBounds(0, 0, 814, 591);
		
		gamePanel = new GamePanel(listener);
		gamePanel.setBounds(0, 0, 814, 591);
		
		levels = new Levels(listener);
		levels.setBounds(0, 0, 814, 591);
		
		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		cardLayout.setBounds(0,0,this.getWidth(), this.getHeight());
		cardLayout.add(menuPanel, MENU);
		cardLayout.add(creatorInformation, CREATORINFORMATION);
		cardLayout.add(scorePanel, SCORE);
		cardLayout.add(gamePanel, GAMEPANEL);
		cardLayout.add(levels, LEVELS);
		getContentPane().add(cardLayout);
		
		card = (CardLayout)(cardLayout.getLayout());
	}
	
	public void setScoreTable(ArrayList<User> userList) {
		scorePanel.setInformationModel(userList);
	}
	
	public String infName() {
		return menuPanel.infName();
	}
	
	public void start() {
		gamePanel.start();
	}
	
	public void createInitialSnake(int sizeSnake) {
		gamePanel.createInitialSnake(sizeSnake);
	}
	
	public void secondsScore(int secondScore) {
		gamePanel.secondsScore(secondScore);
	}
	
	public int getValueScore() {
		return gamePanel.getValueScore();
	}
	
	public void setScore() {
		gamePanel.setScore();
	}
	
	public void showLevels(){
		card.show(cardLayout, LEVELS);
	}
	
	public void showCreatorInformation(){
		card.show(cardLayout, CREATORINFORMATION);
	}
	
	public void showScorePanel(){
		card.show(cardLayout, SCORE);
	}
	
	public void showGamePanel(){
		this.setFocusable(true);
		card.show(cardLayout, GAMEPANEL);
	}
	
	public void showMenuPanel(){
		card.show(cardLayout, MENU);
	}
	
	public void moveSquartSnake(double xSnake, double ySnake) {
		gamePanel.moveSquartSnake(xSnake, ySnake);
	}
	
	public void changePositionObstacle(int xObstacle, int yObstacle) {
		gamePanel.changePositionObstacle(xObstacle, yObstacle);
	}
	
	public void changePositionFood(int xFood, int yFood) {
		gamePanel.changePositionFood(xFood, yFood);
	}
	
	public boolean flagFinishGame(){
		return gamePanel.flagFinishGame();
	}
	
}
