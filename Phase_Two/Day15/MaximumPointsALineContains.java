package Phase_Two.Day15;

import java.io.*;
import java.util.*;

public class MaximumPointsALineContains {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringBuilder sb = new StringBuilder();

    // Constants
    static final long MOD = 1_000_000_007L;
    static final long MOD2 = 998_244_353L;
    static final int INF = (int) 1e9;
    static final long LINF = (long) 1e18;
    static final double EPS = 1e-9;

    // Local testing — change to false before submitting!
    static final boolean LOCAL = true;

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

    static char nextChar() throws IOException {
        return next().charAt(0);
    }

    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        if (LOCAL) {
            br = new BufferedReader(new FileReader("../../input.txt"));
        }
        int t = 1; // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        
        long ans = 0;
        int[] brr =new int[n];
        int[] arr =new int[n];
        for(int i=0; i<n; i++){
            arr[i] = nextInt();
            brr[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            int same =0;
            Map<Long, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++){
                if( arr[i]!=arr[j] || brr[i] != brr[j]){
                    long key =reduced(brr[j]-brr[i], arr[j]-arr[i]);
                map.put(key, map.getOrDefault(key, 0)+1);
                }else{
                    same++;
                }
                
            }
            ans = Math.max(ans, same);
            for(Map.Entry<Long,Integer> mp : map.entrySet()){
                ans = Math.max(ans,same+ mp.getValue());
            }
            

        }
        sb.append(ans);

    }

    static long reduced(int a, int b) {
        if (a == 0 && b == 0)
            return (long) a << 32 | b & 0xFFFFFFFFL;
        
        int x = gcd(Math.abs(a), Math.abs(b));
        if(b<0){
            a=-a;
            b=-b;
        }
        return (((long) (a / x)) << 32 )| (b/x & 0xFFFFFFFFL);
    }

    static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return a + b;
        return gcd(b, a % b);
    }
}
