package Phase_Two.Day2;

import java.io.*;
import java.util.*;

public class QwithtwoSt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int INF = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // Local testing — change to false before submitting!
    static final boolean LOCAL = true;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char nextChar() throws IOException {
        return next().charAt(0);
    }

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = nextInt(); // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int q = nextInt();
        ImpQ qu = new ImpQ();
        while (q-- > 0) {
            String s = next();
            if (s.equals("push")) {
                int x = nextInt();
                qu.push1(x);
            } else if (s.equals("pop")) {
                qu.pop1();
            } else {
                qu.front1();
            }
        }
    }

    static class ImpQ {
        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        public void push1(int x) {
            st1.push(x);
        }
        public void pop1() {
            if(st2.isEmpty()){
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
            }
            if(!st2.isEmpty()){
                sb.append(st2.peek()).append("\n");
            st2.pop();
            }
            
        }
        public void front1() {
            if(st2.isEmpty()){
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
            }
            if(!st2.isEmpty()){
                sb.append(st2.peek()).append("\n");
            }
        }
    }
}
