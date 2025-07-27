import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long n = a * b * c;
        int[] arr = new int[10];
        
        String strn = String.valueOf(n);
        for(int i = 0; i < strn.length(); i++)
        {
            arr[strn.charAt(i) - '0'] += 1;
        }
        for(int i = 0; i < 10; i++)
        {
            System.out.println(arr[i]);
        }
    }
}