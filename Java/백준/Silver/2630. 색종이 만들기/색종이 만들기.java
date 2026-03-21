
import java.io.*;
import java.util.*;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] paper;
    static int[] color = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, n);

        System.out.println(color[0]);
        System.out.println(color[1]);

    }

    private static void func(int row, int col, int size) {
        int temp = paper[row][col];
        boolean same = true;

        loop:
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (temp != paper[i][j]) {
                    same = false;
                    break loop;
                }
            }
        }

        if (same) {
            color[temp]++;
            return;
        } else {
            int newSize = size/2;
            func(row, col, newSize);
            func(row, col+newSize, newSize);
            func(row+newSize, col, newSize);
            func(row+newSize, col+newSize, newSize);

            return;
        }
    }
}
