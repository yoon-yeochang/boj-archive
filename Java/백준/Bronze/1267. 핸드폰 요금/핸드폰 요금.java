
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum1 = 0;
        int sum2 = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(st.nextToken());
            sum1 += 10 + (time / 30) * 10;
            sum2 += 15 + (time / 60) * 15;
        }

        if (sum1 < sum2) {
            sb.append("Y").append(" ").append(sum1);
        } else if (sum1 > sum2) {
            sb.append("M").append(" ").append(sum2);
        } else {
            sb.append("Y M").append(" ").append(sum1);
        }

        System.out.println(sb);

    }
}
