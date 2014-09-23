/**
 * Xuan Mai
 * Simulations class
 * Run simulations between computer strategies to compare
 */
public class Simulations {
  /**
   * Show the advantage of the player who goes first
   */
  public static void firstAdvantage(long simulations) {
    PigPlayer p1 = new SimpleHoldPlayer("Player 1");
    PigPlayer p2 = new SimpleHoldPlayer("Player 2");
    
    PigGame game = new PigGame(p1, p2);
    
    for (int i = 0; i < simulations; i++) {
      game.playGame();
    }
    double percent = p1.getWinRecord()*100.0/simulations;
    System.out.println(p1.getName() + ": " + p1.getWinRecord());
    System.out.println("Percentage of games won by " + p1.getName() + ": " + percent);
    System.out.println(p2.getName() + ": " + p2.getWinRecord());
  }
  
  /**
   * Show whether the first player is winning (no bias favoring the player who rolls first)
   */
  public static boolean isFirstBetter(long simulations, PigPlayer first, PigPlayer second) {
    PigGame game;
    int i;
    
    game = new PigGame(first, second);
    for (i = 0; i < simulations/2; i++) 
      game.playGame();
    
    game = new PigGame(second, first);
    for (i = 0; i < simulations/2; i++)
      game.playGame();
    
    System.out.println(first.getWinRecord());
    System.out.println(second.getWinRecord());
    
    double percent = first.getWinRecord()*100.0/simulations;
    
    if (first.getWinRecord() > second.getWinRecord()) {
      System.out.println("Percentage of games won by " + first.getName() + ": " + percent);
      return true;
    }
    else
      return false;
  }
  
  /**
   * Find the best hold value for simple hold player
   */
  public static void bestHoldValue(long simulations) {
    for (int i = 0; i < 4; i++) {
      PigPlayer p1 = new SimpleHoldPlayer("Xuan", 19);
      PigPlayer p2 = new SimpleHoldPlayer("Test", 25);
      
      System.out.println(Simulations.isFirstBetter(simulations, p1, p2));
    }
  }
  
  /**
   * Compare two strategies: four turns player and simple hold player
   */
  public static void fourTurnVsSimple(long simulations) {
    for (int i = 0; i < 4; i++) {
      PigPlayer p1 = new FourTurnsPlayer("Xuan");
      PigPlayer p2 = new SimpleHoldPlayer("Test", 25);
      
      System.out.println(Simulations.isFirstBetter(simulations, p1, p2));
    }
  }
  
  /**
   * Compare two strategies: watch opponent player and simple hold player
   */
  public static void watchVsSimple(long simulations) {
    for (int i = 0; i < 4; i++) {
      PigPlayer p1 = new WatchOpponentPlayer("Watch");
      PigPlayer p2 = new SimpleHoldPlayer("Simple", 25);
      
      System.out.println(Simulations.isFirstBetter(simulations, p1, p2));
    }
  }
  
  /**
   * Compare two strategies: my strategic player and simple hold player
   */
  public static void strategyVsSimple(long simulations) {
    for (int i = 0; i < 4; i++) {
      PigPlayer p1 = new StrategicPlayer("Strategy");
      PigPlayer p2 = new SimpleHoldPlayer("Simple", 25);
      
      System.out.println(Simulations.isFirstBetter(simulations, p1, p2));
    }
  }
  
  public static void main(String[] args) {
    Simulations test = new Simulations();
    PigGame.setVerbose(false);

//    test.bestHoldValue(10000);
    test.fourTurnVsSimple(10000);
  }
}