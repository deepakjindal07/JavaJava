package pack1;

class Prototype extends button implements TrackPad {

	@Override
	void pressVol() {
		System.out.println("Pressing volumeUpbutton");

	}

	@Override
	void pressPow() {
		// TODO Auto-generated method stub

	}

	@Override
	public void trackCross() {
		// TODO Auto-generated method stub
		
	}

}

public class RemoteControl {
	public static void main(String[] args) {
		System.out.println("Main method");
		Prototype prot = new Prototype();
		prot.pressVol();

	}
}
