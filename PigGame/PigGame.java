/**
 * Xuan Mai
 * PigGame class with the GOAL of winning is 100
 */ 
import java.util.Scanner;

public class PigGame {
  // instance variables
  public final static int GOAL = 100;
  private PigPlayer p1, p2;
  private static boolean verbose;
  
  /**
   * Default constructor 
   */
  public PigGame() {
    p1 = new UserPigPlayer("Player 1");
    p2 = new UserPigPlayer("Player 2");
  }
  
  /**
   * Constructor that take two names for two user pig players
   */
  public PigGame(String n1, String n2) {
    p1 = new UserPigPlayer(n1);
    p2 = new UserPigPlayer(n2);
  }
  
  /**
   * Constructor that take two pig players
   */
  public PigGame(PigPlayer pp1, PigPlayer pp2) {
    p1 = pp1;
    p2 = pp2;
  }
  
  /**
   * Reset two players
   */
  public void reset() {
    p1.reset();
    p2.reset();
  }
  
  /**
   * Set whether the user-friendly instruction shows up or not
   */
  public static void setVerbose(boolean printOrNot) {
    verbose = printOrNot;
  }
  
  /**
   * Play a turn
   */
  public static int playTurn(PigPlayer player, PigPlayer opponent) {
    int result, turnTotal;
    boolean rollAgain;
    
    turnTotal = 0;
    
    do {
      result = Die.roll();
      if (verbose)
        System.out.println(player.getName() + ", you just rolled a " + result);
      if (result == 1) {
        if (verbose) {
          System.out.println("Sorry !");
          System.out.println();
        }
        return 0;
      }
      
      turnTotal = turnTotal + result;
      rollAgain = player.isRolling(turnTotal, opponent.getScore());
    } while (rollAgain == true);
    
    return turnTotal;
  }
  
  /**
   * Play a Pig Game
   */
  public void playGame() {
    do {
      p1.addPoints(this.playTurn(p1, p2));
      if (verbose) {
        System.out.println(p1.getName() + "(" + p1.getScore() + ") vs. " + 
                           p2.getName() + "(" + p2.getScore() + ")");
        System.out.println();
      }
      if (p1.getScore() < PigGame.GOAL)
        p2.addPoints(this.playTurn(p2, p1));
      if (verbose) {
        System.out.println(p1.getName() + "(" + p1.getScore() + ") vs. " + 
                           p2.getName() + "(" + p2.getScore() + ")");
        System.out.println();
      }
      
    } while ((p1.getScore() < PigGame.GOAL) && (p2.getScore() < PigGame.GOAL));
    
    if (p1.getScore() >= PigGame.GOAL) {
      if (verbose)
        System.out.println(p1.getName() + " won !");
    }
    
    if (p2.getScore() >= PigGame.GOAL) {
      if (verbose)
        System.out.println(p2.getName() + " won !");
    }
    
    this.reset();
  }
  
  /**
   * Print out the rule of the game
   */
  public static void rule() {
    System.out.println("Let's play Pig Game !!");
    System.out.println();
    System.out.println("Two players will roll the 6-sided die.");
    System.out.println("Whoever reach 100 points first will be the winner.");
    System.out.println("The players can hold the score, which is sum of the rolls, whenever they want");
    System.out.println("If the players roll an 1, they will lose all the scores.");
    System.out.println();
    System.out.println("Press 'Enter' to continue rolling.");
    System.out.println("Press any other key to hold the score");
    
    for (int i = 0; i < 50; i++)
      System.out.print("-");
    System.out.println();
  }
  
  /**
   * Create a Pig Game that two users will play against each other
   */
  public static void userVsUser() {
    Scanner keyboard = new Scanner(System.in);
    
    PigGame.rule();
    
    System.out.println("Please enter two player's names");
    String name1 = keyboard.next();
    String name2 = keyboard.next();
    
    PigGame game1;
    
    if (Math.random() <= 0.5)
      game1 = new PigGame(name1, name2);
    else 
      game1 = new PigGame(name2, name1);
    
    game1.playGame();
  }
  
  /**
   * Create a Pig Game that user will player against computer
   */
  public static void userVsComputer() {
    Scanner keyboard = new Scanner(System.in);
    PigGame game1;
    
    System.out.println("Please enter your name");
    String username = keyboard.next();
    
    PigPlayer user = new UserPigPlayer(username);
    PigPlayer comp = new FourTurnsPlayer("FourTurn");
    
    if (Math.random() <= 0.5)
      game1 = new PigGame(user, comp);
    else 
      game1 = new PigGame(comp, user);
    
    game1.playGame();
  }
  
  /**
   * Create a Pig Game that two computers will player against each other
   */
  public static void computerVsComputer() {
    PigGame game;
    
    PigPlayer comp1 = new SimpleHoldPlayer("Player 1", 25);
    PigPlayer comp2 = new FourTurnsPlayer("Player 2");
    
    if (Math.random() <= 0.5)
      game = new PigGame(comp1, comp2);
    else 
      game = new PigGame(comp2, comp1);
    
    game.playGame();
  }
  
  public static void main(String[] args) {
    PigGame.setVerbose(true);
    PigGame.computerVsComputer();
  }
}