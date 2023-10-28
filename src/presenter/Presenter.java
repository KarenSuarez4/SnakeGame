package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import view.MyFrame;

public class Presenter implements ActionListener{
	private MyFrame myFrame;
	
	public Presenter() {
		myFrame = new MyFrame(this);
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
				break;
				
			case "backMenu":
				myFrame.showMenuPanel();
				break;
			 
			default:
				break;
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		new Presenter();
	}
	
}
