/**
 * Xuan Mai
 * Allow user to play
 */

import java.util.Scanner;

public class UserPigPlayer extends PigPlayer {
  /**
   * Constructor that takes a string as user's name
   */
  public UserPigPlayer (String n) {
    super(n);
  }
  
  /**
   * Return whether user wants to roll or not
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Total turn: " + turnTotal);
    System.out.println("Do you want to roll or hold ?");
    String roll = keyboard.nextLine();
    
    if (roll.equals(""))
      return true;
    else
      return false;
  }
  
  public static void main(String[] args) {
    UserPigPlayer p1 = new UserPigPlayer("Xuan");
    
    p1.getName();
    p1.isRolling(1, 0); 
  }
}