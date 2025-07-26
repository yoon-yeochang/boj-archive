import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++)
        {
            int n = scanner.nextInt();
            numbers.add(n);
            sum += n;
        }
        int a = sum - 100;
        for(int i = 0; i < 9; i++)
        {
            for(int j = i + 1; j < 9; j++)
            {
                if(numbers.get(i) + numbers.get(j) == a)
                {
                    numbers.remove(j);
                    numbers.remove(i);
                    Collections.sort(numbers);
                    for(int n : numbers)
                    {
                        System.out.println(n);
                    }
                    return;
                }
            }
        }
    }
}