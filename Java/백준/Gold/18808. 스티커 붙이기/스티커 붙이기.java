import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] noteBook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        noteBook = new int[n][m];

        for (int a = 0; a < k; a++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[row][col];

            for (int b = 0; b < row; b++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < col; c++) {
                    sticker[b][c] = Integer.parseInt(st.nextToken());
                }
            }

            func(sticker, row, col);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (noteBook[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void func(int[][] sticker, int row, int col) {
        //0도
        if (fit(sticker, row, col)) {
            return;
        }

        //90도
        int[][] sticker90 = turn90(sticker, row, col);
        if (fit(sticker90, col, row)) {
            return;
        }

        //180도
        int[][] sticker180 = turn90(sticker90, col, row);
        if (fit(sticker180, row, col)) {
            return;
        }

        //270도
        int[][] sticker270 = turn90(sticker180, row, col);
        if (fit(sticker270, col, row)) {
            return;
        }

        return;
    }

    private static int[][] turn90(int[][] sticker, int row, int col) {
        int[][] arr90 = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                arr90[i][j] = sticker[row - j - 1][i];
            }
        }

        return arr90;
    }

    private static boolean fit(int[][] sticker, int row, int col) {
        loop1:
        for (int a = 0; a <= n - row; a++) {
            for (int b = 0; b <= m - col; b++) {
                boolean fit = true;
                loop2:
                for (int c = 0; c < row; c++) {
                    for (int d = 0; d < col; d++) {
                        if (sticker[c][d] == 1) {
                            if (noteBook[a + c][b + d] == 1) {
                                fit = false;
                                break loop2;
                            }
                        }
                    }
                }
                if (fit) {
                    for (int c = 0; c < row; c++) {
                        for (int d = 0; d < col; d++) {
                            if (sticker[c][d] == 1) {
                                noteBook[a+c][b+d] = sticker[c][d];
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
