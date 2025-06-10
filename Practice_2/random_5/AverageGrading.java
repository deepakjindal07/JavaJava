package random_5;

public class AverageGrading {

	public static void main(String[] args) {

		int maths = 75;
		int physics = 99;
		int chemistry = 80;
		int average = (maths + physics + chemistry / 3);

		if (average <= 35) {
			System.out.println("Fail");
		} else if (average >= 35 && average <= 60) {
			System.out.println("GradeC");
		} else if (average >= 60 && average <= 70) {
			System.out.println("GradeB");
		} else {
			System.out.println("GradeA");
		}
	}
}
