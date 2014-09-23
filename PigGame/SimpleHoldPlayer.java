/**
 * Xuan Mai
 * A computer strategy that will stop rolling when the turn total is 20.
 */

public class SimpleHoldPlayer extends PigPlayer {
  // instance variable
  private int holdValue;
  
  /**
   * Default constructor that will set the hold value to 20;
   */
  public SimpleHoldPlayer() {
    holdValue = 20;
  }
  
  /**
   * Constructor that will take a string as the name for player
   */
  public SimpleHoldPlayer(String name) {
    this();
    super.setName(name);
  }
  
  /**
   * Constructor that will take a string as the name and an integer as a hold value
   */
  public SimpleHoldPlayer(String name, int value) {
    this(name);
    holdValue = value;
  }
  
  /**
   * Return whether player wants to roll or not
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    int scoreLeft = PigGame.GOAL - super.getScore();
    
    if ((turnTotal < holdValue) && (turnTotal < scoreLeft))
      return true;
    return false;
  }
}