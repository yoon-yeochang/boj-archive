import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] arr1 = st.nextToken().toCharArray();
            char[] arr2 = st.nextToken().toCharArray();

            if (arr1.length == arr2.length) {
                int[] count1 = new int[26];
                int[] count2 = new int[26];
                for (int j = 0; j < arr1.length; j++) {
                    count1[arr1[j] - 'a']++;
                    count2[arr2[j] - 'a']++;
                }
                if (Arrays.equals(count1, count2)) {
                    sb.append("Possible").append("\n");
                } else {
                    sb.append("Impossible").append("\n");
                }
            } else {
                sb.append("Impossible").append("\n");
            }
        }

        System.out.println(sb);
    }
}