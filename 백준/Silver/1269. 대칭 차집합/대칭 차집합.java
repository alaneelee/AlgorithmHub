import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    // 집합이니 Set 사용
    static void input() throws Exception {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int answer = 0;
        int T = scan.nextInt();
        int T2 = scan.nextInt();

        for (int i = 0; i < T; i++) {
            setA.add(scan.nextInt());
        }

        for (int i = 0; i < T2; i++) {
            setB.add(scan.nextInt());
        }

        for(int num : setA) {
            if (!setB.contains(num)) {
                answer++;
            }
        }

        for(int num : setB) {
            if (!setA.contains(num)) {
                answer++;
            }
        }

        sb.append(answer);
        
        print();
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
