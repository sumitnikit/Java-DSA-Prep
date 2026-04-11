package Phase_Two.Day5;

import java.io.*;
import java.util.*;

public class Set {
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
        int q = nextInt();
        Set<Integer> st = new TreeSet<>();
        while(q-->0){
            String s = next();
            if(s.equals("add")){
                int x = nextInt();
                st.add(x);
            }else if(s.equals("remove")){
                int x = nextInt();
                st.remove(x);
            }else if(s.equals("find")){
                int x = nextInt();
                int y= st.size();
                st.add(x);
                if(y==st.size())sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }else if(s.equals("print")){
                int x = nextInt();
                
                    for(int t :st){
                        sb.append(t).append(" ");
                    }
                    sb.append("\n");
                
                
            }else{
                st.clear();
            }
        }
    }
}
