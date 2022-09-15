package top.algorithms.learn.structure.stack;

import java.util.Stack;

/**
 * @author jrl
 * @date Create in 16:49 2022/9/12
 */
public class SortedStack {

    Stack<Integer> stack = new Stack();
    Stack<Integer> tmp = new Stack();

    public SortedStack() {

    }

    // 在 push 的时候进行排序
    public void push(int val) {
        if (!stack.isEmpty()) {
            int a = stack.pop();
            while (a < val) {
                tmp.push(a);
                if (!stack.isEmpty()) {
                    a = stack.pop();
                } else {
                    break;
                }
            }
            if (a >= val) {
                stack.push(a);
            }
            stack.push(val);
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
        } else {
            stack.push(val);
        }

    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        if (!stack.isEmpty()) return stack.peek();
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
