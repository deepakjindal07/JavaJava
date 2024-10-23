package collections;

import java.util.concurrent.CopyOnWriteArraySet;
public class CopyOnWriteArraySetExample extends Thread {

	static CopyOnWriteArraySet l = new CopyOnWriteArraySet();

	@Override
	public void run() {
		l.add("D");
	}
	public static void main(String[] args) {
		l.add("A");
		l.add("B");
		l.add("C");

		// Child Thread
		CopyOnWriteArraySetExample t = new CopyOnWriteArraySetExample();
		t.start();

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.println("Child is Going to add element");
		}

		System.out.println(l);
	}
}
