import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int stick = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' && str.charAt(i + 1) != ')') {
                stick++;
            } else if (c == '(' && str.charAt(i + 1) == ')') {
                count += stick;
                i++;
            } else if (c == ')') {
                stick--;
                count++;
            }
        }
        System.out.println(count);
    }
}