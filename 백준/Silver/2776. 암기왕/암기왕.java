import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] arr;

    static void input() throws Exception {
        T = scan.nextInt();

        while (T > 0) {
            N = scan.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scan.nextInt();
            }

            Arrays.sort(arr);

            M = scan.nextInt();

            for (int i = 0; i < M; i++) {
                int num = scan.nextInt();
                if (binarySearch(num)) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }

            T--;
        }
        print();
    }

    static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int midIndex = (left + right) / 2;
            int mid = arr[midIndex];

            if (num > mid) left = midIndex + 1;
            else if (num < mid) right = midIndex - 1;
            else return true;
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
