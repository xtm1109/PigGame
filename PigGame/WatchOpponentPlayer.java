/**
 * Xuan Mai
 * A computer strategy that is very concerned about opponent's score
 * Willing to take risks when losing
 */

public class WatchOpponentPlayer extends PigPlayer {
  // instance variables
  private int holdValue = 23;
  private int fraction = 7;
  
  /**
   * Default constructer that will name player "Watch"
   */
  public WatchOpponentPlayer() {
    super.setName("Watch");
  }
  
  /**
   * Constructor that will take a string as player's name
   */
  public WatchOpponentPlayer(String n) {
    super.setName(n);
  }
  
  /**
   * Constructor that will take a string as player's name, an integer as hold value, and an integer as fraction
   */
  public WatchOpponentPlayer(String n, int value, int divide) {
    setName(n);
    holdValue = value;
    fraction = divide;
  }
  
  private static boolean almostWin(int score1, int score2) {
    int scoreLeft = PigGame.GOAL - score1;
    int opponentSLeft = PigGame.GOAL - score2;
    int target = 25;
    
    if ((scoreLeft <= target) || (opponentSLeft <= target))
      return true;
    else  
      return false;
  }
  
  /**
   * Return whether player wants to roll or not
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    int scoreBehind = opponentScore - super.getScore();
    int newHoldValue = holdValue + scoreBehind/fraction;
      
    if (super.getScore() + turnTotal < PigGame.GOAL) { 
      if (almostWin(super.getScore(), opponentScore))
        return true;
      if (turnTotal < newHoldValue) 
        return true;
    }
    return false;
  }
}