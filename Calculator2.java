import java.util.Scanner;
/**
 * Class that works as a calculator.
 */
public class Calculator2 {
    public static double sum(double m, double n) {
        return m + n;
    }
    public static double times(double m, double n) {
        return m * n;
    }
    public static double divide(double m, double n) {
        if (n == 0) {
            throw new Error();
        }
        return m / n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How is your day?");

        String mood = scanner.nextLine();
        
        System.out.println("Number 1: ");
        double m = Integer.parseInt(scanner.nextLine());

        System.out.println("Number 2:");
        double n = Integer.parseInt(scanner.nextLine());

        double sum = sum(m, n);
        double times = times(m, n);
        double division = divide(m, n);

        scanner.close();
    }
}
