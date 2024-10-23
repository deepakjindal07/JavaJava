package VariableScoping;


public class InstanceVariable{
	public String geek; // Declared Instance Variable
	public static String boom ="NameOfSomething";
		 
		public InstanceVariable()
	    { 
		this.geek = "Shubham Jain"; // initializing Instance Variable
	    }
		

	public static void main(String[] args)
	{//Object Creation

		InstanceVariable name1 = new InstanceVariable();
	System.out.println("Name2is "+boom);
	System.out.println("Geek name is: " + name1.geek);

	
	}
}

/**
Each object will have its own copy of an instance variable, whereas we can only 
have one copy of a static variable per class, irrespective of how many objects 
we create.

Changes made in an instance variable using one object will not be reflected in 
other objects as each object has its own copy of the instance variable. In the 
case of a static variable, changes will be reflected in other objects as static 
variables are common to all objects of a class.

We can access instance variables through object references, and static variables 
can be accessed directly using the class name.

 */


