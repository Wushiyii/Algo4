package leet.stack;

import java.util.Stack;

/**
 * @author wgq
 * @date 2020/7/16 4:02 下午
 */
public class p150_evaluate_reverse_polish_notation {

    public int evalRPN(String[] tokens) {

        if (null == tokens || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> digitStack = new Stack<>();

        for (String token : tokens) {
            if (isSymbol(token)) {
                Integer right = digitStack.pop();
                Integer left = digitStack.pop();
                Integer res;
                if ("+".equals(token)) {
                    res = left + right;
                } else if ("-".equals(token)) {
                    res = left - right;
                } else if ("*".equals(token)) {
                    res = left * right;
                } else if ("/".equals(token)) {
                    res = left / right;
                } else {
                    throw new UnsupportedOperationException();
                }
                digitStack.push(res);
            } else {
                digitStack.push(Integer.valueOf(token));
            }
        }
        return digitStack.pop();

    }

    private boolean isSymbol(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }


    public static void main(String[] args) {
        p150_evaluate_reverse_polish_notation solution = new p150_evaluate_reverse_polish_notation();

        System.out.println(solution.evalRPN(new String[]{"3","11","5","+","-"}));
//        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
//        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
