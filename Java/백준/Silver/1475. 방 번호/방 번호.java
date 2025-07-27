import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        String str = String.valueOf(n);
        int[] arr = new int[10];
        
        for(int i = 0; i < str.length(); i++)
        {
            arr[str.charAt(i) - '0'] += 1;
        }

        int max = 0;
        
        if(arr[6] >= arr[9])
        {
            max = arr[6] - ((arr[6] - arr[9]) / 2);
            for(int i = 0; i < 10; i++)
            {
                if(i == 6 || i == 9)
                {
                    continue;
                }
                if(arr[i] > max)
                {
                    max = arr[i];
                }
            }
        } else
        {
            max = arr[9] - ((arr[9] - arr[6]) / 2);
            for(int i = 0; i < 10; i++)
            {
                if(i == 6 || i == 9)
                {
                    continue;
                }
                if(arr[i] > max)
                {
                    max = arr[i];
                }
            }
        } 
        
        System.out.println(max);
    }
}