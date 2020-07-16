package leet.stack;

import java.util.Stack;

/**
 * p20 - 有效的括号
 * 注意：单个的 "["， 剩余单个的 "([]"， 右边的 "]]"
 * @author wgq
 * @date 2020/7/15 7:53 下午
 */
public class p20_valid_parentheses {

    public boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isLeft(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (isRightValid(aChar, stack.peek())) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char aChar) {
        return aChar == '(' || aChar == '{' || aChar == '[';
    }

    private boolean isRightValid(char aChar, char left) {
        if (aChar == ')' && left == '(') {
            return true;
        }
        if (aChar == '}' && left == '{') {
            return true;
        }
        if (aChar == ']' && left == '[') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        p20_valid_parentheses solution = new p20_valid_parentheses();
        System.out.println(solution.isValid("]]"));
    }

}
