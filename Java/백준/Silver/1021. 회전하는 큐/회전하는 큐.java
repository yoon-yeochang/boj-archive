import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            int count1 = 0;
            int count2 = 0;
            while (!deque.isEmpty() && deque.peekFirst() != x) {
                Integer a = deque.pollFirst();
                deque.offerLast(a);
                count1++;
            }
            for (int j = 0; j < count1; j++) {
                Integer a = deque.pollLast();
                deque.offerFirst(a);
            }
            while (!deque.isEmpty() && deque.peekFirst() != x) {
                Integer a = deque.pollLast();
                deque.offerFirst(a);
                count2++;
            }
            deque.pollFirst();
            count += Math.min(count1, count2);
        }

        System.out.println(count);
    }
}