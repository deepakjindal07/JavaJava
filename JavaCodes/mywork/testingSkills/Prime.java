package testingSkills;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
        int temp, num;
        boolean isPrime = true;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        in.close();


        for (int i = 2; i <= num/2; i++) {
        	System.out.println("i ="+i);
            temp = num%i;
            System.out.println("temp ="+temp);
            System.out.println();
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
			System.out.println(num + " number is prime");
		} else {
			System.out.println(num + " number is not a prime");
		}
    }
}
