package ZInterestingIdeas;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1_000_000_007L;

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

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        // int n= nextInt();
        // String[] s = new String[n];
        // for(int i=0; i<n; i++){
        // s[i]=nextLine();
        // }
        // for(int i =n-1; i>=0; i--){
        // sb.append("hi "+s[i]).append("\n");
        // }
        // double pi = Math.acos(-1);
        // double res = (pi)*n*n;
        // //sb.append(res);
        // String ans = String.format("%.9f",res);
        // sb.append(ans);
        // String s = next();
        // char ch = s.charAt(0);
        // sb.append(97 - ch);
        // sb.append(ch);
        // sb.append(98-'a');
        // sb.append(98-'0');
        // double x = nextDouble();
        // double y = nextDouble();
        // double a = nextDouble();
        // double b = nextDouble();
        // if (power(x, y) > power(a, b)) {
        //     sb.append("yes").append(power(x, y) + power(a, b));
        // } else {
        //     sb.append("yes").append(power(x, y) ).append(" " +power(a, b));
        //     sb.append("no");
        // }
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();
        double d = nextDouble();
        if(b*Math.log(a)>c*Math.log(d)){
            
        }

    }

    // private static Double power(double x, double y) {
    //     if(y==0)return 1.0;
    //     double temp = power(x,y/2);
    //     temp*=temp;
    //     if(y%2==1){
    //         temp*=x;
    //     }
    //     return temp;
    // }
}
