
public class GameLevel {
	public static int MAX_LEVEL = 1 ;
	public static int GENERATE_AFTER = 100 ;
	
	private int speed ;
	private int foodFrequency ;
	private int powerUpFrequency;
	private int maxObstacleCount ;
	
	public GameLevel() {
		this.speed = 5 ;
		this.foodFrequency = 2 ;	
		this.powerUpFrequency = 1;
	}
	

	public int getSpeed() {
		return speed ;
	}

	public int getFoodFrequency() {
		return foodFrequency ;
	}
	
	public int getPowerUpFrequency() {
		return powerUpFrequency;
	}

	public int getMaxObstacleCount() {
		return maxObstacleCount ;
	}
}
