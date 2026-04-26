package Phase_Two.Day10;

import java.io.*;
import java.util.*;

public class Cards {
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
        int n = nextInt();
        Card[] c = new Card[n];
        for(int i =0; i<n; i++){
            c[i] = new Card(nextInt(), 0);
        }
        for(int i =0; i<n; i++){
            c[i].b =nextInt();
        }

        Arrays.sort(c,new Comparator<Card>() {
            public int compare(Card a, Card b){
                return Integer.compare(a.a+a.b, b.a+b.b);
            }
        });
        long resA =0;
        long resB=0;
        for(int i =0; i<n; i++){
            if((i&1)==1){
                resB+=c[i].b;
            }else{
                resA+=c[i].a;
            }
        }
        if(resA>resB){
            sb.append("Alice\n");
        }else if(resA<resB){
            sb.append("Bob\n");
        }else{
            sb.append("Tie\n");
        }
    }
    static class Card{
        int a;
        int b;
        Card(int a,int b){
            this.a =a;
            this.b =b;
        }
    }
}
