package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.rowset.JoinRowSet;

import model.Food;
import model.InformationGame;
import model.KeyListenerThread;
import model.Movement;
import model.Obstacles;
import model.Score;
import model.User;
import persistens.ReadFile;
import persistens.ReadFileUser;
import persistens.WriteFile;
import view.Exeption;
import view.MyFrame;

public class Presenter implements ActionListener{
	private MyFrame myFrame;
	private ReadFile readFile;
	private ReadFileUser readFileUser;
	private WriteFile writeFile;
	private Exeption exeption;
	private ArrayList<InformationGame> informationFile;
	private ArrayList<User> userFile;
	private boolean flag;
	
	public Presenter() {
		try {
			informationFile = new ArrayList<InformationGame>();
			userFile = new ArrayList<User>();
			readFile = new ReadFile();
			readFileUser = new ReadFileUser();
			writeFile = new WriteFile();
			myFrame = new MyFrame(this);
			flag = true;
			informationFile = readFile.readMyFile("resources/InformationGame.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		
		switch (source) {
			case "creatorInformationMenu":
				myFrame.showCreatorInformation();
			 break;
			 
			case "scoreButtonMenu":
				myFrame.showScorePanel();
				break;
				
			case "playButtonMenu":
				if (!myFrame.infName().isEmpty()) {
					myFrame.showLevels();
				} else {
					exeption = new Exeption("Ingrese un nombre.", "resources/JDialog/caution.png");
				}
				
				break;
				
			case "easyLevel":
				startGame(informationFile.get(0).getSizeSnakeInitial(), informationFile.get(0).getSpeedMovement(), informationFile.get(0).getTimeObstacles(), informationFile.get(0).getTimeFood());
				break;
				
			case "mediumLevel":
				startGame(informationFile.get(1).getSizeSnakeInitial(), informationFile.get(1).getSpeedMovement(), informationFile.get(1).getTimeObstacles(), informationFile.get(1).getTimeFood());
				break;
				
			case "hardLevel":
				startGame(informationFile.get(2).getSizeSnakeInitial(), informationFile.get(2).getSpeedMovement(), informationFile.get(2).getTimeObstacles(), informationFile.get(2).getTimeFood());
				break;
				
			case "backMenu":
				backGame();
				break;
			 
			default:
				break;
		}
		
	}
	
	public void startGame(int sizeSnakeInitial, int speedMovement, int timeObstacles, int timeFood) {
			Movement movement = new Movement(myFrame, this, speedMovement);
			Obstacles obstacles = new Obstacles(this, timeObstacles);
			Score score = new Score(this);
			Food food = new Food(this, timeFood);
			
			myFrame.revalidate();
			myFrame.showGamePanel();
			myFrame.createInitialSnake(sizeSnakeInitial);
			
			movement.start();
			obstacles.start();
			food.start();
			score.start();
			flag = true;

	}
	
	public void backGame() {
		flag = false;
		myFrame.showMenuPanel();
		myFrame.start();
	}
	
	public boolean getFlagBack() {
		return flag;
	}
	
	public void writeScore() {
		try {
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
	        String formattedDateTime = now.format(formatter);
			userFile.add(new User(myFrame.infName(),myFrame.getValueScore(), formattedDateTime));
			writeFile.parseJSON("resources/scoreInformation.json", userFile);			
			myFrame.setScoreTable(readFileUser.readMyFile("resources/scoreInformation.json"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void showEnd() {
		exeption = new Exeption("PERDISTE :(", "resources/sadIcon.png");
	}
	
	public int getValueScore() {
		return myFrame.getValueScore();
	}

	public void moveSquartSnake(double xSnake, double ySnake) {
		myFrame.moveSquartSnake(xSnake, ySnake);
	}
	
	public void setScore() {
		myFrame.setScore();
	}
	
	public void changeTimeScore(int secondsScore) {
		myFrame.secondsScore(secondsScore);
	}
	
	public void changePositionObstacle(int xObstacle, int yObstacle) {
		myFrame.changePositionObstacle(xObstacle, yObstacle);
	}
	
	public void changePositionFood(int xFood, int yFood) {
		myFrame.changePositionFood(xFood, yFood);
	}
	
	public boolean flagFinishGame() {
		return myFrame.flagFinishGame();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Presenter();
	}
	
}

