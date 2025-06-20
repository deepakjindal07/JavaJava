package random_6;
public class ObjectPassing {

	public static void main(String[] args) {

		Garage garage = new Garage();

		Car car1 = new Car("BMW");
		Car car2 = new Car("Tesla");

		garage.park(car1);
		garage.park(car2);

	}

	static class Garage {

		void park(Car car) {
			System.out.println("The " + car.name + " is parked in the garage");
		}
	}

	static class Car {

		String name;

		Car(String name) {
			this.name = name;
		}
	}
}
