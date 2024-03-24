import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int n, d, k, c;
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();

        int[] sushi = new int[n];

        for (int i = 0; i < n; i++) {
            sushi[i] = scan.nextInt();
        }

        int[] kindOfSushi = new int[d + 1];

        int count = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if(kindOfSushi[sushi[i]] == 0) {
                count++;
            }
            kindOfSushi[sushi[i]]++;
        }
        max = count;

        for (int i = 0; i < n; i++) {
            if(count >= max) {
                max = kindOfSushi[c] == 0 ? count + 1 : count;
            }

            kindOfSushi[sushi[i]]--;

            if(kindOfSushi[sushi[i]] == 0) count --;

            if(kindOfSushi[sushi[(i+k) % n]] == 0) count++;

            kindOfSushi[sushi[(i+k) % n]]++;
        }

        System.out.println(max);
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
