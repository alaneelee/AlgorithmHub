import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int answer;
    static final int INF = 987654321;

    static void input() throws Exception {
        N = scan.nextInt();
        M = scan.nextInt();

        int[][] graph = new int[N+1][N+1];
        int minKevin = INF;

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                if (i != j) graph[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();

            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        answer = 0;

        for (int i = 1; i <= N; i++) {
            int kevin = 0;
            for (int j = 1; j <= N; j++) {
                kevin += graph[i][j];
            }

            if (kevin < minKevin) {
                minKevin = kevin;
                answer = i;
            }
        }

        System.out.println(answer);
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
