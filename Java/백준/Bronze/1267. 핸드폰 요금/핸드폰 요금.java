  
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            list.add(scanner.nextInt());
        }
        
        int y = 0;
        for(int time : list)
        {
            int t = time / 30;
            if(time % 30 >= 0)
            {
                t++;
            }
            y += (t * 10);
        }
        int m = 0;
        for(int time : list)
        {
            int t = time / 60;
            if(time % 60 >= 0)
            {
                t++;
            }
            m += (t * 15);
        }
        
        if(y > m)
        {
            System.out.println("M " + m);
        } else if(y < m)
        {
            System.out.println("Y " + y);
        } else
        {
            System.out.println("Y M " + y);
        }
    }
}