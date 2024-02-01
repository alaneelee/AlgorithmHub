import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();

        while(T > 0) {
            Deque<ArrayList<Integer>> q = new LinkedList<>();

            int N = scan.nextInt();
            int target = scan.nextInt();
            int max = 0;
            int cnt = 0;
            int idx = 0;
            int input;
            boolean flag = true;

            List<Integer> priority = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                input = scan.nextInt();
                row.add(i);
                row.add(input);
                q.add(row);
                priority.add(input);
            }
            Collections.sort(priority, Collections.reverseOrder());

            priority.add(-10);

            max = priority.get(0);

            while(flag) {
                if (q.getFirst().get(0) == target && q.getFirst().get(1) == max) {
                    flag = false;
                }
                if (q.getFirst().get(1) == max) {
                    max = priority.get(++idx);
                    q.removeFirst();
                    cnt++;
                } else {
                    q.addLast(q.removeFirst());
                }
            }

            System.out.println(cnt);
            T--;
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
