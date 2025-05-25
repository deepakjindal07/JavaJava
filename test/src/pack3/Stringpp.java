package pack3;

public class Stringpp {

	int len = 10;
	int bredth = 20;

	public Stringpp(int i, int j) {
		this.len = i;
		this.bredth = j;

	}
	
    public void displayDimensions() {
        System.out.println("Box dimensions: " + len + " x " + bredth);
    }

	public static void main(String[] args) {
		Stringpp box1 = new Stringpp(10, 20);
		box1.displayDimensions();
		Stringpp box2 = new Stringpp(20, 30);
		box2.displayDimensions();
	}
}
