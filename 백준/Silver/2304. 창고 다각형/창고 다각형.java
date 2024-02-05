import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class Column {
    int idx;
    int height;

    public Column(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();
        int max = 0;
        int result = 0;
        int maxIdx = 0;

        ArrayList<Column> columns = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            columns.add(new Column(scan.nextInt(), scan.nextInt()));
        }

        columns.sort((c1, c2) -> c1.idx - c2.idx);


        for(Column c : columns) {
            max = Math.max(max, c.height);
        }

        Column curColumn = columns.get(0);
        Column nextColumn;

        for(int i = 1; i < columns.size(); i++) {
            nextColumn = columns.get(i);

            if (curColumn.height <= nextColumn.height) {
                result += (nextColumn.idx - curColumn.idx) * curColumn.height;
                curColumn = nextColumn;
                maxIdx = i;
            }
        }

        curColumn = columns.get(columns.size() - 1);

        for(int i = 1; i < columns.size() - maxIdx; i++) {
            nextColumn = columns.get(columns.size() - 1 - i);
            if (curColumn.height <= nextColumn.height) {
                result += (curColumn.idx - nextColumn.idx) * curColumn.height;
                curColumn = nextColumn;
            }
        }

        result += columns.get(maxIdx).height;

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
