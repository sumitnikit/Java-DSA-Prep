package Phase_Two.Day15;

import java.io.*;
import java.util.*;

public class CarANdPetrolUsingMAP {
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
        int n = nextInt();
        int[] p = new int[n];
        int[] r = new int[n];
        int[] c = new int[n];
    
        for(int i=0; i<n; i++) p[i] = nextInt();
        for(int i=0; i<n; i++) r[i] = nextInt();
        for(int i=0; i<n; i++) c[i] = nextInt();
    
        long dol = 0;
    
        TreeMap<Integer, Long> map = new TreeMap<>();
    
        for(int i=0; i<n-1; i++){
    
            // add current petrol pump
            map.put(p[i], map.getOrDefault(p[i], 0L) + c[i]);
    
            int cover = r[i];
    
            while (!map.isEmpty() && cover > 0) {
                int price = map.firstKey();
                long available = map.get(price);
    
                if(available <= cover){
                    dol += available * price;
                    cover -= available;
                    map.remove(price);
                } else {
                    dol += 1L * cover * price;
                    map.put(price, available - cover);
                    cover = 0;
                }
            }
    
            if(cover > 0){
                sb.append("-1\n");
                return;
            }
        }
    
        sb.append(dol).append("\n");
    }
}
