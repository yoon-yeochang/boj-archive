import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            sb.append(10000 + a * 1000);
        } else if (a == b || a == c || b == c) {
            if (a == b) {
                sb.append(1000 + a * 100);
            }
            if (a == c) {
                sb.append(1000 + a * 100);
            }
            if (b == c) {
                sb.append(1000 + b * 100);
            }
        } else {
            sb.append(Integer.max(Integer.max(a, b), c) * 100);
        }

        System.out.println(sb);
    }
}
