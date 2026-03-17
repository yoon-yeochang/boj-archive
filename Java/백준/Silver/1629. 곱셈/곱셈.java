import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long n = func(a, b, c);
        System.out.println(n);
    }

    private static long func(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long x = func(a, b / 2, c);
        x = x * x % c;
        if (b % 2 == 0) {
            return x;
        }
        return x * a % c;
    }
}