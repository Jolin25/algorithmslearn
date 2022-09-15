package top.algorithms.learn.code;

import java.util.Stack;

/**
 * @author jrl
 * @date Create in 16:19 2022/5/18
 */
public class StringLearn {
    public static void main(String[] args) {
        String s = "  aaa aa aaaaa     a   ";
        System.out.println(s.trim());
        StringBuffer sb = new StringBuffer("abc def");
        sb.insert(7," "+s.charAt(3));
        System.out.println(sb.length());
        System.out.println(new Integer('a'));
        System.out.println(new Integer('A'));
        Character c = '1';
        boolean matches = c.toString().matches("[a-z A-Z 0-9](2)");
        boolean matches1 = "n2".matches("[a-z A-Z 0-9](2)");
        System.out.println(matches);
        System.out.println(matches1);
        boolean digit = Character.isDigit('1');
        boolean a = Character.isAlphabetic('1');
        System.out.println(digit);
        System.out.println(a);

        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

    }

}
