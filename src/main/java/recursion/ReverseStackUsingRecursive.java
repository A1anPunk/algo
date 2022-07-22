package recursion;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    // 将一个栈翻转 并且不使用额外的数据结构

    // 思路使用了两个递归 通过系统程序栈实现栈翻转


    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }

        int bottom = getStackBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }


    public static int getStackBottom(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return stack.pop();
        }
        Integer pop = stack.pop();
        int result = getStackBottom(stack);
        stack.push(pop);
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
