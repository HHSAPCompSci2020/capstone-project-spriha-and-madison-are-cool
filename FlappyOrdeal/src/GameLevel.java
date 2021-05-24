/**
 * GameLevel represents an object that controls the level of difficulty of the Flappy Ordeal Game 
 * @author sprihapandey
 *
 */
public class GameLevel {
	public static int MAX_LEVEL = 1 ;
	public static int GENERATE_AFTER = 100;
	
	private int speed ;
	private int foodFrequency ;
	private int powerUpFrequency;
	/**
	 * Defines the level of difficulty of the game by initializing the values of the speed of the components in the game and the frequency of the Food and PowerUps
	 */
	public GameLevel() {
		this.speed = 5 ;
		this.foodFrequency = 2 ;	
		this.powerUpFrequency = 1;
	}
	
	/**
	 * Returns the speed of the FlappyBird in the FlappyBirdGame
	 * @return the speed of the FlappyBird in the FlappyBirdGame
	 */
	public int getSpeed() {
		return speed ;
	}
/**
 * Returns the frequency of the food in the FlappyBirdGame
 * @return the frequency of the food in the FlappyBirdGame
 */
	public int getFoodFrequency() {
		return foodFrequency ;
	}
	/**
	 * Returns the frequency of the powerups in the FlappyBirdGame
	 * @return the frequency of the powerups in the FlappyBirdGame
	 */
	public int getPowerUpFrequency() {
		return powerUpFrequency;
	}
}
