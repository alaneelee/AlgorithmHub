import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {

            LinkedList<Character> linklist = new LinkedList<>();

            ListIterator<Character> list = linklist.listIterator();

            String pwd = scan.nextLine();

            for (char c : pwd.toCharArray()) {
                switch (c) {
                    case '<':
                        if (list.hasPrevious()) {
                            list.previous();
                        }
                        break;
                    case '>':
                        if (list.hasNext()) {
                            list.next();
                        }
                        break;
                    case '-':
                        if (list.hasPrevious()) {
                            list.previous();
                            list.remove();
                        }
                        break;
                    default:
                        list.add(c);
                }
            }

            for (char c : linklist) {
                sb.append(c);
            }
            sb.append('\n');
        }
        print();

//        for (int i = 0; i < T; i++) {
//            String pwd = scan.nextLine();
//
//            Stack<Character> stack1 = new Stack<>();
//            Stack<Character> stack2 = new Stack<>();
//
//            for(char c : pwd.toCharArray()) {
//                switch (c) {
//                    case '<':
//                        if (!stack1.isEmpty()) {
//                            stack2.push(stack1.pop());
//                        }
//                        break;
//                    case '>':
//                        if (!stack2.isEmpty()) {
//                            stack1.push(stack2.pop());
//                        }
//                        break;
//                    case '-':
//                        if (!stack1.isEmpty()) {
//                            stack1.pop();
//                        }
//                        break;
//                    default:
//                        stack1.push(c);
//                        break;
//                }
//            }
//
//            while(!stack2.isEmpty()) {
//                stack1.push(stack2.pop());
//            }
//
//            for(char c : stack1) {
//                sb.append(c);
//            }
//            sb.append('\n');
//
//        }
//        print();
//            String pwd = scan.nextLine();
//            LinkedList<Character> result = new LinkedList<>();
//            int idx = 0;
//
//            for (char c : pwd.toCharArray()) {
//                switch (c) {
//                    case '<':
//                        if (idx > 0) {
//                            idx--;
//                        }
//                        break;
//                    case '>':
//                        if (idx < result.size()) {
//                            idx++;
//                        }
//                        break;
//                    case '-':
//                        if (idx > 0) {
//                            result.remove(idx - 1);
//                            idx--;
//                        }
//                        break;
//                    default:
//                        result.add(idx, c);
//                        idx++;
//                }
//            }
//
//            for (char c : result) {
//                sb.append(c);
//            }
//
//            sb.append('\n');
//
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
