import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        int T = scan.nextInt();

        Deque<Balloon> balloons = new ArrayDeque<>();

        for(int i = 0; i < T; i++) {
            balloons.add(new Balloon(i+1, scan.nextInt()));
        }

        int move = balloons.getFirst().num;
        sb.append(balloons.pollFirst().idx).append(' ');

        while(!balloons.isEmpty()) {
            if(move > 0) {
                for(int i = 0; i < move - 1; i++) {
                    balloons.add(balloons.poll());
                }

                Balloon next = balloons.poll();
                move = next.num;
                sb.append(next.idx).append(' ');
            }
            else {
                for(int i = 0; i < -move - 1; i++) {
                    balloons.addFirst(balloons.pollLast());
                }

                Balloon next = balloons.pollLast();
                move = next.num;
                sb.append(next.idx).append(' ');
            }
        }
        print();
    }






//        int move;
//        int cur = 0;
//        int temp;
//        HashMap<Integer, Integer> targets = new HashMap<>();
//        List<Integer> balloons = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//
//        for (int i = 0; i < T; i++) {
//            targets.put(i+1, scan.nextInt());
//            balloons.add(i + 1);
//        }
//
//        result.add(balloons.remove(0));
//
//        for(int i = 0; i < T-1; i++) {
//            move = targets.get(result.get(result.size() - 1));
//
//            cur += move;
//
//            while (cur >= balloons.size()) {
//                cur -= balloons.size();
//            }
//
//            while (cur < 0) {
//                cur += balloons.size();
//            }
//
//            result.add(balloons.remove(cur));
//        }



//        for(int i = 0; i < T - 1; i++) {
//            move = targets.get(result.get(result.size() - 1));
//            cur += move;
//            while(cur >= balloons.size()) {
//                cur -= balloons.size();
//            }
//
//            while(cur < 0) {
//                cur += balloons.size();
//            }
//
//            temp = balloons.get(cur);
//            while(result.contains(temp)) {
//                if(move >= 0) {
//                    cur++;
//                } else {
//                    cur--;
//                }
//                while(cur >= balloons.size()) {
//                    cur -= balloons.size();
//                }
//                while(cur < 0) {
//                    cur += balloons.size();
//                }
//                temp = balloons.get(cur);
//            }
//            result.add(temp);
//            balloons.remove(temp2);
//            temp2 = cur;
//        }


//        1 2 3 4 5
//        이동, 삭제
//        2 3 4 5
//        2 3 5
//        2 3
//        2

//        System.out.println(targets);
//        System.out.println(balloons);

//        while (!balloons.isEmpty()) {
//            if (idx >= balloons.size()) {
//                idx -= balloons.size();
//            } else if (idx < 0) {
//                idx = balloons.size() + idx;
//            }
//
//            result.add(balloons.remove(idx));
//            idx += targets.remove(idx);
//        }


//        for(int answer : result) {
//            sb.append(answer).append(' ');
//        }
//
//        print();


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

class Balloon {
    int idx;
    int num;

    public Balloon(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
