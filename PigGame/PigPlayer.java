/**
 * Xuan Mai
 * Abstract class PigPlayer
 */

public abstract class PigPlayer {
  // instance variables
  private String name;
  private int score, gamewon;
  
  /**
   * Default constructor that will name pig player "Player"
   */
  public PigPlayer() {
    name = "Player";
  }
  
  /**
   * Constructor that will take a string as a name for player
   */
  public PigPlayer(String n) {
    this.setName(n);
  }
  
  /**
   * Set a name for player
   */
  public void setName(String n) {
    name = n;
  }
  
  /**
   * Get player's name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Reset player
   */
  public void reset() {
    score = 0;
  }
  
  /**
   * Add points to player's score
   */
  public void addPoints(int turnTotal) {
    score = score + turnTotal;
    
    if (score >= PigGame.GOAL) 
      gamewon++;
  }
  
  /**
   * Check whether player is win or not
   */
  public boolean won() {
    if (score >= PigGame.GOAL)
      return true;
    else
      return false;
  }
  
  /**
   * Get player's score
   */
  public int getScore() {
    return score;
  }
  
  /**
   * Get player's win record
   */
  public int getWinRecord() {
    return gamewon;
  }
  
  /**
   * Print out player's name and player's score
   */
  public String toString() {
    return name + " has the score of " + score;
  }
  
  /**
   * Abstract method
   */
  public abstract boolean isRolling(int turnTotal, int opponentScore);
    
//  public static void main(String[] args) {
//    PigPlayer p1 = new PigPlayer("Xuan");
//    
//    p1.addPoints(101);
//    System.out.println(p1.getWinRecord());
//    p1.reset();
//    System.out.println(p1.toString());
//  }
}