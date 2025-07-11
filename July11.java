public class July11 {
    public static int countConsec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;

        int[] zeroEnd = new int[n + 1];
        int[] oneEnd = new int[n + 1];

        zeroEnd[1] = 1;
        oneEnd[1] = 1;

        for (int i = 2; i <= n; i++) {
            zeroEnd[i] = zeroEnd[i - 1] + oneEnd[i - 1];
            oneEnd[i] = zeroEnd[i - 1];
        }

        int total = 1 << n;
        int noConsec = zeroEnd[n] + oneEnd[n];

        return total - noConsec;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;

        System.out.println("Input: " + n1 + " → Output: " + countConsec(n1));
        System.out.println("Input: " + n2 + " → Output: " + countConsec(n2));
    }
}
