import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            count2[str2.charAt(i) - 'a']++;
        }

        int same = 0;
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] == count2[i]) {
                same += count1[i];
            } else {
                same += Math.min(count1[i], count2[i]);
            }
        }
        System.out.println(str1.length() + str2.length() - 2 * same);
    }
}
