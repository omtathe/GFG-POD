import java.util.*;

public class Sep019 {
    public static int minParentheses(String s) {
        int balance = 0;
        int insertions = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    insertions++;
                }
            }
        }
        return insertions + balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minParentheses(s));
        sc.close();
    }
}
