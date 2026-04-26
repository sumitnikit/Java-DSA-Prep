package Phase_Two.Day11;

import java.io.*;
import java.util.*;

public class Unique {
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
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        String s = next();
        long ans =0;
        for(char c='a'; c<='z'; c++){
            int prev =-1;
            int next =-1;
            int count =0;
            int curr =s.length();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)==c){
                    count++;
                    if(count>1){
                        next =i;
                        ans += (next-curr)*(curr-prev);

                        prev =curr;
                        curr=next;

                    }else{
                        curr =i;
                    }
                }
            }
            
                ans+=(s.length()-curr)*(curr-prev);
            
            
        }
        sb.append(ans).append("\n");
    }
}
