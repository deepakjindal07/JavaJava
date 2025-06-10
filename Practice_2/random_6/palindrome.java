package random_6;

import java.util.Scanner;

public class palindrome {
	
	public static void main(String[] args) {
	      int num, rem, rev=0;
	      Scanner s = new Scanner(System.in);
	      
	      System.out.print("Enter a Number: ");
	      num = s.nextInt();
	      
	      System.out.println("Num is "+num);
	      
	      while(num!=0)
	      {
	         rem = num%10;
	         System.out.println("rem is "+rem);   
	         
	         rev = (rev*10) + rem;
	         	         System.out.println("rev"+rev); 
	         num = num/10;
	         System.out.println("num is "+num); 
	      }
	     
	      
	      System.out.println("\nReverse = " +rev);
			
	}
}
