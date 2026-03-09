
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
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String number = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = number.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE; //가능한 최장길이보다 적당히 큰수 더해서 젤큰수라 생각함.
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        int count = 1;

        distance[0][0] = 1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curd = distance[cur[0]][cur[1]];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }

                int d = curd + 1;

                if (distance[nx][ny] <= d) {
                    continue;
                }

                distance[nx][ny] = Math.min(distance[nx][ny], d);
                queue.offer(new int[]{nx, ny});
            }
        }

        System.out.println(distance[n-1][m-1]);
    }
}
