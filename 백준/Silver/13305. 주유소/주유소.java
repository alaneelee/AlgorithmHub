import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int N = scan.nextInt();
        int distance;
        int totalDistance = 0;
        int[] km = new int[N];
        int[] city = new int[N];
        int oil = 0;
        int cur;
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            distance = scan.nextInt();
            km[i] = distance;
            totalDistance += distance;
        }

        km[N - 1] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            city[i] = scan.nextInt();
        }

        city[N-1] = Integer.MAX_VALUE;

        cur = km[0];
        oil = city[0];

        for (int i = 0; i < km.length - 1; i++) {
            if(city[i] < city[i+1]) {
                cur += km[i + 1];
            } else {
                answer += cur * oil;
                totalDistance -= cur;
                oil = city[i + 1];
            }
        }

        answer += totalDistance * oil;

        System.out.println(answer);

        // 첫번째 도시에서는 무조건 다음 도시에 가는 거리만큼 기름을 구매
        // 만약 첫번째 도시의 기름값이 가장 싸다면 전부 구매하면 됌
        // 만약 현재 도시 이후의 기름값이 더 싼 도시가 있다면 다음 도시로 갈 만큼의 기름만 구매
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
