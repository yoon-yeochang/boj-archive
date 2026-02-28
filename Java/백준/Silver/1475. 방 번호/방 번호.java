import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }

        int max1 = 0;

        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            if (max1 < arr[i]) {
                max1 = arr[i];
            }
        }

        int max2 = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;

        System.out.println(Math.max(max1, max2));
    }
}
