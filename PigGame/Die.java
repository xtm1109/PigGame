/**
 * Xuan Mai
 * Die class
 */

import java.util.Scanner;

public class Die {
  // instance variable
  private int side = 6;
  
  /**
   * Roll a 6-sided die
   */
  public static int roll() {
    double intercept, i1;
    int number;
    
    intercept = 1.0/6;
    number = 0;
    i1 = Math.random();
    
    for (int i = 1; i <= 6; i++) {
      if ((i1 >= (i-1)*intercept) && (i1 <= i*intercept)) {
        number = i;
        break;
      }
    }
    
    return number;
  }
  
  /**
   * Set the number of the side to the die
   */
  public void setSide(int s) {
    if (s >= 0)
      side = s;
  }
  
  /**
   * Return the number of the side of the die
   */
  public int getSide() {
    return side;
  }
  
  /**
   * Roll a die which has more than 6 sides
   */
  public int rollDie() {
    double intercept, i1;
    int number;
    
    intercept = 1.0/side;
    number = 0;
    i1 = Math.random();
    
    for (int i = 1; i <= side; i++) {
      if ((i1 >= (i-1)*intercept) && (i1 <= i*intercept)) {
        number = i;
        break;
      }
    }
    
    return number;
  }
  
  public static void main(String[] args) {
    Die play = new Die();
    
    play.setSide(8);
    
    for (int i = 0; i < 20; i++)
      System.out.print(play.rollDie() + " ");
    System.out.println(PigGame.GOAL);
  }
}