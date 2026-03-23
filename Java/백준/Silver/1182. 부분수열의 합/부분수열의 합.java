import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int s;
    static int[] arr;
    static boolean[] isUsed;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        isUsed = new boolean[n];

        func(0, 0);

        System.out.println(count);
    }

    private static void func(int sum, int index) {
        if (index == n) {
            return;
        }

        func(sum, index + 1);

        isUsed[index] = true;
        sum += arr[index];

        if (sum == s && isUsed[index]) {
            count++;
        }
        
        func(sum, index + 1);
    }
}