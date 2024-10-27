package prep2;

import java.util.Scanner;

public class CountDigits
{
   public static void main(String[] args)
   {
      int num, totaldigit=0;
      Scanner s = new Scanner(System.in);
      
      System.out.print("Enter a Number: ");
      num = s.nextInt();
      
      while (num!=0)
      {
    	  totaldigit++;
    	  num=num/10;
      }
      s.close();

      
      System.out.println("\nReverse = " +totaldigit);
   }
}