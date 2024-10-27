package testingSkills;

public class NumRev {

	public static void main(String[] args) {
		int num = 12345;
		char ch = 'c';
		String major = "Major";

		char[] charr = {1,2,3,4,5,6};

		int xxx = charr.length;


		StringBuilder str = new StringBuilder(Integer.toString(num));
		str.reverse();

		System.out.println(str);



	}

}
