import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        for(int i = 0; i < 3; i++)
        {
            numbers.add(scanner.nextInt());
        }
        
        numbers.sort(null);
        
        for(Integer number : numbers)
        {
            System.out.print(number + " ");
        }
    }
}