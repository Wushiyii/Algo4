package chapter1.homework;

import chapter1.StackWithLink;

/**
 * 算术中序表达式转后序表达式
 * @author wgq
 * @date 2020/6/4 2:13 下午
 */
public class P1_3_10 {

    // ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )  =>   2 3 4 + 5 6 * * +
    public static void infixToPostFix(String[] inputs) {

        StackWithLink<String> stack = new StackWithLink<>();

        for (String input : inputs) {
            if (input.equals("("));
            else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                stack.push(input);
            }
            else if (input.equals(")")) {
                System.out.print(stack.pop());
            }
            else {
                System.out.print(input);
            }
        }
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{"(", "2" ,"+" ,"(", "(", "3", "+", "4", ")", "*", "(", "5", "*", "6", ")", ")", ")"};
        infixToPostFix(inputs);
    }

}
