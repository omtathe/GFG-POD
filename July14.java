import java.util.*;

public class July14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input binary string
        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        // Solve and print result
        int result = cuts(s);
        System.out.println("Minimum cuts: " + result);

        sc.close();
    }

    public static int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String sub = s.substring(j, i);
                if (isPowerOf5(sub)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private static boolean isPowerOf5(String s) {
        if (s.charAt(0) == '0') return false;

        long num = Long.parseLong(s, 2);
        if (num == 0) return false;

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
