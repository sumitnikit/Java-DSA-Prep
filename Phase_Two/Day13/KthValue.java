package Phase_Two.Day13;

import java.io.*;
import java.util.*;

public class KthValue {
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
        int n=nextInt();
        int m = nextInt();
        int q = nextInt();
        long[] arr = new long[n+3];
        long[] brr = new long[n+3];
        for(int i=1; i<=n; i++){
            arr[i]=nextInt();
        }
        while(m-->0){
            int li =nextInt();
            int ri = nextInt();
            brr[li]++;
            brr[ri+1]--;
        }
        for(int i=1; i<=n; i++){
            brr[i]+=brr[i-1];
        }
       Roll[] freq1 = new Roll[n];
       for(int i=0; i<n; i++){
       freq1[i] = new Roll(arr[i+1], brr[i+1]);
    }
    Arrays.sort(freq1,new Comparator<Roll>() {
        public int compare(Roll a,Roll b){
            return Long.compare(a.num, b.num);
        }
    });
    for(int i=1; i<n; i++){
        freq1[i].freq+=freq1[i-1].freq;
     }
        while(q-->0){
            long k = nextLong();
            int idk = lowerbound(freq1,k,n);
            if(idk>=n)sb.append("-1 ");
            else sb.append(freq1[idk].num).append(" ");
        }
        sb.append("\n");
    }
    static int lowerbound(Roll[] freq1,long k,int n){
        int l=0;
        int r =n;
        while(l<r){
            int mid = (l+r-1)/2;
            if(freq1[mid].freq<k)l=mid+1;
            else r=mid;
        }
        return l;
    }
    static class Roll{
        long num;
        long freq;
        Roll(long num, long freq){
            this.num = num;
            this.freq = freq;
        }
    }
    
}
 
