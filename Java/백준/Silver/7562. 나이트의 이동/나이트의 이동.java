import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(st.nextToken());
            int destY = Integer.parseInt(st.nextToken());

            int[][] visit = new int[l][l];
            int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
            int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

            if (x == destX && y == destY) {
                sb.append(0).append("\n");
                continue;
            }

            Deque<int[]> queue = new ArrayDeque<>();
            visit[x][y] = 1;
            queue.offer(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                        continue;
                    }
                    if (visit[nx][ny] > 0) {
                        continue;
                    }

                    visit[nx][ny] = visit[cur[0]][cur[1]] + 1;
                    if (nx == destX && ny == destY) {
                        break;
                    }
                    queue.offer(new int[]{nx, ny});
                }
            }
            sb.append(visit[destX][destY] - 1).append("\n");
        }

        System.out.println(sb);
    }
}