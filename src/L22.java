package src;

import java.util.Stack;

public class L22 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.isEmpty() || s.length() %2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') { // 左括号压栈
                stack.push(c);
            } else {    // 右括号弹栈
                if (stack.empty()) {
                    return false;
                }
                char expect = stack.pop();
                if (c == ')' && expect != '(') {    // 匹配
                    return false;
                }
                if (c == ']' && expect != '[') {
                    return false;
                }
                if (c == '}' && expect != '{') {
                    return false;
                }
            }
        }

        // 如果不是空的，说明有没配对成功的左括号
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        L22 l22 = new L22();
        System.out.println("res = " + l22.isValid("{}"));
        System.out.println("res = " + l22.isValid("{}]"));
        System.out.println("res = " + l22.isValid("{}]}"));
        System.out.println("res = " + l22.isValid("{[}]"));
        System.out.println("res = " + l22.isValid("(){}[]"));
        System.out.println("res = " + l22.isValid(""));
    }
}
