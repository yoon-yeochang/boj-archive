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

        //하나 이상의 토마토가 들어있음. 따라서 0(익지 않은) 이 존재하지 않으면 전부 익어 종료.
        int[][] box = new int[n][m];
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) {
                    zero = true;
                }
            }
        }
        if (!zero) {
            System.out.println(0);
            return;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] visit = new int[n][m];

        int day = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        //첫날 큐에 담는거 체크.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1 && visit[i][j] != 1) {
                    visit[i][j] = 1;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        //첫날이라 방문한건 이전칸이라 확인할 필요 없긴해.
                        if (box[nx][ny] == 0) {
                            queue.offer(new int[]{nx, ny});
                            box[nx][ny] = 1;
                            visit[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        } else {
            day++;
        }

        int[] nextday = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (Arrays.equals(nextday, cur)) {
                day++;
                flag = false;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    box[nx][ny] = 1;

                    if (!flag) {
                        nextday = new int[]{nx, ny};
                        flag = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }
}