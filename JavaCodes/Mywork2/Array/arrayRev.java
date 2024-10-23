package Array;
import java.util.Scanner;

public class arrayRev {

	public static void main(String[] args) {
		//enter size of array.
		int i;
		System.out.println("Enter size of an array: ");
		Scanner scan = new Scanner(System.in);
		int tot = scan.nextInt();
		
		int[] arr = new int[tot];
				
		//enter values in array. 
		System.out.println("Enter values in Array:");
		for(i=0;i<tot;i++) {
			arr[i] = scan.nextInt();	
		}	
		
		//print reversal of array.
		System.out.println("Reversal of given number:");
		for(i=(tot-1);i>=0;i--)
			System.out.println(arr[i]);
	}

}
