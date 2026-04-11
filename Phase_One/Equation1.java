import java.io.*;
import java.util.*;

public class Equation1 {
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
        String s = next();
        int sign =1;
        int signOfX =1;
        long ans=0;
        long ansONLhs=0;
        long ansONRhs=0;
        int i=0;
        int lhs=1;
        int rhs=-1;
        
        while(i<=s.length()){
            if(s.charAt(i)=='+'){
                sign =1;
                i++;
            }else if(s.charAt(i)=='-'){
                sign=-1;
                i++;
            }else if(s.charAt(i)=='X'){
                signOfX =sign;
                if(rhs==1){
                    lhs=-1;
                }
                i++;
            }else if(s.charAt(i)=='='){
                rhs=1;
                sign =1;
                i++;

            }else{
                 long sumonRhs =0;
                 long sumonLhs =0;
                 while(i<s.length() && Character.isDigit(i)){
                    if(rhs==1){
                        sumonRhs += 10*sumonRhs + (s.charAt(i)-'a');
                    }else{
                        sumonLhs += 10*sumonLhs + (s.charAt(i)-'a');
                    }
                    i++;
                 }
                 ansONLhs +=sign*sumonLhs;
                 ansONRhs +=sign*sumonRhs;

            }
             ans = ansONRhs-ansONLhs;
            if(lhs ==-1){
                ans = -1*signOfX*ans;
            }else{
                
            }
        }
    }
}
