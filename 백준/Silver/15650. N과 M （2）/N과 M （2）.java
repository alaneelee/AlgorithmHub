import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static Set<String> arr;
    static void input() throws Exception {
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N + 1];
        arr = new LinkedHashSet<>();

        makePermutations(0, "");

        for(String s : arr) {
            System.out.println(s);
        }
    }

    static void makePermutations(int count, String current) {

        if (count == M) {
            char[] charArr = current.toCharArray();
            Arrays.sort(charArr);
            String result = "";
            for(char c : charArr) {
                result += c + " ";
            }

            arr.add(result);

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                makePermutations(count + 1, current + i);
                visited[i] = false;
            }
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
