import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int[][][] visit = new int[n][m][2];
        Deque<int[]> queue = new ArrayDeque<>();

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        visit[0][0][0] = 1;
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int broken = cur[2];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (broken == 1 && map[nx][ny] == 1) {
                    continue;
                }
                if (broken == 0 && map[nx][ny] == 1) {
                    broken = 1;
                }
                if (visit[nx][ny][broken] > 0) {
                    continue;
                }

                visit[nx][ny][broken] = visit[cur[0]][cur[1]][cur[2]] + 1;
                queue.offer(new int[]{nx, ny, broken});
            }
        }

        int a = visit[n-1][m-1][0];
        int b = visit[n-1][m-1][1];

        if (a > 0 && b > 0) {
            int min = Math.min(a, b);
            System.out.println(min);
        } else if (a > 0 && b == 0) {
            System.out.println(a);
        } else if (a == 0 && b > 0) {
            System.out.println(b);
        } else {
            System.out.println(-1);
        }
    }
}