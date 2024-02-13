import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] cycle;
    static void input() throws Exception {
        int T = scan.nextInt();

        while(T > 0) {
            int N = scan.nextInt();

            cycle = new int [N+1];
//            for (int i = 0; i <= N; i++) {
//                cycle.add(new ArrayList<Integer>());
//            }
//
//            for(int i = 0; i < N; i++) {
//                cycle.get(i+1).add(scan.nextInt());
//            }

            for(int i = 1; i <= N; i++) {
                cycle[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                int destination = scan.nextInt();
                union(i, destination);
            }

            int answer = 0;

            for (int i = 1; i <= N; i++) {
                if (find(i) == i) {
                    answer++;
                }
            }

            System.out.println(answer);
            T--;
        }
    }

    static int find(int x) {
        if (cycle[x] == x) {
            return x;
        }
        return cycle[x] = find(cycle[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            cycle[a] = b;
        }
    }

    static void print() {
        System.out.print(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

}
