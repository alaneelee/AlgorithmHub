import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();
        String command;
        String arr;
        int num;
        while (T > 0) {
            command = scan.nextLine();
            num = scan.nextInt();
            arr = scan.nextLine();
            boolean flag = true;
            boolean reversed = false;

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(arr);

            Deque<Integer> list = new ArrayDeque<>();
            while (matcher.find()) {
                list.add(Integer.parseInt(matcher.group()));
            }


            for (int i = 0; i < command.length(); i++) {
                switch (command.charAt(i)) {
                    case 'R':
                        reversed = !reversed;
                        break;
                    case 'D':
                        if (list.isEmpty()) {
                            flag = false;
                            break;
                        } else {
                            if (reversed) {
                                list.pollLast();
                            } else {
                                list.pollFirst();
                            }
                        }
                }
            }

            if (flag) {
                sb.append('[');
                if (!list.isEmpty()) {
                    if(reversed) {
                        while(!list.isEmpty()) {
                            sb.append(list.pollLast());
                            if (!list.isEmpty()) {
                                sb.append(',');
                            }
                        }
                    } else {
                        while(!list.isEmpty()) {
                            sb.append(list.pollFirst());
                            if (!list.isEmpty()) {
                                sb.append(',');
                            }
                        }
                    }
                }
                sb.append(']');
            } else {
                sb.append("error");
            }

            sb.append('\n');
            T--;

//            if (flag) {
//                sb.append('[');
//                if (!list.isEmpty()) {
//                    for (int i = 0; i < list.size() - 1; i++) {
//                        sb.append(list.get(i)).append(',');
//                    }
//                    sb.append(list.get(list.size() - 1));
//                }
//                sb.append(']');
//            } else {
//                sb.append("error");
//            }
//
//            sb.append('\n');
//            T--;
        }
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
