import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine().trim());

        for(int i = 1;  i <= n; i++)
        {
            queue.offer(i);
        }

        while(queue.size() != 1)
        {
            queue.poll();
            int x = queue.poll();
            queue.offer(x);
        }

        System.out.println(queue.peek());
    }
}