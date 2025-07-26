
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int money;
        if((a == b) && (a == c))
        {
            money = 10000 + (a * 1000);
        } else if((a == b) && (a != c))
        {
            money = 1000 + (a * 100);
        } else if((a == c) && (a != b))
        {
            money = 1000 + (a * 100);
        } else if((b == c) && (a != b))
        {
            money = 1000 + (b * 100);
        } else
        {
            int max = a;
            if(b > max)
            {
                max = b;
            }
            if(c > max)
            {
                max = c;
            }
            money = max * 100;
        }
        System.out.println(money);
    }
}