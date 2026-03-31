package NumberTheory;

import java.io.*;
import java.util.*;

public class CubeNumber {
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
    static final int[] spf = new int[1000010];

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
        pre();
        int t = 1;       // change to nextInt() for multiple test cases
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n =nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = nextInt();
        }
        Map<String,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i:arr){
            Map<Integer,Integer> freq = new HashMap<>();
            while(i>1){
                int count =0;
                int x =spf[i];
                while(i%x==0){
                    i/=x;
                    count++;
                }
                count%=3;
                if(count!=0)freq.put(x, count);
                
            }
            StringBuilder key = new StringBuilder();
            StringBuilder compliment = new StringBuilder();
            List<Integer> primes = new ArrayList<>(freq.keySet());
            Collections.sort(primes);
            for(int keys:primes){
                key.append(keys).append("^").append(freq.get(keys)).append("#");


                compliment.append(keys).append("^").append(3-freq.get(keys)).append("#");

            }
            ans+=map.getOrDefault(compliment, 0);
            map.put(key.toString(),map.getOrDefault(key, 0)+1);

        }

    }
    static void pre(){
        for(int i=1; i<=1000000; i++){
            spf[i]=i;
        }
        for(int i=2; i*i<=1000000; i++){
            if(spf[i]==i){
                for(int j=i*i; j<=1000000; j+=i){
                    if(spf[j]==j)spf[j]=i;
                }
            }
        }
    }
}
