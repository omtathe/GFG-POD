import java.util.*;

public class July10 {
    static class Node {
        Node[] child = new Node[26];
        boolean end = false;
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.child[i] == null) curr.child[i] = new Node();
            curr = curr.child[i];
        }
        curr.end = true;
    }

    static boolean allPrefix(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.child[c - 'a'];
            if (curr == null || !curr.end) return false;
        }
        return true;
    }

    public static String longestString(String[] words) {
        for (String w : words) insert(w);
        Arrays.sort(words);
        String res = "";
        for (String w : words) {
            if (allPrefix(w) && w.length() > res.length()) res = w;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println(longestString(words)); // Output: pros
    }
}
