package Phase_Two.Day15;

import java.io.*;
import java.util.*;

public class FractionsWithClassHashMap {
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
        int n= nextInt();
        int[] arr = new int[n];
        Map<Pair,Integer> map = new HashMap<>();
        long ans =0;
        for(int i=0; i<n; i++){
            arr[i]= nextInt();
           ans += map.getOrDefault(reduced(arr[i], i), 0);
            map.put(reduced(arr[i], i),  map.getOrDefault(reduced(arr[i], i), 0)+1);

        }
        sb.append(ans);
        // Map<int[],Integer> map = new HashMap<>();
        // int ans =0;
        // for(int i=0; i<n; i++){
        //    ans+=map.getOrDefault(reduced(new int[]{arr[i],i}), 0);
        //     map.put(reduced(new int[]{arr[i],i}), map.getOrDefault(reduced(new int[]{arr[i],i}), 0)+1);
        // }
        // sb.append(ans);
    }
    static Pair reduced(long a, long b){
        if(a==0&& b==0)return new Pair(0, 0);
        if(b==0)return new Pair(1, 0);
        if(a==0)return new Pair(0, 1);
        long x = gcd(a,b);
        return new Pair(a/x, b/x);
    }
    static class Pair{
        long value;
        long index;
        Pair(long a, long b){
            this.value = a;
            this.index =b;
        }
        @Override
        public int hashCode(){
            return Objects.hash(value,index);
        }
        @Override
        public boolean equals(Object o){
            if(this==o)return true;
            if(!(o instanceof Pair)) return false;
            Pair p = (Pair)o;
            return this.value==p.value&& this.index==p.index;
        }
    }
    // static int[] reduced(int[] a){
    //     if(a[0]==0&&a[1]==0)return new int[]{0,0};
    //     if(a[0]==0)return new int[]{0,1};
    //     if(a[1]==0)return new int[]{1,0};
    //     int x = gcd(a[0],a[1]);
    //     a[0]/=x;
    //     a[1]/=x;
    //     return new int[]{a[0],a[1]};
    // }
    static long gcd(long a, long b){
        if(a==0||b==0)return a+b;
        return gcd(b,a%b);
    }
}
