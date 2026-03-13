import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        boolean isZero = false;

        int[][][] visit = new int[h][n][m];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 0) {
                        isZero = true;
                    }
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                        visit[i][j][k] = 1;
                    }
                }
            }
        }

        if (!isZero) {
            System.out.println(0);
            return;
        }

        int[] dh = {1, -1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nh = cur[0] + dh[dir];
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];

                if (nh < 0 || nh >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (box[nh][nx][ny] == -1 || visit[nh][nx][ny] > 0) {
                    continue;
                }

                visit[nh][nx][ny] = visit[cur[0]][cur[1]][cur[2]] + 1;
                box[nh][nx][ny] = 1;
                queue.offer(new int[]{nh, nx, ny});
            }
        }

        int max = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(visit[i][j][k], max);
                }
            }
        }

        System.out.println(max - 1);
    }
}