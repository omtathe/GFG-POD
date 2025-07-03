import java.util.HashMap;

public class July1 {
    public int substrCount(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        int n = s.length();

        while (j < n) {
            char endChar = s.charAt(j);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            while (map.size() > k - 1 || (j - i + 1) > k) {
                char startChar = s.charAt(i);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                i++;
            }

            if (map.size() == k - 1 && (j - i + 1) == k) {
                ans++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        July1 sol = new July1();
        String s = "abcc";
        int k = 2;
        int result = sol.substrCount(s, k);
        System.out.println("Count of valid substrings: " + result);
    }
}
