import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int[] boy = new int[6];
        int[] girl = new int[6];
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                boy[arr[i][1] - 1]++;
            } else {
                girl[arr[i][1] - 1]++;
            }
        }

        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += (boy[i] + k - 1) / k + (girl[i] + k - 1) / k;
        }

        System.out.println(count);
    }
}
