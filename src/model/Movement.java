package model;

import javax.swing.JFrame;

import presenter.Presenter;

public class Movement extends Thread{
	private int move;
	private KeyListenerThread keyListenerThread;
	private Presenter presenter;
	private boolean flag;
	private long speed;
	private int score;
	
	public Movement(JFrame frame, Presenter presenter, long speed) {
		this.presenter = presenter;
		this.speed = speed;
		flag = true;
		score = 10;
		keyListenerThread = new KeyListenerThread(frame);
		keyListenerThread.start();
	}
	
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (move != keyListenerThread.getKeyCode()) {
				this.changeMove(keyListenerThread.getKeyCode());
			}
			
			if(presenter.getValueScore()==score) {
				speed -= 20;
				score += 10;
			}
			
			this.changeMove(move);
			
			flag = presenter.flagFinishGame();
			
			if (flag) {
				flag = presenter.getFlagBack();
			}
			
			if (!presenter.flagFinishGame()) {
				presenter.showEnd();
			}

		}while(flag == true);
	}
	
	public void changeMove(int moveKey) {
		this.move = moveKey;
		
		switch (move) {
			case 87:
			case 38:
				presenter.moveSquartSnake(0, -25);
				break;
				
			case 65:
			case 37:
				presenter.moveSquartSnake(-25, 0);
				break;
				
			case 68:
			case 39:
				presenter.moveSquartSnake(25, 0);
				break;
				
			case 83:
			case 40:
				presenter.moveSquartSnake(0, 25);
				break;
	
			default:
				break;
		}
	}
}
