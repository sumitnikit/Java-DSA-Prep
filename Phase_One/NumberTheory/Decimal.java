package NumberTheory;

import java.io.*;
import java.util.*;

public class Decimal {
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
        int t = nextInt();       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int num=nextInt();
        int den = nextInt();
        if(num==0){
            sb.append("0").append("\n");
            return;
        }
        String sign = "";
        if((num<0 || den<0) && !(num<0 && den<0) ){
            sign="-";
            if(num<0)num -= 2*num;
            else den -= 2*den;
        }
        if(num<0 && den<0){
            num -= 2*num;
            den -= 2*den;
        }
        int integerPart=num/den;
        int rem = num%den;
        // if(rem<0)rem +=den;
        if(rem==0){
            sb.append(sign).append(integerPart).append("\n");
            return;
        }
        StringBuilder afterD =new StringBuilder();
        int pos= 0;
        Map<Integer,Integer> mp = new HashMap<>();
        while(rem!=0){
            if(mp.containsKey(rem)){
                afterD.insert(mp.get(rem),"(");
                afterD.append(')');
                break;
            }
            mp.put(rem,pos);
            rem *=10;
            int toBeAdded = rem/den;
            rem = rem%den;
            afterD.append(String.valueOf(toBeAdded));
            pos++;

        }
        sb.append(sign).append(integerPart).append(".").append(afterD).append("\n"); 
        
    }
}
