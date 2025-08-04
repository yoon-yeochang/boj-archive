import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        Deque<Integer> tower = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
        {
            int t = Integer.parseInt(st.nextToken());
            while (!tower.isEmpty() && tower.peek() < t)
            {
                tower.pop();
                index.pop();
            }
            if (tower.peek() == null)
            {
                sb.append(0).append(" ");
                tower.push(t);
                index.push(i);
            } else
            {
                sb.append(index.peek()).append(" ");
                tower.push(t);
                index.push(i);
            }
        }

        System.out.println(sb);
    }
}