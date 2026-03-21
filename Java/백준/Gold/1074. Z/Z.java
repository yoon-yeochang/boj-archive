import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        func(n, r, c);

        System.out.println(count);
    }

    private static void func(int n, int r, int c) {
        if (n == 0) {
            return;
        }

        int num = 1 << (n-1);
        if (r >= num) {
            r = r - num;
            count += num * num * 2;
        }
        if (c >= num) {
            c = c - num;
            count += num * num;
        }

        func(n-1, r, c);
    }
}