// Aug023.java
class Aug023 {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // Edge case: More students than books
        if (k > n) return -1;
        
        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);  // max element
            high += pages;               // sum of all
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, n, k, mid)) {
                result = mid;
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1; // increase limit
            }
        }
        return result;
    }
    
    // Helper: check if allocation possible with given maxPages
    private boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int students = 1;
        int sum = 0;
        
        for (int pages : arr) {
            if (sum + pages > maxPages) {
                students++;
                sum = pages;
                if (students > k) return false;
            } else {
                sum += pages;
            }
        }
        return true;
    }

    // main method to test
    public static void main(String[] args) {
        Aug023 obj = new Aug023();
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;
        System.out.println(obj.findPages(arr1, k1)); // Output: 113
        
        int[] arr2 = {15, 17, 20};
        int k2 = 5;
        System.out.println(obj.findPages(arr2, k2)); // Output: -1
    }
}
