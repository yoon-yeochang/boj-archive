import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            sb.append("+").append("\n");
            stack.push(i);
            while (count < n && !stack.isEmpty() && stack.peek() == arr[count])
            {
                stack.pop();
                sb.append("-").append("\n");
                count++;
            }
        }

        if (count == n)
        {
            System.out.println(sb);
        } else
        {
            System.out.println("NO");
        }
    }
}