package com.tang;

/**
 * Created by tanghuailong on 2016/6/2.
 */


import java.util.Scanner;
import java.util.Stack;

/**
 * 前序转后序
 */
public class InfixToPostfix {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String express = scanner.nextLine();
        if (express.isEmpty()) {
            System.out.println("表达式错误...");
        } else {
            System.out.println(toPostfix(express));
        }

    }

    private static String toPostfix(String expression) {
        String[] infixChars = expression.split(" ");
        Stack<String> stack = new Stack();
        String output = "";
        for (String single : infixChars) {
            if (single.equals("(")) {
                stack.push(single);
            } else if (single.equals("+") || single.equals("-") || single.equals("*")
                || single.equals("/") || single.equals("^")) {
                if (priority(stack.peek()) < priority(single)) {
                    stack.push(single);
                } else {
                    String pop = stack.pop();
                    stack.push(single);
                    output += " "+pop;
                }
            } else if (single.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output += " "+stack.pop();
                }
                stack.pop();
            } else {
                output += " "+single;
            }
        }
        return output;
    }

    /**
     * 比较运算符的优先级
     *
     * @param operator
     * @return
     */
    private static int priority(String operator) {
        if (operator.equals("^")) {
            return 3;
        }
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        return 0;
    }
}
