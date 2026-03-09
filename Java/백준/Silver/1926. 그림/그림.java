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

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visit = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && visit[i][j] == 0) {

                    count++;
                    int size = 1;

                    visit[i][j] = 1;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }
                            if (visit[nx][ny] == 1 || board[nx][ny] != 1) {
                                continue;
                            }

                            visit[nx][ny] = 1;
                            queue.offer(new int[]{nx, ny});

                            size++;
                        }
                    }

                    max = Math.max(max, size);
                }
            }
        }

        sb.append(count).append("\n");
        sb.append(max).append("\n");
        System.out.println(sb);
    }
}