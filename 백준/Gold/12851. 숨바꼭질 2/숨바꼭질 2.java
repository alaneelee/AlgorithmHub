import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static final int MAX = 100001;
    static boolean[] visited;
    static Queue<Integer> queue;

    static void input() throws Exception {
        N = scan.nextInt();
        K = scan.nextInt();

        visited = new boolean[MAX + 1];
        queue = new LinkedList<>();
        queue.offer(N);

        int time = 0;
        int count = 0;

        while (true) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited[cur] = true;

                if (cur == K) {
                    count++;
                    continue;
                }

                if (cur * 2 <= MAX && !visited[cur * 2]) queue.offer(cur * 2);
                if (cur + 1 <= MAX && !visited[cur + 1]) queue.offer(cur + 1);
                if (cur - 1 >= 0 && !visited[cur - 1]) queue.offer(cur - 1);
            }

            if (count > 0) {
                System.out.println(time);
                System.out.println(count);
                break;
            }

            time++;
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
