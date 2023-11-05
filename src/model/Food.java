package model;

import presenter.Presenter;

public class Food extends Thread {
	private Presenter presenter;
	private int xFood;
	private int yFood;
	private boolean flag;
	private long timeFood;
	
	public Food(Presenter presenter, long timeFood) {
		this.presenter = presenter;
		this.timeFood = timeFood;
		flag = true;
	}

	@Override
	public void run() {
		do {
			xFood = (int) (10 + Math.random() * (700 - 10 + 1));  
        	yFood = (int) (10 + Math.random() * (400 - 10 + 1));  
        	
        	changePositionFood();
            
            try {
            	Thread.sleep(timeFood);
   			} catch (InterruptedException e) {
   				e.printStackTrace();
   			}
             
            
            flag = presenter.flagFinishGame();
			
			if (flag) {
				flag = presenter.getFlagBack();
			}
		}while(flag == true);
	}
	
	public void changePositionFood() {
		presenter.changePositionFood(xFood, yFood);
	}
	
    

   
}
