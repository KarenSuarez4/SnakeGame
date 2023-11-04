package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import model.Food;
import model.KeyListenerThread;
import model.Movement;
import model.Obstacles;
import model.Score;
import view.MyFrame;

public class Presenter implements ActionListener{
	private MyFrame myFrame;
	private Movement movement;
	private Obstacles obstacles;
	private Score score;
	private Food food;
	
	public Presenter() {
		myFrame = new MyFrame(this);
		movement = new Movement(myFrame, this);
		obstacles = new Obstacles(this);
		score = new Score(this);
		food = new Food(this);
		this.game();
	}
	
	public void game() {
		
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
				myFrame.showGamePanel();
				movement.start();
				obstacles.start();
				food.start();
				score.start();
				break;
				
			case "backMenu":
				myFrame.showMenuPanel();
				break;
			 
			default:
				break;
		}
		
	}

	public void moveSquartSnake(double xSnake, double ySnake) {
		myFrame.moveSquartSnake(xSnake, ySnake);
		myFrame.flagFinishGame();
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
