import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            String str = sc.next();
            if (str.equals("push"))
            {
                int number = sc.nextInt();
                stack.push(number);
            } else if (str.equals("pop"))
            {
                if (stack.isEmpty())
                {
                    System.out.println(-1);
                } else
                {
                    System.out.println(stack.pop());
                }
            } else if (str.equals("size"))
            {
                System.out.println(stack.size());
            } else if (str.equals("empty"))
            {
                if (stack.isEmpty())
                {
                    System.out.println(1);
                } else
                {
                    System.out.println(0);
                }
            } else if (str.equals("top"))
            {
                if (stack.isEmpty())
                {
                    System.out.println(-1);
                } else
                {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
