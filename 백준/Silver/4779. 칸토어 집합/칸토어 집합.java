import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] answer;

    static void input() throws Exception {

        String input;

        while((input = scan.nextLine()) != null) {

            int N = Integer.parseInt(input);

            int q = (int) Math.pow(3, N);

            answer = new char[q];

            for (int i = 0; i < q; i++) {
                answer[i] = '-';
            }
            replace(0, q);

            for (char c : answer) {
                sb.append(c);
            }
            print();
            System.out.println();
            sb.delete(0, q);
        }

    }

    static void replace(int start, int q) {
        if (q < 3) {
            return;
        }

        int left = q / 3;
        int right = left * 2;

        for (int i = start + left; i < start + right; i++) {
            answer[i] = ' ';
        }

        replace(start, left);
        replace(right + start, left);
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
