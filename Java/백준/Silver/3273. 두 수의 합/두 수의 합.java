import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        
        int x = scanner.nextInt();
        int count = 0;
        int[] arr1 = new int[1000001];
        for(int i = 0; i < n; i++)
        {
            if(x - arr[i] >= 0 && x-arr[i] <= 1000000 && arr1[x-arr[i]] != 0)
            {
                count++;
            } else
            {
                arr1[arr[i]]++;
            }
        }
        
        System.out.println(count);
    }
}