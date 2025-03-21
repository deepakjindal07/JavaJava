package basics_large;
import java.util.Arrays;

class Triplet implements Comparable<Triplet> {
	int a;
	int b;
	int c;

	public Triplet(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "(" + a + "," + b + "," + c + ")";
	}

	@Override
	public int compareTo(Triplet d) {
		return this.c - d.c;
	}
}

class Gk {
	public static void main(String[] args) {
		int num = 3;
		Triplet arr[] = new Triplet[num];
		arr[0] = new Triplet(93, 18, 52);
		arr[1] = new Triplet(13, 17, 22);
		arr[2] = new Triplet(6, 9, 12);
		Arrays.sort(arr);
		print(arr);
	}

	public static void print(Triplet[] arr) {
		for (Triplet element : arr) {
			System.out.println(element);
		}
	}
}