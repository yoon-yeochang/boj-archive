import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] visit;
    static List<int[]> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    list.add(new int[]{i, j});
                }
                if (map[i][j] != 0) {
                    visit[i][j] = 1;
                }
            }
        }

        func(0);

        System.out.println(min);
    }

    private static void func(int k) {
        if (k == list.size()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j] == 0) {
                        count++;
                    }
                }
            }
            min = Math.min(min, count);
            return;
        }

        int[] cur = list.get(k);

        switch (map[cur[0]][cur[1]]) {
            case 1:
                num1(k);
                break;
            case 2:
                num2(k);
                break;
            case 3:
                num3(k);
                break;
            case 4:
                num4(k);
                break;
            case 5:
                num5(k);
                break;
            default:
                break;
        }
    }

    private static void num1(int k) {
        int[] cur = list.get(k);
        int row = cur[0];
        int col = cur[1];

        //상
        int temp = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp = i + 1;
                break;
            }
            visit[i][col]++;
        }
        func(k + 1);
        for (int i = temp; i <= row; i++) {
            visit[i][col]--;
        }

        //하
        temp = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp = i - 1;
                break;
            }
            visit[i][col]++;
        }
        func(k + 1);
        for (int i = temp; i >= row; i--) {
            visit[i][col]--;
        }

        //좌
        temp = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp = i + 1;
                break;
            }
            visit[row][i]++;
        }
        func(k + 1);
        for (int i = temp; i <= col; i++) {
            visit[row][i]--;
        }

        //우
        temp = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp = i - 1;
                break;
            }
            visit[row][i]++;
        }
        func(k + 1);
        for (int i = temp; i >= col; i--) {
            visit[row][i]--;
        }
    }

    private static void num2(int k) {
        int[] cur = list.get(k);
        int row = cur[0];
        int col = cur[1];

        //상하
        int temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        int temp2 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[i][col]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i >= row; i--) {
            visit[i][col]--;
        }

        //좌우
        temp1 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[row][i]++;
        }
        temp2 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= col; i++) {
            visit[row][i]--;
        }
        for (int i = temp2; i >= col; i--) {
            visit[row][i]--;
        }
    }

    private static void num3(int k) {
        int[] cur = list.get(k);
        int row = cur[0];
        int col = cur[1];

        //상우
        int temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        int temp2 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i >= col; i--) {
            visit[row][i]--;
        }

        //우하
        temp1 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp1 = i - 1;
                break;
            }
            visit[row][i]++;
        }
        temp2 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[i][col]++;
        }

        func(k + 1);

        for (int i = temp1; i >= col; i--) {
            visit[row][i]--;
        }
        for (int i = temp2; i >= row; i--) {
            visit[i][col]--;
        }

        //하좌
        //하
        temp1 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp1 = i - 1;
                break;
            }
            visit[i][col]++;
        }
        temp2 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp2 = i + 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i >= row; i--) {
            visit[i][col]--;
        }
        for (int i = temp2; i <= col; i++) {
            visit[row][i]--;
        }

        //좌상
        temp1 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[row][i]++;
        }
        temp2 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp2 = i + 1;
                break;
            }
            visit[i][col]++;
        }

        func(k + 1);

        for (int i = temp1; i <= col; i++) {
            visit[row][i]--;
        }
        for (int i = temp2; i <= row; i++) {
            visit[i][col]--;
        }
    }

    private static void num4(int k) {
        int[] cur = list.get(k);
        int row = cur[0];
        int col = cur[1];

        //하X
        int temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        int temp2 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp2 = i + 1;
                break;
            }
            visit[row][i]++;
        }
        int temp3 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp3 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i <= col; i++) {
            visit[row][i]--;
        }
        for (int i = temp3; i >= col; i--) {
            visit[row][i]--;
        }

        //좌X
        temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        temp2 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[i][col]++;
        }
        temp3 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp3 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i >= row; i--) {
            visit[i][col]--;
        }
        for (int i = temp3; i >= col; i--) {
            visit[row][i]--;
        }

        //상X
        temp1 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp1 = i - 1;
                break;
            }
            visit[i][col]++;
        }
        temp2 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp2 = i + 1;
                break;
            }
            visit[row][i]++;
        }
        temp3 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp3 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i >= row; i--) {
            visit[i][col]--;
        }
        for (int i = temp2; i <= col; i++) {
            visit[row][i]--;
        }
        for (int i = temp3; i >= col; i--) {
            visit[row][i]--;
        }

        //우X
        temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        temp2 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[i][col]++;
        }
        temp3 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp3 = i + 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i >= row; i--) {
            visit[i][col]--;
        }
        for (int i = temp3; i <= col; i++) {
            visit[row][i]--;
        }
    }

    private static void num5(int k) {
        int[] cur = list.get(k);
        int row = cur[0];
        int col = cur[1];

        //상하좌우
        int temp1 = 0;
        for (int i = row; i >= 0; i--) {
            if (map[i][col] == 6) {
                temp1 = i + 1;
                break;
            }
            visit[i][col]++;
        }
        int temp2 = n - 1;
        for (int i = row; i < n; i++) {
            if (map[i][col] == 6) {
                temp2 = i - 1;
                break;
            }
            visit[i][col]++;
        }
        int temp3 = 0;
        for (int i = col; i >= 0; i--) {
            if (map[row][i] == 6) {
                temp3 = i + 1;
                break;
            }
            visit[row][i]++;
        }
        int temp4 = m - 1;
        for (int i = col; i < m; i++) {
            if (map[row][i] == 6) {
                temp4 = i - 1;
                break;
            }
            visit[row][i]++;
        }

        func(k + 1);

        for (int i = temp1; i <= row; i++) {
            visit[i][col]--;
        }
        for (int i = temp2; i >= row; i--) {
            visit[i][col]--;
        }
        for (int i = temp3; i <= col; i++) {
            visit[row][i]--;
        }
        for (int i = temp4; i >= col; i--) {
            visit[row][i]--;
        }
    }
}
