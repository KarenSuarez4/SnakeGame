package model;

import javax.swing.JFrame;

import presenter.Presenter;

public class Movement extends Thread{
	private int move;
	private KeyListenerThread keyListenerThread;
	private Presenter presenter;
	
	public Movement(JFrame frame, Presenter presenter) {
		this.presenter = presenter;
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

		}while(move != 50);
	}
	
	public void changeMove(int moveKey) {
		this.move = moveKey;
		
		switch (move) {
			case 87:
			case 38:
				presenter.moveSnake(move);
				break;
				
			case 65:
			case 37:
				presenter.moveSnake(move);
				break;
				
			case 68:
			case 39:
				presenter.moveSnake(move);
				break;
				
			case 83:
			case 40:
				presenter.moveSnake(move);
				break;
	
			default:
				break;
		}
	}
	
}
