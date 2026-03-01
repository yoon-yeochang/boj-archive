import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> it = list.listIterator();
        while (it.hasNext()) {
            it.next();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);

            switch (c) {
                case 'L' :
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case 'D' :
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case 'B' :
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P' :
                    it.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for (Character character : list) {
            sb.append(character);
        }

        System.out.println(sb);

    }
}
