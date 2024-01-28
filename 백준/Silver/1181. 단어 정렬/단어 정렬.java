import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        int maxWord = 0;

        for(int i = 0; i < T; i++) {
            words.add(scan.nextLine());
        }

        Collections.sort(words);

        for(String word : words) {
            maxWord = Math.max(maxWord, word.length());
        }

        for(int i = 1; i <= maxWord; i++) {
            for(String word : words) {
                if(word.length() == i && !result.contains(word)) {
                    result.add(word);
                    sb.append(word).append("\n");
                }
            }
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
