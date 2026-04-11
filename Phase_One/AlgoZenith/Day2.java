package AlgoZenith;

import java.io.*;
import java.security.DrbgParameters.NextBytes;
import java.util.*;

public class Day2 {
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
        // int n = nextInt();
        // int x = nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = nextInt();
        // }
        // rightShift(x, n,arr);

        // int n = nextInt();
        // prime(n);

        // int a =nextInt();
        // int b = nextInt();
        // if(a>b){
        //     int temp =a;
        //     a=b;
        //     b=temp;
        // }
        // sum(a,b);

        int n  = nextInt();
        fib(n);
        
    }

    private static void fib(int n){
        if(n==0) {
            sb.append("0");
            return;
        }
        if(n==1) {
            sb.append("0"+" 1");
            return;
        }
        int atlast = 0;
        int currentSum =1;
        sb.append("0"+" 1 " );
        for(int i=2; i<n; i++){
            int nowSum =currentSum+atlast;
            sb.append(nowSum+" ");
            atlast=currentSum;
            currentSum=nowSum;
           
        
        
    }

    // private static void sum(int a, int b){
    //     int sum =0;
    //     for(int i=a+1; i<b; i++){
    //         if(i%2!=0)sum+=i;
    //     }
    //     sb.append(sum).append("\n");
    // }

    // private static void prime(int n) {
    //   for(int i=2; i<=n; i++){
    //     prime2(i);
    //   }
    // }
    // private static void prime2(int n) {
    //   for(int i=2; i<n; i++){
    //     if(n==2){
    //         sb.append(n+" ");
    //         return;
    //     }
    //     if(n%i==0){
    //         return;
    //     }
    //   }
    //   sb.append(n+" ");
    // }

    // private static void rightShift(int x, int n, int[] arr) {
    // int times = x % n;
    // int[] brr = new int[n];
    // for(int i=0; i<n; i++){
    // brr[(i+times)%n]= arr[i ];

    // }
    // for(int i=0; i<n; i++){
    // sb.append(brr[i]+" ");
    // }

    // }
}}