import java.util.*;

public class Sep011 {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        
        // If first element is 0, we cannot move anywhere
        if (arr[0] == 0) return -1;

        int jumps = 0;
        int maxReach = arr[0];
        int steps = arr[0];

        for (int i = 1; i < n; i++) {
            // If we reached the end of the array
            if (i == n - 1) {
                jumps++;
                return jumps;
            }

            // Update maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step to move forward
            steps--;

            // If no steps left
            if (steps == 0) {
                jumps++;

                // If current position is beyond maxReach, return -1
                if (i >= maxReach) {
                    return -1;
                }

                // Re-initialize steps
                steps = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = minJumps(arr);
        System.out.println("Minimum Jumps Required: " + result);
        
        sc.close();
    }
}
