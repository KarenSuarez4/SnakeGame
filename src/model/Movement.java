package model;

import javax.swing.JFrame;

import presenter.Presenter;

public class Movement extends Thread{
	private int move;
	private KeyListenerThread keyListenerThread;
	private Presenter presenter;
	private boolean flag;
	
	public Movement(JFrame frame, Presenter presenter) {
		this.presenter = presenter;
		flag = true;
		keyListenerThread = new KeyListenerThread(frame);
		keyListenerThread.start();
	}
	
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (move != keyListenerThread.getKeyCode()) {
				this.changeMove(keyListenerThread.getKeyCode());
			}
			
			this.changeMove(move);
			flag = presenter.flagFinishGame();

		}while(flag == true);
	}
	
	public void changeMove(int moveKey) {
		this.move = moveKey;
		
		switch (move) {
			case 87:
			case 38:
				presenter.moveSquartSnake(0, -20);
				break;
				
			case 65:
			case 37:
				presenter.moveSquartSnake(-20, 0);
				break;
				
			case 68:
			case 39:
				presenter.moveSquartSnake(20, 0);
				break;
				
			case 83:
			case 40:
				presenter.moveSquartSnake(0, 20);
				break;
	
			default:
				break;
		}
	}
	
}
