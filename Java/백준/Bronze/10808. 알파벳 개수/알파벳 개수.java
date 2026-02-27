import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] string = br.readLine().toCharArray();
        int[] arr = new int[10000];

        for (int i = 0; i < string.length; i++) {
            arr[string[i]]++;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
