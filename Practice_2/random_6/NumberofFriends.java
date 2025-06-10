package random_6;

public class NumberofFriends {

	public static void main(String[] args) {

		// static = modifier. A single copy of a variable/method is created and shared.
		// The class "owns" the static member

		Friend friend1 = new Friend("Sponegbob");
		Friend friend2 = new Friend("Patrick");
		Friend friend3 = new Friend("Patrick");

		System.out.println(Friend.numberOfFriends);
		System.out.println(friend3.name);
		displaythis();
	}


	// **********************************************
	static class Friend {

		String name;

		static int numberOfFriends;


		Friend(String name) {
			this.name = name;
			numberOfFriends++;
		}
	}
	static void displaythis(){
		System.out.println("Some randoms stuff to diplay");
	}
}
