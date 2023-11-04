package model;

import presenter.Presenter;

public class Obstacles extends Thread {
	private Presenter presenter;
	private int xObstacle;
	private int yObstacle;
	private boolean flag;
	
	public Obstacles(Presenter presenter) {
		this.presenter = presenter;
		flag = true;
	}

	@Override
	public void run() {
		do {

			xObstacle = (int) (10 + Math.random() * (700 - 10 + 1));  
        	yObstacle = (int) (10 + Math.random() * (420 - 10 + 1));  
            changePositionObstacle();
			flag = presenter.flagFinishGame();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(flag == true);
	}
	
	public void changePositionObstacle() {
		presenter.changePositionObstacle(xObstacle, yObstacle);
	}
	
    

   
}
