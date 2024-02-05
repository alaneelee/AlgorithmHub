import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static void input() throws Exception {
        String text = scan.nextLine();
        int T = scan.nextInt();
        String command;

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : text.toCharArray()) {
            stack1.push(c);
        }

        for (int i = 0; i < T; i++) {
            command = scan.next();

            switch (command) {
                case "L":
                    if(!stack1.isEmpty()) stack2.push(stack1.pop());
                    break;
                case "D":
                    if(!stack2.isEmpty()) stack1.push(stack2.pop());
                    break;
                case "B":
                    if(!stack1.isEmpty()) stack1.pop();
                    break;
                case "P":
                    char newChar = scan.next().charAt(0);
                    stack1.push(newChar);
                    break;
            }
        }

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        for(char c : stack1) {
            sb.append(c);
        }

        print();

//        LinkedList<Character> list = new LinkedList<>();
//
//
//        for(char c : text.toCharArray()) {
//            list.add(c);
//        }
//
//        int idx = list.size();
//
//        for(int i = 0; i < T; i++) {
//            command = scan.next();
//
//            switch (command) {
//                case "L" :
//                    if(idx > 0) idx--;
//                    break;
//                case "D" :
//                    if(idx < list.size()) idx++;
//                    break;
//                case "B" :
//                    if(idx > 0) {
//                        list.remove(idx-1);
//                        idx--;
//                    }
//                    break;
//                case "P" :
//                    char newChar = scan.next().charAt(0);
//                    list.add(idx, newChar);
//                    idx++;
//                    break;
//            }
//        }
//
//        for(Character c : list) {
//            sb.append(c);
//        }
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
