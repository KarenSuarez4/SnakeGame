package model;

import presenter.Presenter;

public class Obstacles extends Thread {
	private Presenter presenter;
	private int xObstacle;
	private int yObstacle;
	private boolean flag;
	private long timeObstacles;
	
	public Obstacles(Presenter presenter, long timeObstacles) {
		this.presenter = presenter;
		this.timeObstacles = timeObstacles;
		flag = true;
	}

	@Override
	public void run() {
		do {

			xObstacle = (int) (10 + Math.random() * (700 - 10 + 1));  
        	yObstacle = (int) (10 + Math.random() * (420 - 10 + 1));  
            changePositionObstacle();
            flag = presenter.flagFinishGame();
			
			if (flag) {
				flag = presenter.getFlagBack();
			}
			try {
				Thread.sleep(timeObstacles);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}while(flag == true);
	}
	
	public void changePositionObstacle() {
		presenter.changePositionObstacle(xObstacle, yObstacle);
	}
	
    

   
}
