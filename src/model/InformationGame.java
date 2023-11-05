package model;

public class InformationGame {
	private int sizeSnakeInitial;
	private int speedMovement;
	private int timeObstacles;
	private int timeFood;
	
	
	public InformationGame(int sizeSnakeInitial, int speedMovement, int timeObstacles, int timeFood) {
		super();
		this.sizeSnakeInitial = sizeSnakeInitial;
		this.speedMovement = speedMovement;
		this.timeObstacles = timeObstacles;
		this.timeFood = timeFood;
	}
	
	
	public int getSizeSnakeInitial() {
		return sizeSnakeInitial;
	}
	public void setSizeSnakeInitial(int sizeSnakeInitial) {
		this.sizeSnakeInitial = sizeSnakeInitial;
	}
	public int getSpeedMovement() {
		return speedMovement;
	}
	public void setSpeedMovement(int speedMovement) {
		this.speedMovement = speedMovement;
	}
	public int getTimeObstacles() {
		return timeObstacles;
	}
	public void setTimeObstacles(int timeObstacles) {
		this.timeObstacles = timeObstacles;
	}
	public int getTimeFood() {
		return timeFood;
	}
	public void setTimeFood(int timeFood) {
		this.timeFood = timeFood;
	}
	
	
	@Override
	public String toString() {
		return "tamaño inicial: " + sizeSnakeInitial + "\nSpeed: " + speedMovement 
				+ "\nTiempo Obstaculo: " + timeObstacles + "\nTiempo Comida: " + timeFood + "\n";
	}
	
	
}
