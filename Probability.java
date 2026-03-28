import java.io.*;
import java.util.*;

public class Probability {
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
    static final double[] fact = new double[11];

    // Local testing — change to false before submitting!
    static final boolean LOCAL = false;

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
            br = new BufferedReader(new FileReader("input.txt"));
        }
        pre();
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        String s = next();
        String sr = next();
        int plus = 0;
        int minus =0;
        int q = 0;
        double ans1 =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='+')plus++;
            else minus++;
        }
        for(int i=0; i<sr.length(); i++){
            if(sr.charAt(i)=='+')plus--;
            else if(sr.charAt(i)=='-')minus--;
            else q++;
        }
        if (q == 0) {
            if (plus == 0 && minus == 0) {
                sb.append("1.000000000000\n");
            } else {
                sb.append("0.000000000000\n");
            }
            return;
        }
        
        if (plus < 0 || minus < 0 || plus + minus != q) {
            sb.append("0.000000000000\n");
            return;
        }
        
        int max = Math.max(plus, minus);
        ans1 =(fact[q]/(fact[max]*fact[q-max]))/twoq(q);
        sb.append(String.format("%.12f",ans1)).append("\n");

    }
    private static void pre(){
        fact[0]=1;
        fact[1]=1;
        for(int i=2; i<11; i++){
            fact[i]=i*fact[i-1];
        }
    }
    private static double twoq(int q){
        double ans =1;
        while(q>0){
            ans*=2;
            q--;
        }
        return ans;
    }
}