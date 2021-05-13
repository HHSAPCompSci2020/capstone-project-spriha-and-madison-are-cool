
public class GameLevel {
	public static int MAX_LEVEL = 1 ;
	public static int GENERATE_AFTER = 300 ;
	
	private int level ;
	private int speed ;
	private int foodFrequency ;
	private int maxObstacleCount ;
	
	public GameLevel(int level) {
		this.level = level ;
		this.speed = 3 ;
		this.foodFrequency = 2 ;			
		nextLevel();
	}
	
	public void init() {
		this.level = 0 ;
		nextLevel();
	}
	public boolean nextLevel() {
		if(level == MAX_LEVEL) {
			return false ;
		}
		level += 1 ;
		
		switch (level) {
			case 1:
				this.speed = 5 ;
				this.foodFrequency = 2 ;
				//this.maxObstacleCount = 4 ;			
				break ;
			case 2:
				this.speed = 4 ;
				this.foodFrequency = 5 ;
				this.maxObstacleCount = 4 ;			
				break ;
			default:
				break ;
		}
		return true ;
	}

	public int getSpeed() {
		return speed ;
	}

	public int getFoodFrequency() {
		return foodFrequency ;
	}

	public int getMaxObstacleCount() {
		return maxObstacleCount ;
	}

	public int getLevel() {
		return level;
	}
}
