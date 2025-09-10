public class Sep010 {

    public String largestSwap(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Track the last occurrence of the max digit from right to left
        int maxIdx = n - 1;
        int[] maxRight = new int[n];
        maxRight[n - 1] = maxIdx;

        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            }
            maxRight[i] = maxIdx;
        }

        for (int i = 0; i < n; i++) {
            if (chars[i] < chars[maxRight[i]]) {
                // Perform the swap
                char temp = chars[i];
                chars[i] = chars[maxRight[i]];
                chars[maxRight[i]] = temp;
                return new String(chars);
            }
        }

        // No swap needed, return original string
        return s;
    }

    public static void main(String[] args) {
        Sep010 solution = new Sep010();

        String s1 = "768";
        String s2 = "333";
        String s3 = "2736";

        System.out.println(solution.largestSwap(s1)); // Output: "867"
        System.out.println(solution.largestSwap(s2)); // Output: "333"
        System.out.println(solution.largestSwap(s3)); // Output: "7236"
    }
}
