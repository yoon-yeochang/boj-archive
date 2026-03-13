import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            Deque<int[]> queue = new ArrayDeque<>();
            int[][] fire = new int[h][w];

            int sx = 0, sy = 0;

            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = str.charAt(k);
                    if (map[j][k] == '*') {
                        fire[j][k] = 1;
                        queue.offer(new int[]{j, k});
                    }
                    if (map[j][k] == '@') {
                        sx = j;
                        sy = k;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }
                    if (map[nx][ny] == '#' || fire[nx][ny] > 0) {
                        continue;
                    }

                    fire[nx][ny] = fire[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }

            int[][] sang = new int[h][w];
            sang[sx][sy] = 1;
            queue.offer(new int[]{sx, sy});

            boolean exit = false;
            search:
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    int cs = sang[cur[0]][cur[1]];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(cs).append("\n");
                        exit = true;
                        break search;
                    }

                    if (map[nx][ny] == '#' || sang[nx][ny] > 0) {
                        continue;
                    }

                    if (fire[nx][ny] > 0 && fire[nx][ny] <= cs + 1) {
                        continue;
                    }

                    sang[nx][ny] = cs + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
            if (!exit) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(sb);
    }
}