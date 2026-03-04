import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ASCII drawing app!");

        System.out.println("Give width: ");
        int width = Integer.parseInt(scanner.nextLine());

        System.out.println("Give height: ");
        int height = Integer.parseInt(scanner.nextLine());
        scanner.close();

        System.out.println("Give character: ");
        char ch = scanner.nextLine().charAt(0);

        drawShape(width, height);

    }
    public static void drawShape(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    } 
}
