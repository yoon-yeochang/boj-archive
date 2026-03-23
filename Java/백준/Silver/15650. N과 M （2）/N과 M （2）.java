import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean isUsed[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n+1];

        func(1, 0);

        System.out.println(sb);

    }

    private static void func(int cur, int count) {

        if (count == m) {
            for (int i = 1; i <= n; i++) {
                if (isUsed[i])
                    sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        if (cur > n) {
            return;
        }

        isUsed[cur] = true;
        func(cur + 1, count + 1);

        isUsed[cur] = false;
        func(cur + 1, count);
    }
}
