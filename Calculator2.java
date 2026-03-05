import java.util.Scanner;

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
        scanner.close();
    }
}
