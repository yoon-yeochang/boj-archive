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

        int[] visit = new int[200000];
        for (int i = 0; i < 200000; i++) {
            visit[i] = -1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visit[n] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            int[] next = {x - 1, x + 1, 2 * x};
            for (int i = 0; i < 3; i++) {

                if (next[i] < 0 || next[i] >= 200000) {
                    continue;
                }

                if (visit[next[i]] >= 0) {
                    if (i == 2) {
                        if (visit[x] >= visit[next[i]]) {
                            continue;
                        }
                    } else {
                        if (visit[x] + 1 >= visit[next[i]]) {
                            continue;
                        }
                    }
                }

                if (i == 2) {
                    visit[next[i]] = visit[x];
                    queue.offer(next[i]);
                } else {
                    visit[next[i]] = visit[x] + 1;
                    queue.offer(next[i]);
                }
            }
        }

        System.out.println(visit[k]);
    }
}