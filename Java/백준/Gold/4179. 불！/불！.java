import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int jx = 0, jy = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        int[][] time = new int[r][c];
        int count = 0;

        char[][] maze = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = str.charAt(j);

                if (maze[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }
                if (maze[i][j] == 'F') {
                    queue.offer(new int[]{i, j});
                    time[i][j] = 1;
                    count++;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (maze[nx][ny] == '#' || time[nx][ny] > 0) {
                    continue;
                }

                time[nx][ny] = time[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        time[jx][jy] = 1;
        int[][] visit = new int[r][c];
        visit[jx][jy] = 1;
        queue.offer(new int[]{jx, jy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (maze[nx][ny] == '#' || visit[nx][ny] > 0 || visit[nx][ny] == -1) {
                    continue;
                }

                visit[nx][ny] = visit[cur[0]][cur[1]] + 1;
                if (count == 0) {
                    queue.offer(new int[]{nx, ny});
                    continue;
                }
                if (time[nx][ny] <= visit[nx][ny]) {
                    visit[nx][ny] = -1;
                    continue;
                }

                queue.offer(new int[]{nx, ny});
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            if (i == 0 || i == r - 1) {
                for (int j = 0; j < c; j++) {
                    if (visit[i][j] == 0 || visit[i][j] == -1) {
                        continue;
                    } else {
                        min = Math.min(min, visit[i][j]);
                    }
                }
            } else {
                if (visit[i][0] > 0) {
                    min = Math.min(min, visit[i][0]);
                }
                if (visit[i][c-1] > 0) {
                    min = Math.min(min, visit[i][c-1]);
                }
            }
        }

        if (min !=  Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}