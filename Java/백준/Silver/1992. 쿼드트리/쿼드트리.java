import java.io.*;
import java.util.*;

public class Main {

    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = str.charAt(j) - '0';
            }
        }

        func(0, 0, n);

        System.out.println(sb);
    }

    private static void func(int row, int col, int size) {
        int temp = video[row][col];
        boolean same = true;

        loop:
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (temp != video[i][j]) {
                    same = false;
                    break loop;
                }
            }
        }

        if (same) {
            sb.append(temp);
            return;
        } else {
            int newSize = size/2;

            sb.append("(");
            func(row, col, newSize);
            func(row, col+newSize, newSize);
            func(row+newSize, col, newSize);
            func(row+newSize, col+newSize, newSize);
            sb.append(")");
        }
    }
}