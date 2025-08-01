import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int k = sc.nextInt();

        for (int i = 0; i < k; i++)
        {
            int number = sc.nextInt();
            if (number == 0)
            {
                stack.pop();
            } else
            {
                stack.push(number);
            }
        }
        int sum = 0;
        while(!stack.isEmpty())
        {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}