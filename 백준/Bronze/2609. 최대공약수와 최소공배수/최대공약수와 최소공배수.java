import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        System.out.println(gcd(num1, num2));
        System.out.println(lcm(num1, num2));
    }

    static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    static int lcm(int num1, int num2) {
        int a = num1;
        int b = num2;
        while(a != b) {
            if (a == b) return a;
            if (a > b) {
                b += num2;
            } else if (a < b) {
                a += num1;
            }
        }
        return a;
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
