import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Assignment {
    int score;
    int minutes;

    public Assignment(int score, int minutes) {
        this.score = score;
        this.minutes = minutes;
    }
}

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();

        int input;
        int result = 0;
        Stack<Assignment> stack = new Stack<>();

        for(int i = 0; i < T; i++) {
            input = scan.nextInt();
            if(input == 1) {
                stack.push(new Assignment(scan.nextInt(), scan.nextInt() - 1));
            }

            if(input == 0 && !stack.isEmpty()) {
                stack.peek().minutes--;
            }

            if(!stack.isEmpty() && stack.peek().minutes == 0) {
                result += stack.pop().score;
            }
        }

        System.out.println(result);
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
