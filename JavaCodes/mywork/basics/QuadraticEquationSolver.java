package basics;
public class QuadraticEquationSolver {

    public static void main(String[] args) {

        // Coefficients of the quadratic equation
        double a = 2.3, b = 4, c = 5.6;
        double root1, root2;

        // Calculate the determinant
        double determinant = b * b - 4 * a * c;

        // Check different cases based on the determinant
        if (determinant > 0) {

            // Calculate real roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            System.out.format("Real roots: root1 = %.2f, root2 = %.2f%n", root1, root2);
        } else if (determinant == 0) {

            // Calculate equal real roots
            root1 = root2 = -b / (2 * a);
            System.out.format("Equal real roots: root1 = root2 = %.2f;%n", root1);
        } else {

            // Calculate complex roots
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);
            System.out.format("Complex roots: root1 = %.2f+%.2fi%n", real, imaginary);
            System.out.format("              root2 = %.2f-%.2fi%n", real, imaginary);
        }
    }
}
