import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int idx;
    int height;

    public Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();
        int height;

        Stack<Top> stack = new Stack<>();


        for(int i = 0; i < T; i++) {
            height = scan.nextInt();
            if (stack.isEmpty()) {
                sb.append('0').append(' ');
                stack.push(new Top(i + 1, height));
            } else {
                while(true) {
                    if (stack.isEmpty()) {
                        sb.append('0').append(' ');
                        stack.push(new Top(i + 1, height));
                        break;
                    }

                    Top preTop = stack.peek();

                    if (preTop.height > height) {
                        sb.append(preTop.idx).append(" ");
                        stack.push(new Top(i + 1, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        print();

//        while(!stack.isEmpty()) {
//            Top top = stack.pop();
//            num = 0;
//            for (int i = stack.size() - 1; i > 0; i--) {
//                if (stack.get(i).height > top.height) {
//                    num = stack.get(i).idx;
//                    break;
//                }
//            }
//            result.push(num);
//        }
//
//        while(!result.isEmpty()) {
//            sb.append(result.pop()).append(' ');
//        }
//        print();

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
