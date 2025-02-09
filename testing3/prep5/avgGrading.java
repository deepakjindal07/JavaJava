package prep5;

public class avgGrading {

    public static void main(String[] args) {
        int math = 1;
        int physics = 1;
        int chem = 2;
        int average = (math + physics + chem / 3);

        if (average <= 35) {
            System.out.println("Fail");
        } else if (average >= 35 && average <= 90) {
            System.out.println("Eligible");
        } else {
            System.out.println("IAS ban gaya");
        }
    }
}