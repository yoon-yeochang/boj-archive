import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] num1 = new int[7];
        int[] num2 = new int[7];
        int count = 0;

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            num1[i] = Integer.parseInt(st.nextToken());
            if (num1[i] % 2 == 1) {
                num2[count] = num1[i];
                count++;
            }
        }
        Arrays.sort(num2);

        if (count > 0) {
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += num2[i];
            }

            sb.append(sum).append("\n");

            for (int i = 0; i < 7; i++) {
                if (num2[i] != 0) {
                    sb.append(num2[i]);
                    break;
                }
            }
        } else {
            sb.append(-1);
        }


        System.out.println(sb);
    }
}
