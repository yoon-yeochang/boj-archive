    
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 5; i++)
        {
            int n = scanner.nextInt();
            numbers.add(n);
            sum += n;
        }
        Collections.sort(numbers);
        System.out.println(sum / 5);
        System.out.println(numbers.get(2));
    }
}