import java.util.*;

public class Calculator {
    static int prec(char c) { return c == '+' || c == '-' ? 1 : 2; }

    static String toPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while (st.peek() != '(') sb.append(st.pop());
                st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != '(' && prec(st.peek()) >= prec(c)) sb.append(st.pop());
                st.push(c);
            }
        }
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.toString();
    }

    static int evaluate(String p) {
        Deque<Integer> st = new ArrayDeque<>();
        for (char c : p.toCharArray()) {
            if (Character.isDigit(c)) st.push(c - '0');
            else {
                int b = st.pop(), a = st.pop();
                st.push(c == '+' ? a + b : c == '-' ? a - b : c == '*' ? a * b : a / b);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String p = toPostfix(line);
            try {
                System.out.println(p + " = " + evaluate(p));
            } catch (ArithmeticException e) {
                System.out.println(p + " = division by zero");
            }
        }
    }
}