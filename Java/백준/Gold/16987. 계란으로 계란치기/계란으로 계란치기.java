import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] hp;
    static int[] weight;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        hp = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hp[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        func(0);

        System.out.println(max);
    }

    private static void func(int cur) {
        if (cur == n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (hp[i] <= 0) {
                    count++;
                }
            }
            max = Math.max(count, max);
            return;
        }

        if (hp[cur] <= 0) {
            func(cur + 1);
            return;
        }

        boolean isHit = false;

        for (int i = 0; i < n; i++) {
            if (i == cur) {
                continue;
            }
            if (hp[i] <= 0) {
                continue;
            }
            isHit = true;

            hp[cur] -= weight[i];
            hp[i] -= weight[cur];

            func(cur + 1);

            hp[cur] += weight[i];
            hp[i] += weight[cur];
        }

        if (!isHit) {
            func(cur + 1);
        }
    }
}