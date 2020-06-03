package chapter1;

import java.util.Stack;

/**
 * 通过Dijkstra的双栈算法解析计算表达式的值
 * @author wgq
 * @date 2020/6/2 6:24 下午
 */
public class Evaluate {

    public static Double evaluate(String[] input) {

        Stack<Double> vals = new Stack<>();
        Stack<String> ops = new Stack<>();

        // ex:  (1 + (2 * 3))
        for (String s : input) {
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                Double val = vals.pop();
                String op = ops.pop();
                if (op.equals("+")) val  = vals.pop() + val;
                if (op.equals("-")) val  = vals.pop() - val;
                if (op.equals("*")) val  = vals.pop() * val;
                if (op.equals("/")) val  = vals.pop() / val;
                if (op.equals("sqrt")) val  = Math.sqrt(val);
                vals.push(val);
            }
            else vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        String[] evalStr = new String[]{"(", "1","+", "(", "2", "*", "3", ")", ")" };
        System.out.println(evaluate(evalStr));
    }

}
