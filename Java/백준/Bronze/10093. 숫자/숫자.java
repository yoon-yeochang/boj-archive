import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        List<Integer> numbers = new ArrayList<>();
        
        if(a > (b + 1))
        {
            for(int i = b + 1; i < a; i++)
            {
                numbers.add(i);
            }
            System.out.println((a - b - 1));
        } else if((a + 1) < b)
        {
            for(int i = a + 1; i < b; i++)
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
        for(int n : numbers)
        {
            System.out.print(n + " ");
            
        }

    }
}