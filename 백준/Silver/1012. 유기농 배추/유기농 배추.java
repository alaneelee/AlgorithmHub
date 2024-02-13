import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M;
    static int N;
    static int K;
    static void input() throws Exception {
        int T = scan.nextInt();

        while (T > 0) {
            M = scan.nextInt();
            N = scan.nextInt();
            K = scan.nextInt();

            graph = new int[N][M];

            for (int i = 0; i < K; i++) {
                int y = scan.nextInt();
                int x = scan.nextInt();
                graph[x][y] = 1;
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dfs(i, j)) answer++;
                }
            }

            System.out.println(answer);
            T--;
        }

    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return false;

        if (graph[x][y] == 1) {
            graph[x][y] = 0;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
            return true;
        }

        return false;
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
