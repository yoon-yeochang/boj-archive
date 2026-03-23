import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] isUsed;
    static boolean[][] isLine;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        isUsed = new boolean[n][n];
        isLine = new boolean[n][n];

        func(0);

        System.out.println(count);
    }

    private static void func(int k) {
        if (k == n) {
            count++;
            return;
        }

        loop:
        for (int i = 0; i < n; i++) {

            // 직선으로 만나나
            if (isLine[i][k]) {
                continue loop;
            }

            // 대각선으로 만나나
            for (int j = k - 1; j >= 0; j--) {
                int plus = i - (j - k);
                int minus = i + (j - k);

                if (plus < n) {
                    if (isUsed[plus][j]) {
                        continue loop;
                    }
                }
                if (minus >= 0) {
                    if (isUsed[minus][j]) {
                        continue loop;
                    }
                }
            }

            isUsed[i][k] = true;
            for (int j = k; j < n; j++) {
                isLine[i][j] = true;
            }

            func(k+1);

            isUsed[i][k] = false;
            for (int j = k; j < n; j++) {
                isLine[i][j] = false;
            }
        }
    }
}