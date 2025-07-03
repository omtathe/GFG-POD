import java.util.*;

public class July3 {

    public static int longestKSubstr(String s, int k) {
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = -1;

        while (j < n) {
            char cj = s.charAt(j);
            freqMap.put(cj, freqMap.getOrDefault(cj, 0) + 1);

            while (freqMap.size() > k) {
                char ci = s.charAt(i);
                freqMap.put(ci, freqMap.get(ci) - 1);
                if (freqMap.get(ci) == 0) {
                    freqMap.remove(ci);
                }
                i++;
            }

            if (freqMap.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // Input value of k
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Compute result
        int result = longestKSubstr(s, k);
        System.out.println("Length of longest substring with " + k + " unique characters: " + result);

        sc.close();
    }
}
