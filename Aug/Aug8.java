// Aug8.java
import java.util.*;

public class Aug8 {
    static int getLPSLength(String s) {
        int n = s.length(), lps[] = new int[n], len = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) lps[i++] = ++len;
            else if (len != 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        return lps[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(getLPSLength(new Scanner(System.in).nextLine()));
    }
}
