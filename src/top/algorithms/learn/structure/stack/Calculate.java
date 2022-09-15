package top.algorithms.learn.structure.stack;

import java.util.Queue;
import java.util.Stack;

/**
 * @author jrl
 * @date Create in 16:47 2022/8/8
 */
public class Calculate {
    public static void main(String[] args) {
        int i = new Calculate().calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println(i);
    }

    public int calculate(String s) {

        //  要知道一个表达式 a x b 应该如果操作，那么有两种方式，
        // 1. * 或者 / 就可以直接计算这个表示
        // 2. + 或者 - 需要看【下一个运算符】是什么 ---> 我采用了这种方式，因为这样的话，我可以遍历一遍得出结果

        // 1 * 2 + 34 + 3 - 5 / 2 - 4
        // 每次拿到运算符，判断该运算符与前一个运算符谁的优先级更高，然后计算一个表达式（pre >= now ---> pre , or now）
        int n = s.length();
        int i = 0;
        char pre = ' ';
        char now = ' ';
        Stack<Integer> numbers = new Stack();
        while (i < n && s.charAt(i++) != ' ') {
            i--;
            int num = 0;
            boolean isNum = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                num += num * 10 + (s.charAt(i++) - '0');
                isNum = true;
            }
            if (isNum) {
                numbers.push(num);
            }
            if (i < n && !Character.isDigit(s.charAt(i))) {
                now = s.charAt(i++);
            }
            if (now != ' ') {
                int num1 = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num1 += num1 * 10 + (s.charAt(i++) - '0');
                }
                int num2 = 0;
                if (pre == '*' || pre == '/') { // pre
                    if (pre == '*') {
                        num2 = numbers.pop() * numbers.pop();
                    } else {
                        int b = numbers.pop();
                        num2 = numbers.pop() / b;
                    }
                    numbers.push(num2);
                    pre = now;
                } else if (now == '*' || now == '/') { // now
                    if (now == '*') {
                        num2 = numbers.pop() * num1;
                    } else {
                        num2 = numbers.pop() / num1;
                    }
                    numbers.push(num2);
                } else {// pre
                    if (pre == '-') {
                        int b = numbers.pop();
                        num2 = numbers.pop() - b;
                        numbers.push(num2);
                    } else if (pre == '+') {
                        num2 = numbers.pop() + numbers.pop();
                        numbers.push(num2);
                    }
                    pre = now;
                }

                now = ' ';
            } else {
                if (pre == '-') {
                    int b = numbers.pop();
                    return numbers.pop() - b;
                } else {
                    return numbers.pop() + numbers.pop();
                }

            }
        }
        if (pre == '-') {
            int b = numbers.pop();
            return numbers.pop() - b;
        } else {
            return numbers.pop() + numbers.pop();
        }

    }

}
