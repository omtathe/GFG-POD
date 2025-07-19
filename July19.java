import java.util.*;

public class July19 {

    public static int vowelCount(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> vowelFreq = new HashMap<>();

        // Count frequency of each vowel
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                vowelFreq.put(ch, vowelFreq.getOrDefault(ch, 0) + 1);
            }
        }

        // If no vowels found
        if (vowelFreq.isEmpty()) return 0;

        int waysToSelect = 1;
        int uniqueVowels = vowelFreq.size();

        // Multiply the number of choices for each vowel
        for (int count : vowelFreq.values()) {
            waysToSelect *= count;
        }

        // Multiply by number of permutations (factorial of unique vowels)
        int permutations = factorial(uniqueVowels);

        return waysToSelect * permutations;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lowercase string: ");
        String input = sc.nextLine();

        int result = vowelCount(input);
        System.out.println("Total distinct vowel strings: " + result);
        sc.close();
    }
}
