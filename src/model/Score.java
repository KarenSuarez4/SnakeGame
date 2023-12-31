package model;

import presenter.Presenter;

public class Score extends Thread{
	private boolean flag;
	private Presenter presenter;
	private int timeScore;
	private int timeSecondsScore;
	
	public Score (Presenter presenter) {
		this.presenter = presenter;
		flag = true;
	}
	
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(100);
				timeScore++;
				if (timeScore%10 == 0) {
					timeSecondsScore++;
					presenter.changeTimeScore(timeSecondsScore);
				}
				presenter.setScore();
				
				flag = presenter.flagFinishGame();
				
				if (flag) {
					flag = presenter.getFlagBack();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}while(flag == true);
		
		presenter.writeScore();
		
	}


	public int getTimeSecondsScore() {
		return timeSecondsScore;
	}


	public void setTimeSecondsScore(int timeSecondsScore) {
		this.timeSecondsScore = timeSecondsScore;
	}
	
	
	
	
	
	
}
