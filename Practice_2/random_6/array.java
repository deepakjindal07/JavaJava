package random_6;

public class array {

	public static void main(String[] args) {

		// 2D array = an array of arrays

		String[][] cars = 	{
								{"Camaro","Corvette","Silverado"},
								{"Mustang","Ranger","F-150"},
							};

		/*
		cars[0][0] = "Camaro";
		cars[0][1] = "Corvette";
		cars[0][2] = "Silverado";
		cars[1][0] = "Mustang";
		cars[1][1] = "Ranger";
		cars[1][2] = "F-150";
		cars[2][0] = "Ferrari";
		cars[2][1] = "Lambo";
		cars[2][2] = "Tesla";
		*/

System.out.println(cars[0][1]);

		for (String[] car : cars) {
			System.out.println();
			for(int j=0; j<car.length; j++) {
				System.out.print(car[j]+" ");
			}
		}
	}
}