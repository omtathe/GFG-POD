// 17 Sep 2025 - Decode the string 
import java.util.Stack;

class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                String previousString = stringStack.pop();

                StringBuilder temp = new StringBuilder(previousString);
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
            } else {
                currentString += ch;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String s1 = "3[b2[ca]]";
        System.out.println(decodeString(s1)); 

        String s2 = "3[ab]";
        System.out.println(decodeString(s2)); 
    }
}
