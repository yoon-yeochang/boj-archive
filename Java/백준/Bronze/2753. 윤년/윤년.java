import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }
}
