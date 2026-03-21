import java.io.*;
import java.util.*;

public class Main {

    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        star = new char[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                star[i][j] = ' ';
            }
        }

        func(n, 0, n-1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void func(int n, int row, int col) {
        if (n == 3) {
            star[row][col] = '*';
            star[row+1][col-1] = '*';
            star[row+1][col+1] = '*';
            star[row+2][col-2] = '*';
            star[row+2][col-1] = '*';
            star[row+2][col] = '*';
            star[row+2][col+1] = '*';
            star[row+2][col+2] = '*';

            return;
        }

        func(n / 2, row, col);
        func(n / 2, row + n / 2, col - n / 2);
        func(n / 2, row + n / 2, col  + n / 2);
    }
}