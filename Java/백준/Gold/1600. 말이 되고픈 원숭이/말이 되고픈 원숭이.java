import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        if (w == 1 && h == 1) {
            System.out.println(0);
            return;
        }

        int[][] grid = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] visit = new int[h][w][k+1];
        Deque<int[]> queue = new ArrayDeque<>();

        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] hy = {1, -1, 2, -2, 2, -2, 1, -1};

        visit[0][0][0] = 1;
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + mx[dir];
                int ny = cur[1] + my[dir];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (grid[nx][ny] == 1 || visit[nx][ny][cur[2]] > 0) {
                    continue;
                }

                visit[nx][ny][cur[2]] = visit[cur[0]][cur[1]][cur[2]] + 1;
                queue.offer(new int[]{nx, ny, cur[2]});
            }

            if (cur[2] < k) {
                
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur[0] + hx[dir];
                    int ny = cur[1] + hy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }

                    if (grid[nx][ny] == 1 || visit[nx][ny][cur[2]+1] > 0) {
                        continue;
                    }

                    visit[nx][ny][cur[2]+1] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    queue.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < k + 1; i++) {
            if (visit[h - 1][w - 1][i] == 0) {
                count++;
                continue;
            }
            min = Math.min(visit[h-1][w-1][i], min);
        }

        if (count == k + 1) {
            System.out.println(-1);
        } else {
            System.out.println(min-1);
        }
    }
}