package AlgoZenith;

import java.io.*;
import java.util.*;

public class Day1 {
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
        // double x = nextDouble();
        // double y = nextDouble();

        // if (x == 0) {
        // if (y == 0) {
        // sb.append("origem");
        // return;
        // }
        // sb.append("xaxis");
        // return;
        // } else if (y == 0) {
        // sb.append("yaxis");
        // return;
        // } else if (x > 0) {
        // if (y > 0) {
        // out.println(y);
        // sb.append("q1");
        // return;
        // }
        // sb.append("q4");
        // return;
        // } else {
        // if (y > 0) {
        // sb.append("q2");
        // return;
        // }
        // sb.append("q3");
        // }

        // int ageInDays = nextInt();
        // int years = ageInDays/365;
        // int months= (ageInDays-(years*365))/30;
        // int days = ageInDays -(years*365) - (30*months);
        // sb.append(years + " years").append("\n");
        // sb.append(months + " months").append("\n");
        // sb.append(days + " days").append("\n");

        // int x1 = nextInt();
        // int y1 = nextInt();
        // int x2 = nextInt();
        // int y2 = nextInt();

        // if(x2>y2 || x1>y1 || x2>y1 ||y2<x1){
        // sb.append("-1").append("\n");
        // return;
        // }
        // int min = Math.min(x1,x2);
        // int max = Math.min(y1, y2);
        // sb.append(min+" "+max).append("\n");

        // int n = nextInt();
        // int even =0;
        // int odd =0;
        // int positive =0;
        // int negative =0;
        // for(int i=0; i<n; i++){
        // int x =nextInt();
        // if(x%2==0){
        // even++;
        // }else{
        // odd++;
        // }

        // if(x>0){
        // positive++;
        // }else if(x<0){
        // negative++;
        // }

        // sb.append(odd)

        // }

        // int n= nextInt();
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<n; i++){
        // int x = nextInt();
        // max =Math.max(max,x);
        // }

        // int a = nextInt();
        // int b = nextInt();
        // int cd = 1;
        // int max = Math.max(a, b);
        // int min = Math.min(a, b);
        // if ((max / min == 2 && max % min == 0) || max == min) {
        // cd = min;
        // sb.append(cd);
        // return;
        // }
        // int x = Math.min(max / 2 - 1, min);
        // for (int i = x; i > 0; i--) {

        // if (max % i == 0 && min % i == 0) {
        // // sb.append(cd);
        // if(cd%i!=0){
        // cd *= i;
        // }

        // }

        // }
        // sb.append(cd);
        // List<Integer> arr = new ArrayList<>();
        // List<Integer> brr = new ArrayList<>();

        // for(int i=1; i<=a/2; i++){
        // if(a%i==0){
        // arr.add(i);

        // }

        // }
        // sb.append(arr+"\n");
        // for(int i=1; i<=b; i++){
        // if(b%i==0){
        // brr.add(i);

        // }
        // b/=i;

        // }
        // sb.append(brr+"\n");
        // int k=0;
        // List<Integer> gcd = new ArrayList<>();
        // for(int i =0; i<arr.size(); i++){
        // for(int j=k; j<brr.size(); j++){
        // if(arr.get(i)==brr.get(j)){
        // gcd.add(brr.get(j));
        // k=j+1;
        // // sb.append(k+"");
        // }
        // }
        // }

        // for(int i: gcd){
        // cd *= i;
        // }
        // sb.append(cd);

        // String x = next();
        // sb.append(x.charAt(1));
        // int[] arr = new int[x.length()];
        // for(int i =1; i<=x.length(); i++){
        // arr[x.length()-i]=x.charAt(i-1)-'0';
        // }

        // for(int i =1; i<=x.length(); i++){
        // sb.append(arr[i-1]+" ");
        // }
        // sb.append("\n");
        int a = nextInt();
        int b = nextInt();
        for (int i = a; i <= b; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
              
                if (((temp.charAt(j)-'0') /4!=1 || (temp.charAt(j)-'0') %4!=0) && ((temp.charAt(j)-'0') /7!=1 || (temp.charAt(j)-'0') %7!=0)) {
                    
                    break;
                }
                
                if (j == temp.length()-1) {

                    sb.append(temp + " ");
                }
            }

            if (i == b) {

                if (sb.isEmpty()) {
                    sb.append("-1");
                }
            }
        }

    }

}
