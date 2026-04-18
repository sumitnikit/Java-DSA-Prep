package Phase_Two.Day8;

import java.io.*;
import java.util.*;

public class CollectionSearching {
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
        int t = nextInt(); // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        int n = nextInt();
        int q = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        while (q-- > 0) {
            String t = next();
            int x = nextInt();
            // if ('1' == t.charAt(0)) {
            //     int idx = Arrays.binarySearch(arr, x);
            //     if (idx >= 0) {
            //         sb.append(arr[idx]).append(" ");
            //     } else {
            //         int k = -idx-1;
            //         sb.append(arr[k]).append(" ");
            //     }
            // } else if ('2' == t.charAt(0)) {
            //     int idx = Arrays.binarySearch(arr, x);
            //     if (idx >= 0) {
            //         while (idx < n && arr[idx] == x)
            //             idx++;
            //         sb.append(arr[idx]).append(" ");
            //     } else {
            //         sb.append(arr[-idx - 1]).append(" ");
            //     }
            // } else if ('3' == t.charAt(0)) {
            //     int idx = Arrays.binarySearch(arr, x);
            //     if (idx >= 0) {
            //         while (idx < n && arr[idx] == x)
            //             idx++;
            //         sb.append(idx).append(" ");
            //     } else {
            //         sb.append(-idx - 1).append(" ");
            //     }
            // } else {
            //     int idx = Arrays.binarySearch(arr, x);
            //     if (idx >= 0) {
            //         while (idx > 0 && arr[idx-1] == x)
            //             idx--;
            //         sb.append(idx).append(" ");
            //     } else {
            //         sb.append(-idx - 1).append(" ");
            //     }
            // }
            if ('1' == t.charAt(0)) {
               int y = lowerBound(arr,x);
               if(y==arr.length)sb.append("-1 ");
               else sb.append(arr[y]).append(" ");
            } else if ('2' == t.charAt(0)) {
                int y = upperBound(arr,x);
                if(y==arr.length)sb.append("-1 ");
                else sb.append(arr[y]).append(" ");
            } else if ('3' == t.charAt(0)) {
                int y = upperBound(arr,x);
               sb.append(y).append(" ");
            } else {
                int y = lowerBound(arr,x);
               sb.append(y).append(" ");
            }
        }
        sb.append("\n");
    }

   static int upperBound(int[] arr, int x){
        int l =0;
        int r =arr.length;
        
        while(l<r){
            int mid = (l+r-1)/2;
            if(arr[mid]<=x)l=mid+1;
            else r=mid;
        }
        return l;
    }

    static int lowerBound(int[] arr, int x){
        int l =0;
        int r =arr.length;
        
        while(l<r){
            int mid = (l+r-1)/2;
            if(arr[mid]<x)l=mid+1;
            else r=mid;
        }
        return l;
    }

    
}