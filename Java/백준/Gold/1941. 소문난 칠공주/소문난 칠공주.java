import java.io.*;
import java.util.*;

public class Main {

    static char[][] student = new char[5][5];
    static boolean[][] isUsed = new boolean[5][5];
    static int count = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                student[i][j] = str.charAt(j);
            }
        }

        func(0, 0, 0);

        System.out.println(count);
    }

    private static void func(int cur, int y, int s) {
        if (y > 3) {
            return;
        }

        if (y + s == 7) {
            Deque<int[]> queue = new ArrayDeque<>();
            int[][] visit = new int[5][5];
            int count1 = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (isUsed[i][j]) {
                        visit[i][j] = 1;
                        queue.offer(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] pos = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = pos[0] + dx[dir];
                                int ny = pos[1] + dy[dir];

                                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                                    continue;
                                }

                                if (visit[nx][ny] == 1 || !isUsed[nx][ny]) {
                                    continue;
                                }

                                visit[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                                count1++;
                            }
                        }
                        if (count1 != 7) {
                            return;
                        } else {
                            count++;
                            return;
                        }
                    }
                }
            }
        }

        for (int i = cur; i < 25; i++) {
            isUsed[i / 5][i % 5] = true;
            if (student[i / 5][i % 5] == 'Y') {
                func(i + 1, y + 1, s);
            } else {
                func(i + 1, y, s + 1);
            }
            isUsed[i / 5][i % 5] = false;
        }
    }
}