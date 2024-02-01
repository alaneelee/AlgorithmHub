import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int N = scan.nextInt();
        List<Integer> out = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        int temp = 0;

        for(int i = 0; i < N; i++) {
            map.put(scan.nextLine(), i+1);
        }

        for(int i = 0; i < N; i++) {
            out.add(map.get(scan.nextLine()));
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(out.get(i) > out.get(j)) {
                    temp++;
                }
            }
            if (temp < out.get(i) - 1) {
                cnt++;
            }
            temp = 0;
        }

        System.out.println(cnt);
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
