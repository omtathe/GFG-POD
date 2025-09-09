import java.util.Arrays;

public class Sep009 {
    
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int maxTime = 0;
        
        for (int i = 0; i < mices.length; i++) {
            int time = Math.abs(mices[i] - holes[i]);
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }

    public static void main(String[] args) {
        Sep009 solution = new Sep009();
        
        int[] mices1 = {4, -4, 2};
        int[] holes1 = {4, 0, 5};
        System.out.println("Output Example 1: " + solution.assignHole(mices1, holes1)); // Output: 4

        int[] mices2 = {1, 2};
        int[] holes2 = {20, 10};
        System.out.println("Output Example 2: " + solution.assignHole(mices2, holes2)); // Output: 18
    }
}
