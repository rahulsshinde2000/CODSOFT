/*TASK 1

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
*/

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

