import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class NumberGame
 {
  public static void main(String[] args)
 {
    int MyNumber = (int)(Math.random() * 100) + 1;
    int k = 10;
    Scanner Sc = new Scanner(System.in);
    boolean correct = false;

    System.out.println("Guess for the Generated number (1-100) :\nYou have 10 Attempts to guess the number.");
    while (k > 0) 
{
      System.out.println("Enter your guess: ");
     int UserNumber = Sc.nextInt();
      if (UserNumber == MyNumber) 
    {
        System.out.println("WooHoo...CONGRATULATIONS!!!  Correct guess number \n You win!!!");
        break;
      }
      else if (UserNumber > MyNumber) 
{
        System.out.println("Your guess Number is to....Large.\nYou have " + (k - 1) + " Attempts left.");
        k--;
      }
      else
 {
        System.out.println("Your guess is too.... Small.\nYou have " + (k - 1) + " Attempts left.");
      }
      k--;
    }

    if (correct == false)
 {
      System.out.println("You ran out of tries.\nYou lose!");
    }
  }
}

