import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        for(int i = 0; i < 4; i++)
        {
            a += scanner.nextInt();
        }
        int b = 0;
        for(int i = 0; i < 4; i++)
        {
            b += scanner.nextInt();
        }
        int c = 0;
        for(int i = 0; i < 4; i++)
        {
            c += scanner.nextInt();
        }
        
        play(a);
        play(b);
        play(c);
        
    }
    private static void play(int n)
    {
        if(n == 3)
        {
            System.out.println("A");
        }
        if(n == 2)
        {
            System.out.println("B");
        }
        if(n == 1)
        {
            System.out.println("C");
        }
        if(n == 0)
        {
            System.out.println("D");
        }
        if(n == 4)
        {
            System.out.println("E");
        }
    }
}