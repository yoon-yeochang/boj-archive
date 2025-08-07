import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push"))
            {
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
            } else if (str.equals("pop"))
            {
                Integer x = queue.poll();
                if (x != null)
                {
                    sb.append(x).append("\n");
                } else
                {
                    sb.append(-1).append("\n");
                }
            } else if (str.equals("size"))
            {
                int size = queue.size();
                sb.append(size).append("\n");
            } else if (str.equals("empty"))
            {
                boolean empty = queue.isEmpty();
                if (empty)
                {
                    sb.append(1).append("\n");
                } else
                {
                    sb.append(0).append("\n");
                }
            } else if (str.equals("front"))
            {
                Integer x = queue.peek();
                if (x != null)
                {
                    sb.append(x).append("\n");
                } else
                {
                    sb.append(-1).append("\n");
                }
            } else if (str.equals("back"))
            {
                Integer x = queue.peekLast();
                if (x != null)
                {
                    sb.append(x).append("\n");
                } else
                {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}