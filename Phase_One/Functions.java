import java.io.*;
import java.util.*;

public class Functions {
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
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int m = nextInt();
        int[] a = new int[m];
        int[][] b = new int[m][2];
        for(int i=0; i<m; i++){
            a[i] = nextInt();
        }
        for(int i=0; i<m; i++){
            b[i][0] = nextInt();
            b[i][1] = i;
        }

        Arrays.sort(a);
        Arrays.sort(b,(x,y)->(x[0]- y[0]));
        int[] c = new int[m];
       
        for(int i=0;i<m; i++){
            c[b[m-1-i][1]] = a[i];
        }
        for(int i=0;i<m; i++){
            sb.append(c[i]).append(" ");
        }
        sb.append("\n");
        
    }
}
