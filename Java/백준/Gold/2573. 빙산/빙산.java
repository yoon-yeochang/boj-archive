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

        int[][][] sea = new int[n][m][2];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j][0] = Integer.parseInt(st.nextToken());
                if (sea[i][j][0] > 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 1;
        int year = 0;

        while (count < 2) {

            boolean isIce = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sea[i][j][0] > 0) {
                        sea[i][j][0] -= sea[i][j][1];
                        isIce = true;
                        if (sea[i][j][0] < 0) {
                            sea[i][j][0] = 0;
                        } else {
                            queue.offer(new int[]{i, j});
                        }
                    }
                }
            }

            if (!isIce) {
                System.out.println(0);
                return;
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int zero = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (sea[nx][ny][0] == 0) {
                        zero++;
                    }
                }
                sea[cur[0]][cur[1]][1] = zero;
            }

            int[][] visit = new int[n][m];
            count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sea[i][j][0] > 0 && visit[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        count++;

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur[0] + dx[dir];
                                int ny = cur[1] + dy[dir];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                    continue;
                                }
                                if (sea[nx][ny][0] == 0 || visit[nx][ny] != 0) {
                                    continue;
                                }

                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }

            if (count == 1) {
                year++;
            }
        }

        System.out.println(year);
    }
}