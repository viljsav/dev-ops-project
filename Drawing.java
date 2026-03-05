import java.util.Scanner;
/**
 * @author Viljo Savolainen
 * Simple app to draw a custom rectangle of user's chosen character.
 */
public class Drawing {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        howIsYourDay();
        

        System.out.println("Welcome to ASCII drawing app!");

        System.out.println("Give width: ");
        int width = Integer.parseInt(scanner.nextLine());
        validateInteger(width);

        System.out.println("Give height: ");
        int height = Integer.parseInt(scanner.nextLine());
        validateInteger(height);

        System.out.println("Give character: ");
        char ch = scanner.nextLine().charAt(0);

        scanner.close();
        drawShape(width, height, ch);

        draw5times(width, height, ch);
    }
    public static void howIsYourDay() {
        System.out.println("How is your day going?");
        String mood = scanner.nextLine();
        System.out.println("Nice to hear that your day is going: " + mood);

    }
    /**
     * Method that draws a shape.
     * @param width
     * @param height
     * @param ch
     */
    public static void drawShape(int width, int height, char ch) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
    /**
     * Method to validate width and height.
     * @param i
     */
    public static void validateInteger(int i) {
        if (i < 0) {
            System.err.println("Give valid width/height");
        }
    }
    /**
     * Method that calls drawing method 5 times.
     * @param width
     * @param height
     * @param ch
     */
    public static void draw5times(int width, int height, char ch) {
        for (int i = 0; i < 5; i++) {
            drawShape(width, height, ch);
            System.out.println();
        }
    }
}
