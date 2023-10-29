package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import model.KeyListenerThread;
import model.Movement;
import view.MyFrame;

public class Presenter implements ActionListener{
	private MyFrame myFrame;
	private Movement movement;
	
	public Presenter() {
		myFrame = new MyFrame(this);
		movement = new Movement(myFrame, this);
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
				break;
				
			case "backMenu":
				myFrame.showMenuPanel();
				break;
			 
			default:
				break;
		}
		
	}
	
	public void moveSnake(int move) {
		myFrame.moveSnake(move);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Presenter();
	}
	
}
