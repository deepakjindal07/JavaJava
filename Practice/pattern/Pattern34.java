package pattern;
import java.util.Scanner;
/*
Write the program to print the following pattern
        1
      2 2
    3 3 3
  4 4 4 4
5 5 5 5 5
*/
public class Pattern34 {
	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		for(int i=0;i<N;i++){
			for(int j = 0;j<N-i-1;j++) {
				System.out.print("  ");
			}
			for(int j=0;j<=i;j++) {
				if(j == 0) {
					System.out.print(i+1);
				} else {
					System.out.print(" "+(i+1));
				}
			}
			if(i != N-1) {
				System.out.println();
			}
		}
		scanner.close();
	}
}
/*
Input
5
Output
        1
      2 2
    3 3 3
  4 4 4 4
5 5 5 5 5
*/