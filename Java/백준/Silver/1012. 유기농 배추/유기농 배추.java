import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] field = new int[m][n];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
            }

            int[][] visit = new int[m][n];
            Deque<int[]> queue = new ArrayDeque<>();

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            int count = 0;

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (field[a][b] == 1 && visit[a][b] != 1) {
                        count++;
                        visit[a][b] = 1;
                        queue.offer(new int[]{a, b});

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur[0] + dx[dir];
                                int ny = cur[1] + dy[dir];

                                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                                    continue;
                                }

                                if (field[nx][ny] == 0 || visit[nx][ny] == 1) {
                                    continue;
                                }

                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}