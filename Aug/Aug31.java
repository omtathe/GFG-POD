import java.util.*;

public class Aug31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.maxWater(arr);
        System.out.println("Maximum water that can be contained: " + result);

        sc.close();
    }
}

class Solution {
    public int maxWater(int arr[]) {
        int left = 0, right = arr.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;

            // Update max area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to smaller height
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
