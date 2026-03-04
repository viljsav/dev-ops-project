import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ASCII drawing app!");

        System.out.println("Give width: ");
        int width = Integer.parseInt(scanner.nextLine());
        scanner.close();
    }    
}
