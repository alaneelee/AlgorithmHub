import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int N = scan.nextInt();
        int[] arr = new int[N+1];
        int left = 1;
        int right = 1;
        int count = 1;
        int sum = 1;

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        while (left < N && right < N) {

            if(sum < N) {
                right++;
                sum += arr[right];
            } else if (sum > N) {
                sum -= arr[left];
                left++;
            } else {
                count++;
                right++;
                sum += arr[right];
            }
        }

        System.out.println(count);
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
