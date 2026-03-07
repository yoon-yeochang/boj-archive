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

            st = new StringTokenizer(br.readLine(), "[,]");

            Deque<Integer> deque = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char cmd : parr) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
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

        }

        System.out.println(sb);
    }
}