import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] num = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        int a = sum - 100;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (num[i] + num[j] == a) {
                    num[i] = 0;
                    num[j] = 0;
                    break;
                }
            }
            if (num[i] == 0) {
                break;
            }
        }

        Arrays.sort(num);

        for (int i = 0; i < 9; i++) {
            if (num[i] != 0) {
                sb.append(num[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
