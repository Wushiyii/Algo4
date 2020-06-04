package chapter1.homework;

import chapter1.StackWithLink;

/**
 * 缺少左括号的表达式并打印出补全括号之后的中序表达式
 * @author wgq
 * @date 2020/6/4 10:32 上午
 */
public class P1_3_9 {
    // 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )  =>  C (( 1+ 2 ) * (( 3 - 4 ) * ( 5 - 6 )))

    public static String paddingQuote(String [] inputs) {

        StackWithLink<String> opr = new StackWithLink<>();
        StackWithLink<String> data = new StackWithLink<>();
        for (String input : inputs) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                opr.push(input);
            } else if (input.equals(")")) {
                String op = opr.pop();
                String dataA = data.pop();
                String dataB = data.pop();
                data.push("(" + dataB + op + dataA + ")");
            } else {
                data.push(input);
            }
        }
        return data.pop();
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"1", "+", "2" ,")" ,"*", "3", "-", "4", ")", "*", "5", "-", "6", ")", ")", ")"};
        System.out.println(paddingQuote(inputs));
    }

}
