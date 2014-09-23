/**
 * Xuan Mai
 * A computer strategy that created by me
 */

public class StrategicPlayer extends PigPlayer {
  // instance variable
  private int holdValue;
  
  /**
   * Default constructor that will name player "Strategy"
   */
  public StrategicPlayer() {
    super("Strategy");
  }
  
  /**
   * Constructor that takes a string as player's name
   */
  public StrategicPlayer(String n) {
    super(n);
  }
  
  /**
   * Return whether player wants to roll or not
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    int scoreDif = opponentScore - super.getScore();
    int scoreLeft = PigGame.GOAL - super.getScore();
    
    if (scoreDif > 0 && scoreDif < 30)
      holdValue = 25;
    else if (scoreDif >= 30)
      holdValue = 28;
    else
      holdValue = 21;
    
    if ((turnTotal < holdValue) && (turnTotal < scoreLeft))
      return true;
    
    return false;
  }
}