package chapter1.homework;

import chapter1.StackWithLink;

public class P1_3_4 {


    public static boolean parentheses(String[] ops) {
        StackWithLink<String> stack = new StackWithLink<>();
        //    [ ( ) ] { } { [ ( ) ( ) ] ( ) }
        for (String op : ops) {
            if (op.equals("(") || op.equals("[") || op.equals("{")) {
                stack.push(op);
            } else if (op.equals(")")) {
                if (!stack.pop().equals("(")) {
                    return false;
                }
            } else if (op.equals("]")) {
                if (!stack.pop().equals("[")) {
                    return false;
                }
            } else if (op.equals("}")) {
                if (!stack.pop().equals("{")) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] ops = new String[] {"[","(",")", "]", "{", "}", "{", "[", "(", ")", "(", ")", "]", "(", ")", "}"};
        String[] ops2 = new String[] {"[","(","]",")"};
        System.out.println(parentheses(ops2));
    }

}
