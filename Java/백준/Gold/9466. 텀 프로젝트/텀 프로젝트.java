import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] student = new int[n+1][2];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                student[j][0] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer> queue = new ArrayDeque<>();
            int[] visit = new int[n + 1];

            for (int k = 1; k < n+1; k++) {
                if (visit[k] > 0) {
                    continue;
                }
                queue.offer(student[k][0]);

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    if (x == k) {
                        queue.offer(student[k][0]);
                        while (!queue.isEmpty()) {
                            int y = queue.poll();
                            visit[y] = 1;
                            if (y == k) {
                                break;
                            }
                            queue.offer(student[y][0]);
                        }
                        break;
                    }

                    if (visit[x] != 0) {
                        queue.offer(student[k][0]);
                        visit[k] = 2;
                        while (!queue.isEmpty()) {
                            int y = queue.poll();
                            if (y == x) {
                                break;
                            }
                            visit[y] = 2;
                            queue.offer(student[y][0]);
                        }
                        break;
                    }

                    if (student[x][1] == k) {
                        queue.offer(student[x][0]);
                        while (!queue.isEmpty()) {
                            int y = queue.poll();
                            visit[y] = 1;
                            if (y == x) {
                                break;
                            }
                            queue.offer(student[y][0]);
                        }
                        visit[k] = 2;
                        queue.offer(student[k][0]);
                        while (!queue.isEmpty()) {
                            int y = queue.poll();
                            if (y == x) {
                                break;
                            }
                            visit[y] = 2;
                            queue.offer(student[y][0]);
                        }
                        break;
                    }

                    student[x][1] = k;
                    queue.offer(student[x][0]);
                }
            }

            int count = 0;
            for (int k = 1; k < n+1; k++) {
                if (visit[k] == 2) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}