import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        List<Long> numbers = new ArrayList<>();
        
        if(a > (b + 1))
        {
            for(long i = b + 1; i < a; i++)
            {
                numbers.add(i);
            }
            System.out.println((a - b - 1));
        } else if((a + 1) < b)
        {
            for(long i = a + 1; i < b; i++)
            {
                numbers.add(i);
            }
            System.out.println((b - a - 1));
        } else
        {
            System.out.println(0);
            return;
        }
        Collections.sort(numbers);
        for(long n : numbers)
        {
            System.out.print(n + " ");
            
        }

    }
}