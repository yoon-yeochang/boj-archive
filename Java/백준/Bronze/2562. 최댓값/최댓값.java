import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 9; i++)
        {
            list.add(scanner.nextInt());
        }
        int max = Collections.max(list);
        int index = list.indexOf(max);
        System.out.println(max);
        System.out.println(index + 1);
    }
}