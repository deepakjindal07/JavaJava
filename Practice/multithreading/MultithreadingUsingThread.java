package multithreading;

public class MultithreadingUsingThread extends Thread {

	@Override
	public void run() {
		try {
			sleep(1000);
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");

		} catch (Exception e) {
			System.out.println("Exception is caught");
		}
	}

	public static void main(String[] args) {

		for(int i = 0; i < 5; i++){
			MultithreadingUsingThread obj = new MultithreadingUsingThread();
			obj.start();
		}
	}
}
