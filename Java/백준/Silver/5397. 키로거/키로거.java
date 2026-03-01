import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') {
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                } else if (str.charAt(j) == '>') {
                    if (it.hasNext()) {
                        it.next();
                    }
                } else if (str.charAt(j) == '-') {
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                } else {
                    it.add(str.charAt(j));
                }
            }

            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
