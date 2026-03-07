import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            char[] parr = p.toCharArray();

            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            String cleaned = input.replace("[", "").replace("]","");
            String[] x = cleaned.split(",");

            int count = 0;
            for (char c : parr) {
                if (c == 'D') {
                    count++;
                }
            }

            if (count > n) {
                sb.append("error").append("\n");
                continue;
            } else if (n == 0) {
                sb.append("[]").append("\n");
                continue;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (String s : x) {
                deque.offerLast(Integer.parseInt(s));
            }

            boolean isReversed = false;
            for (char c : parr) {
                switch (c) {
                    case 'R':
                        isReversed = !isReversed;
                        break;
                    case 'D':
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                        break;
                }
            }

            sb.append("[");
            int a = deque.size();
            if (isReversed) {
                for (int j = 0; j < a; j++) {
                    sb.append(deque.pollLast());
                    if (j != a - 1) {
                        sb.append(",");
                    }
                }
            } else {
                for (int j = 0; j < a; j++) {
                    sb.append(deque.pollFirst());
                    if (j != a - 1) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]").append("\n");
        }

        System.out.println(sb);
    }
}