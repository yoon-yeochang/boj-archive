import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int[][] visit1 = new int[n][n];
        Deque<int[]> queue = new ArrayDeque<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int count1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit1[i][j] == 0) {
                    count1++;
                    visit1[i][j] = 1;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (grid[cur[0]][cur[1]] != grid[nx][ny] || visit1[nx][ny] == 1) {
                                continue;
                            }

                            visit1[nx][ny] = 1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        int count2 = 0;
        int[][] visit2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit2[i][j] == 0) {
                    if (grid[i][j] == 'B') {
                        count2++;
                        visit2[i][j] = 1;
                        queue.offer(new int[]{i, j});

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur[0] + dx[dir];
                                int ny = cur[1] + dy[dir];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                    continue;
                                }
                                if (grid[nx][ny] != 'B' || visit2[nx][ny] == 1) {
                                    continue;
                                }

                                visit2[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    } else {
                        count2++;
                        visit2[i][j] = 1;
                        queue.offer(new int[]{i, j});

                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur[0] + dx[dir];
                                int ny = cur[1] + dy[dir];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                    continue;
                                }
                                if (grid[nx][ny] == 'B' || visit2[nx][ny] == 1) {
                                    continue;
                                }

                                visit2[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        sb.append(count1).append("\n").append(count2);
        System.out.println(sb);
    }
}