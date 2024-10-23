
public class Conditionals {

    public static void main(String[] args) {
        /*
            Syntax of if statements:
            if (boolean expression T or F) {
                // body
            } else {
                // do this
            }
        */
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		if (age>=18) {
			System.out.println("You can Drive!");		
		}
		else {
			System.out.println("You can't Drive!");
		}
		sc.close();
    }
}
