package Phase_Two.Day7;

import java.io.*;
import java.util.*;
import java.util.Deque.*;

public class Deque {
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
            br = new BufferedReader(new FileReader("../input.txt"));
        }
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int q=nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        while(q-->0){
            String s = next();
            if(s.equals("insertback")){
                int x = nextInt();
                dq.offerLast(x);
               
            }else if(s.equals("eraseback")){
                dq.pollLast();
            }else if(s.equals("insertfront")){
                int x = nextInt();
                dq.offerFirst(x);
            }else if(s.equals("erasefront")){
                dq.pollFirst();
            }else if(s.equals("printfront")){
                sb.append(dq.peekFirst()).append("\n");
            }else if(s.equals("printback")){
                sb.append(dq.peekLast()).append("\n");
            }else{
                int count =0;
                int x = nextInt();
                if(x>=dq.size())sb.append(0).append("\n");
                for(int t:dq){
                    count++;
                    if(count==x+1){
                        sb.append(t).append("\n");
                        break;
                    }
                    
                }
                
            }
        }
    }
}
