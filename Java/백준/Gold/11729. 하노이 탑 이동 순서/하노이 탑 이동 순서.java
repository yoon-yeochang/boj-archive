import java.io.*;
import java.util.*;



public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        func(n, 1, 3, sb);

        System.out.println(count);
        System.out.println(sb);

    }

    private static void func(int n, int a, int b, StringBuilder sb) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            count++;
        } else {
            if (a == 1 && b == 2) {
                func(n-1, 1, 3, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 3, 2, sb);
            }
            if (a == 1 && b == 3) {
                func(n-1, 1, 2, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 2, 3, sb);
            }
            if (a == 2 && b == 1) {
                func(n-1, 2, 3, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 3, 1, sb);
            }
            if (a == 2 && b == 3) {
                func(n-1, 2, 1, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 1, 3, sb);
            }
            if (a == 3 && b == 1) {
                func(n-1, 3, 2, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 2, 1, sb);
            }
            if (a == 3 && b == 2) {
                func(n-1, 3, 1, sb);
                sb.append(a).append(" ").append(b).append("\n");
                count++;
                func(n-1, 1, 2, sb);
            }
        }
    }
}