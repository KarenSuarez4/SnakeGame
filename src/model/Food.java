package model;

import presenter.Presenter;

public class Food extends Thread {
	private Presenter presenter;
	private int xFood;
	private int yFood;
	private boolean flag;
	
	public Food(Presenter presenter) {
		this.presenter = presenter;
		flag = true;
	}

	@Override
	public void run() {
		do {

			xFood = (int) (10 + Math.random() * (720 - 10 + 1));  
        	yFood = (int) (10 + Math.random() * (420 - 10 + 1));  
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
		presenter.changePositionFood(xFood, yFood);
	}
	
    

   
}
