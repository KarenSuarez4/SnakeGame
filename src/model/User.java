package model;


public class User {
	private String name;
	private int score;
	private String time;
	
	public User(String name, int score, String time) {
		super();
		this.name = name;
		this.score = score;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
	
	
}
