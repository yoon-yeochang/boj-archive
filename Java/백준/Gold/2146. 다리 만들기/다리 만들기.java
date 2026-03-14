import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[n][n];

        int count = 0;
        Deque<int[]> queue2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visit[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = 1;
                    count++;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (visit[nx][ny] != 0) {
                                continue;
                            }
                            if (map[nx][ny] == 0) {
                                queue2.offer(new int[]{cur[0], cur[1], count});
                                visit[cur[0]][cur[1]] = count;
                                continue;
                            }

                            visit[nx][ny] = 1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        int[][][] visit2 = new int[n][n][count + 1];

        while (!queue2.isEmpty()) {
            int[] cur = queue2.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (visit[nx][ny] == 1 || visit[nx][ny] == cur[2]) {
                        continue;
                    }
                    System.out.println(visit2[cur[0]][cur[1]][cur[2]]);
                    return;
                }

                if (visit2[nx][ny][cur[2]] > 0) {
                    continue;
                }

                visit2[nx][ny][cur[2]] = visit2[cur[0]][cur[1]][cur[2]] + 1;
                queue2.offer(new int[]{nx, ny, cur[2]});
            }
        }
    }
}
