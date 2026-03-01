import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        int p = 0;
        int q = n - 1;
        while (p < q) {
            if (arr[p] + arr[q] > x) {
                q--;
            } else if (arr[p] + arr[q] < x) {
                p++;
            } else {
                count++;
                p++;
                q--;
            }
        }

        System.out.println(count);
    }
}