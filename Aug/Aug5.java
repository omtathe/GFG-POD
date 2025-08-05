public class Aug5 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.isPalinSent("Too hot to hoot"));      // true
        System.out.println(sol.isPalinSent("Abc 012..## 10cbA"));    // true
        System.out.println(sol.isPalinSent("ABC $. def01ASDF"));     // false
    }
}

class Solution {
    public boolean isPalinSent(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
