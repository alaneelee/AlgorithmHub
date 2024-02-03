import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int num = 1;
        while(true) {
            String brackets = scan.nextLine();
            Deque<Character> q = new LinkedList<>();
            if (brackets.contains("-")) break;
            int cnt = 0;
            char c1;
            char c2;

            for (char c : brackets.toCharArray()) {
                if (c == '{') {
                    q.add(c);
                } else {
                    if (!q.isEmpty() && q.peekLast() == '{') {
                        q.removeLast();
                    } else {
                        q.add(c);
                    }
                }
            }

            while(!q.isEmpty()) {
                c1 = q.removeFirst();
                c2 = q.removeFirst();

                if(c1 == '{') cnt++;
                if(c1 == '}') {
                    if(c2 =='{') {
                        cnt += 2;
                    } else {
                        cnt++;
                    }
                }
            }



            sb.append(num).append(". ").append(cnt).append('\n');

            num++;

            print();

            sb.delete(0, sb.length());
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
