

import java.io.*;
import java.util.*;

public class Main {

    static int[][] field = new int[12][6];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int boomCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                switch (line.charAt(j)) {
                    case '.':
                        field[i][j] = 0;
                        break;
                    case 'R':
                        field[i][j] = 1;
                        break;
                    case 'G':
                        field[i][j] = 2;
                        break;
                    case 'B':
                        field[i][j] = 3;
                        break;
                    case 'P':
                        field[i][j] = 4;
                        break;
                    case 'Y':
                        field[i][j] = 5;
                        break;
                }
            }
        }

        boom(0);

    }

    private static void boom(int k) {
        boolean isBoom = false;
        int[][] visit = new int[12][6];
        List<int[]> list = new ArrayList<>();
        List<int[]> temp;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == 0 || visit[i][j] > 0) {
                    continue;
                }

                int n = field[i][j];
                temp = check(i, j, n, visit);
                if (temp != null) {
                    list.addAll(temp);
                    isBoom = true;
                }
            }
        }

        if (!isBoom) {
            System.out.println(k);
            return;
        }

        delete(list);

        boom(k+1);
    }

    private static List<int[]> check(int i, int j, int n, int[][] visit) {

        List<int[]> list = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        visit[i][j] = n;
        list.add(new int[]{i, j});
        queue.offer(new int[]{i, j});
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) {
                    continue;
                }
                if (field[nx][ny] != n || visit[nx][ny] != 0) {
                    continue;
                }

                visit[nx][ny] = n;
                count++;
                queue.offer(new int[]{nx, ny});
                list.add(new int[]{nx, ny});
            }
        }

        if (count >= 4) {
            return list;
        } else {
            return null;
        }
    }

    private static void delete(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int x = cur[0];
            int y = cur[1];
            field[x][y] = 0;
        }

        for (int col = 0; col < 6; col++) {
            int target = 11;
            for (int row = 10; row >= 0; row--) {
                if (field[row][col] == 0) {
                    continue;
                }

                if (field[target][col] == 0) {
                    field[target][col] = field[row][col];
                    field[row][col] = 0;
                    target--;
                } else {
                    target--;
                    if (target != row) {
                        field[target][col] = field[row][col];
                        field[row][col] = 0;
                    }
                }
            }
        }
    }
}
