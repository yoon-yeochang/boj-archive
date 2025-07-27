import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String abcd = "abcdefghijklmnopqrstuvwxyz";
        char[] w1 = word.toCharArray();
        char[] w2 = abcd.toCharArray();
        int[] len = new int[w2.length];
        
        for(int i = 0; i < w2.length; i++)
        {
            for(int j = 0; j < w1.length; j++)
            {
                if(w2[i] == w1[j])
                {
                    len[i] += 1;
                }
            }
            System.out.print(len[i] + " ");
        }
    }
}