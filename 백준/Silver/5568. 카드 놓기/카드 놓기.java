import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<String> nums = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            nums.add(scan.nextLine());
        }

        switch(k) {
            case 2:
                for (int i = 0; i < nums.size(); i++) {
                    for(int j = 0; j < nums.size(); j++) {
                        if (i == j) continue;
                        set.add(nums.get(i) + nums.get(j));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < nums.size(); i++) {
                    for(int j = 0; j < nums.size(); j++) {
                        if (i == j) continue;
                        for(int l = 0; l < nums.size(); l++) {
                            if (i == l) continue;
                            if (j == l) continue;
                            set.add(nums.get(i) + nums.get(j) + nums.get(l));
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; i < nums.size(); i++) {
                    for(int j = 0; j < nums.size(); j++) {
                        if (i == j) continue;
                        for(int l = 0; l < nums.size(); l++) {
                            if (i == l) continue;
                            if (j == l) continue;
                            for(int m = 0; m < nums.size(); m++) {
                                if (i == m) continue;
                                if (j == m) continue;
                                if (l == m) continue;
                                set.add(nums.get(i) + nums.get(j) + nums.get(l) + nums.get(m));
                            }
                        }
                    }
                }
                break;
        }

        System.out.println(set.size());
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
