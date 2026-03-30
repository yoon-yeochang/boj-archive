import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int numH;
    static int numC;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new int[]{i, j});
                }
                if (num == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        numH = house.size();
        numC = chicken.size();
        arr = new int[m];

        if (numC <= m) {
            for (int i = 0; i < numC; i++) {
                func1(chicken);
            }
        } else {
            pick(0, 0);
        }

        System.out.println(min);
    }

    private static void func1(List<int[]> list) {
        int temp = 0;

        for (int i = 0; i < numH; i++) {
            int md = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                int[] h = house.get(i);
                int[] c = list.get(j);

                int xh = h[0];
                int yh = h[1];
                int xc = c[0];
                int yc = c[1];

                int d = Math.abs(xh - xc) + Math.abs(yh - yc);
                md = Math.min(md, d);
            }
            temp += md;
        }

        min = Math.min(min, temp);
    }

    private static void func2(int[] arr) {
        int temp = 0;

        for (int i = 0; i < numH; i++) {
            int md = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int[] h = house.get(i);
                int[] c = chicken.get(arr[j]);

                int xh = h[0];
                int yh = h[1];
                int xc = c[0];
                int yc = c[1];

                int d = Math.abs(xh - xc) + Math.abs(yh - yc);
                md = Math.min(md, d);
            }
            temp += md;
        }

        min = Math.min(min, temp);
    }


    private static void pick(int k, int num) {
        if (k == m) {
            func2(arr);
            return;
        }

        for (int i = num; i < numC; i++) {
            arr[k] = i;
            pick(k + 1, i + 1);
        }
    }
}
