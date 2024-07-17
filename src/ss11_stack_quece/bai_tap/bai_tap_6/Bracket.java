package ss11_stack_quece.bai_tap.bai_tap_6;


import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Stack<String> bracketStack = new Stack<>();
        String expression = "s * (s – a) * (s – b) * (s – c)";
        System.out.println(checkBracket(expression, bracketStack));
    }

    private static boolean checkBracket(String expression, Stack<String> bracketStack) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                bracketStack.push("(");
            } else if (ch == ')') {
                if (bracketStack.isEmpty()) {
                    return false;
                } else {
                    String leftBracket = bracketStack.pop();
                    if (!leftBracket.equals("(")) {
                        return false;
                    }
                }
            }
        }
        return bracketStack.isEmpty();
    }
}