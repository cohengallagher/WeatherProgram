import java.util.Scanner;

public class WeatherDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Weather Program Driver!");

        System.out.print("Let's begin, enter your country: ");
        String country = scanner.nextLine();

        System.out.print("Now enter your zip code: ");
        String zipCode = scanner.nextLine();
    }
}
