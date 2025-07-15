import java.util.Scanner;

public class July15 {

    // Function to check divisibility by 13
    public static boolean divby13(String s) {
        int remainder = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number as a string: ");
        String input = sc.nextLine();

        if (divby13(input)) {
            System.out.println("True (Divisible by 13)");
        } else {
            System.out.println("False (Not divisible by 13)");
        }

        sc.close();
    }
}
