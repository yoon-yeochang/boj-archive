import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        ListIterator<Integer> it = list.listIterator();
        sb.append("<");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    it = list.listIterator();
                    it.next();
                }
            }
            sb.append(it.previous());
            it.remove();

            if (i != n - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
