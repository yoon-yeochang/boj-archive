import java.io.*;
import java.util.*;

public class Main {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(paper, 0, n, 0, n);

        sb.append(minusOne).append("\n");
        sb.append(zero).append("\n");
        sb.append(plusOne).append("\n");

        System.out.println(sb);
    }

    private static void func(int[][] paper, int startRow, int endRow, int startCol, int endCol) {
        int temp = paper[startRow][startCol];
        int size = (endRow - startRow) / 3;

        boolean same = true;
        loop:
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (temp != paper[i][j]) {
                    same = false;
                    break loop;
                }
            }
        }

        if (same) {
            if (temp == -1) {
                minusOne++;
            } else if (temp == 0) {
                zero++;
            } else if (temp == 1) {
                plusOne++;
            }

            return;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(paper, startRow + size * i, startRow + size * (i + 1), startCol + size * j, startCol + size * (j + 1));
                }
            }

            return;
        }
    }
}