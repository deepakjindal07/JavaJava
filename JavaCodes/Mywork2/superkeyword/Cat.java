package superkeyword;

public class Cat extends Animal{

	
	public void Noise()	{
		super.Noise();//Super here
		System.out.println("make Noise method in child class.");
		
	}
	
	public void eat() {
		System.out.println("Eat method in child class");
	}

}
