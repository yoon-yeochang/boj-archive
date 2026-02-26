import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int n = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    n++;
                }
            }
            if (n == 0) {
                sb.append("E").append("\n");
            } else if (n == 1) {
                sb.append("A").append("\n");
            } else if (n == 2) {
                sb.append("B").append("\n");
            } else if (n == 3) {
                sb.append("C").append("\n");
            } else if (n == 4) {
                sb.append("D").append("\n");
            }
        }

        System.out.println(sb);
    }
}