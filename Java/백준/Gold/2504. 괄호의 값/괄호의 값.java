import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int n = str.length();

        Deque<Character> stack = new ArrayDeque<>();
        boolean flag = true;

        int result = 0;
        int tmp = 1;

        for (int i = 0; i < n; i++) {
            //괄호 짝 안맞아서 오류.
            if (n % 2 == 1) {
                flag = false;
                break;
            }

            char c = str.charAt(i);
            //() [] 쌍 안맞아서 오류
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
            }
            if (i == n - 1 && (c == '(' || c == '[')) {
                flag = false;
                break;
            }

            // 오류나는거 처리 이후 실제 계산.
            if (c == '(') {
                tmp *= 2;
                stack.push('(');
            } else if (c == '[') {
                tmp *= 3;
                stack.push('[');
            } else if (c == ')') {
                if (str.charAt(i - 1) == '(') {
                    result += tmp;
                }
                tmp /= 2;
                stack.pop();
            } else if (c == ']') {
                if (str.charAt(i - 1) == '[') {
                    result += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
        }

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}