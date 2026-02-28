import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a * b * c;

        String str = Integer.toString(num);
        int[] n = new int[10];

        for (int i = 0; i < str.length(); i++) {
            n[Integer.parseInt(String.valueOf(str.charAt(i)))]++;
        }

        for (int i : n) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}