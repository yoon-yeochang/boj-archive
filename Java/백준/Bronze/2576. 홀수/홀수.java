import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        List<Integer> odds = new ArrayList<>();
        for(int i = 0; i < 7; i++)
        {
            int a = scanner.nextInt();
            if(a % 2 == 1)
            {
                odds.add(a);
                sum += a;
            }
        }
        if(sum == 0)
        {
            System.out.println(-1);
        } else
        {
            System.out.println(sum);
            System.out.println(Collections.min(odds));
        }
    }
}