package random_8;

public class ShutDownHook {

	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("Shutdown Hook is running !");
			}
		});
		System.out.println("Application Terminating ...");
	}
}
