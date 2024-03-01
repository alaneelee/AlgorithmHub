import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int E = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();

        if (E == 15) E = 0;
        if (S == 28) S = 0;
        if (M == 19) M = 0;
        
        for (int i = 1; i <= 7980; i++) {
            if (i % 15 == E && i % 28 == S && i % 19 == M) {
                System.out.println(i);
                break;
            }

            if (i % 15 == 0 && i % 28 == 0 && i % 19 == 0) {
                System.out.println(i);
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
