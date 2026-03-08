import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while (true) {
            String str = br.readLine();
            char[] c = str.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;

            if (c[0] == '.') {
                break;
            }

            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(' || c[i] == '[') {
                    stack.push(c[i]);
                }
                if (c[i] == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    } else if (stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                }
                if (c[i] == ']') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else if (stack.peek() == '[') {
                        stack.pop();
                    } else if (stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
