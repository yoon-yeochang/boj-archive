import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] board = board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(board, 0);

        System.out.println(max);
    }

    private static void func(int[][] board, int k) {
        if (k == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = board[i].clone();
        }

        up(temp, k);
        down(temp, k);
        left(temp, k);
        right(temp, k);
    }

    private static void up(int[][] arr, int k) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }

        for (int col = 0; col < n; col++) {
            int target = 0;
            for (int row = 1; row < n; row++) {
                if (temp[row][col] == 0) {
                    continue;
                }

                if (temp[target][col] == 0) {
                    temp[target][col] = temp[row][col];
                    temp[row][col] = 0;
                } else if (temp[target][col] == temp[row][col]) {
                    temp[target][col] += temp[row][col];
                    temp[row][col] = 0;
                    target++;
                } else {
                    target++;
                    if (target == row) {
                        continue;
                    }
                    temp[target][col] = temp[row][col];
                    temp[row][col] = 0;
                }
            }
        }

        func(temp, k + 1);
    }

    private static void down(int[][] arr, int k) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }

        for (int col = 0; col < n; col++) {
            int target = n-1;
            for (int row = n-2; row >= 0; row--) {
                if (temp[row][col] == 0) {
                    continue;
                }

                if (temp[target][col] == 0) {
                    temp[target][col] = temp[row][col];
                    temp[row][col] = 0;
                } else if (temp[target][col] == temp[row][col]) {
                    temp[target][col] += temp[row][col];
                    temp[row][col] = 0;
                    target--;
                } else {
                    target--;
                    if (target == row) {
                        continue;
                    }
                    temp[target][col] = temp[row][col];
                    temp[row][col] = 0;
                }
            }
        }

        func(temp, k + 1);
    }

    private static void left(int[][] arr, int k) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }

        for (int row = 0; row < n; row++) {
            int target = 0;
            for (int col = 1; col < n; col++) {
                if (temp[row][col] == 0) {
                    continue;
                }

                if (temp[row][target] == 0) {
                    temp[row][target] = temp[row][col];
                    temp[row][col] = 0;
                } else if (temp[row][target] == temp[row][col]) {
                    temp[row][target] += temp[row][col];
                    temp[row][col] = 0;
                    target++;
                } else {
                    target++;
                    if (target == col) {
                        continue;
                    }
                    temp[row][target] = temp[row][col];
                    temp[row][col] = 0;
                }
            }
        }

        func(temp, k + 1);
    }

    private static void right(int[][] arr, int k) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i].clone();
        }

        for (int row = 0; row < n; row++) {
            int target = n-1;
            for (int col = n-2; col >= 0; col--) {
                if (temp[row][col] == 0) {
                    continue;
                }

                if (temp[row][target] == 0) {
                    temp[row][target] = temp[row][col];
                    temp[row][col] = 0;
                } else if (temp[row][target] == temp[row][col]) {
                    temp[row][target] += temp[row][col];
                    temp[row][col] = 0;
                    target--;
                } else {
                    target--;
                    if (target == col) {
                        continue;
                    }
                    temp[row][target] = temp[row][col];
                    temp[row][col] = 0;
                }
            }
        }

        func(temp, k + 1);
    }
}
