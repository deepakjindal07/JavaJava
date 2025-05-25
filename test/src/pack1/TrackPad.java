package pack1;

interface TrackPad {

	default void trackup() {
		System.out.println("VolumeUp");
	}

	static void trackdown() {
		System.out.println("VolumeDown");
	}

	void trackCross();
}
