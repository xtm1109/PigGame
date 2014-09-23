/**
 * Xuan Mai
 * A computer strategy that will reach the goal in four turns
 */

public class FourTurnsPlayer extends PigPlayer {
  // instance variables
  private int holdValue;
  private int numberOfRolls = 4;
  
  /**
   * Default constructor that will name player "Player"
   */
  public FourTurnsPlayer() {
    super.setName("Player");
  }
  
  /**
   * Constructor that will take a name for player
   */
  public FourTurnsPlayer(String n) {
    super.setName(n);
  }
  
  /**
   * Reset player
   */
  public void reset() {
    super.reset();
    numberOfRolls = 4;
  }
  
  /**
   * Return whether players want to roll or hold
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    int scoreLeft = PigGame.GOAL - super.getScore();
    holdValue = scoreLeft/numberOfRolls;
    
    if (turnTotal >= holdValue) {
      numberOfRolls--;
      return false;
    }
    if (turnTotal > scoreLeft) {
      numberOfRolls--;
      return false;
    }
    return true;
  }
}