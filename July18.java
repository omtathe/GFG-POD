public class July18 {

    // Function to calculate GCD
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to calculate LCM
    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    // Main logic for LCM Triplet
    static int lcmTriplets(int n) {
        long maxLCM = 0;

        if (n <= 2) return n;

        if (n % 2 != 0) {
            maxLCM = lcm(n, lcm(n - 1, n - 2));
        } else {
            maxLCM = Math.max(maxLCM, lcm(n, lcm(n - 1, n - 3)));
            maxLCM = Math.max(maxLCM, lcm(n - 1, lcm(n - 2, n - 3)));
        }

        return (int) maxLCM;
    }

    // Main method for testing
    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 7;

        System.out.println("Max LCM for n = " + n1 + " is: " + lcmTriplets(n1)); // Output: 504
        System.out.println("Max LCM for n = " + n2 + " is: " + lcmTriplets(n2)); // Output: 210
    }
}
