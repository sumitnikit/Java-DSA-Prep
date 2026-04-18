package Phase_Two.Day9;

import java.io.*;
import java.util.*;

public class CheckBalanced {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD  = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int  INF  = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // Local testing — change to false before submitting!
    static final boolean LOCAL = true;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static char nextChar() throws IOException { return next().charAt(0); }
    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        String s = next();
        //Deque<Character> dq = new ArrayDeque<>();
        // for(int i=0; i<s.length(); i++){
            // if(s.charAt(i)=='(')dq.add(s.charAt(i));
            // if(s.charAt(i)==')'){
            //     if(dq.size()==0){
            //         sb.append("NO\n");
            //     return;
            // }
            //     else dq.poll();
            // }
        // }
        // if(dq.size()==0)sb.append("YES\n");
        // else  sb.append("NO\n");
        int depth =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')depth++;
            else depth--;
            if(depth<0){
                sb.append("NO\n");
                return;
            }
        }
        if(depth==0)sb.append("YES\n");
        else sb.append("NO\n");
    }
}
