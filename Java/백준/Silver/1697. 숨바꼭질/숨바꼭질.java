import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        int[] line = new int[200000];
        int[] visit = new int[200000];

        Deque<Integer> queue = new ArrayDeque<>();
        line[k] = 1;
        visit[n] = 1;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                } else {
                    next = cur * 2;
                }

                if (next < 0 || next >= 200000) {
                    continue;
                }

                if (visit[next] > 0) {
                    continue;
                }

                if (line[next] == 1) {
                    System.out.println(visit[cur]);
                    return;
                }

                visit[next] = visit[cur] + 1;
                queue.offer(next);
            }
        }
    }
}