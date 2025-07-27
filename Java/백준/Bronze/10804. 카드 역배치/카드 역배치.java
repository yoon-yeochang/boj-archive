import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= 20; i++)
        {
            list.add(i);
        }
        
        for(int i = 0; i < 10; i++)
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            List<Integer> part1 = new ArrayList<>(list.subList(0, (a-1)));
            List<Integer> part2 = new ArrayList<>(list.subList((a-1), b));
            List<Integer> part3 = new ArrayList<>(list.subList(b, 20));
            
            Collections.reverse(part2);
            
            list.clear();
            list.addAll(part1);
            list.addAll(part2);
            list.addAll(part3);
        }
        
        for(int n : list)
        {
            System.out.print(n + " ");
        }
    }
}