package random_5;

public class ThisKeywordDemo {

	int val;

	public ThisKeywordDemo() {
		System.out.println(this);


		System.out.println(this.val);
		val =10;
	}

	public static void main(String[] args) {
		new ThisKeywordDemo();
		new ThisKeywordDemo();
		new ThisKeywordDemo();
		new ThisKeywordDemo();

	}

}
