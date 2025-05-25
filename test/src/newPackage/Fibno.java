package newPackage;

public class Fibno {

	public static void main(String[] args) {
		int num = 6;

		// 0,1,1,2,3,5,8;

		int temp = 0;
		int first = 1;
		int second = 1;

		for (int i = 0; i < num; i++)
		{
			temp = first + second;
			first = second;
			second = temp;

		}

	}

}
