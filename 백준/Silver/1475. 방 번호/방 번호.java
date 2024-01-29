import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        HashMap<Character, Integer> numbers = new HashMap<>();
        int count = 0;
        int six = 0;
        int result = 0;

        String room = scan.nextLine();

        for (char c : room.toCharArray()) {
            if (c == '9') {
                c = '6';
            }
            count = numbers.getOrDefault(c, 0);
            numbers.put(c, count+1);
        }

        six = numbers.getOrDefault('6', 1);
        if (six != 1) {
            if (six % 2 == 1) {
                numbers.put('6', (six / 2) + 1);
            } else {
                numbers.put('6', six / 2);
            }
        }

        for (int val : numbers.values()) {
            result = Math.max(result, val);
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
