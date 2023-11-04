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
        	
        	changePositionFood();
            
            try {
            	Thread.sleep(6000);
   			} catch (InterruptedException e) {
   				e.printStackTrace();
   			}
             
            
			flag = presenter.flagFinishGame();
			
		}while(flag == true);
	}
	
	public void changePositionFood() {
		presenter.changePositionFood(xFood, yFood);
	}
	
    

   
}
