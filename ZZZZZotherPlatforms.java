import java.io.*;
import java.util.*;

public class ZZZZZotherPlatforms {
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
    static final boolean LOCAL = false;

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
            br = new BufferedReader(new FileReader("input.txt"));
        }
        int t = nextInt(); // change to nextInt() for multiple test cases
        while (t-- > 0)
            solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        // int n =nextInt();
        // // long ans = binPow(2,n+1);
        // // sb.append(ans-2);
        // long[] arr = new long[n];
        // long min = Long.MAX_VALUE;
        // long max =Long.MIN_VALUE;
        // long countMax =0;
        // long countMin=0;
        // for(int i=0; i<n; i++){
        // arr[i] = nextLong();
        // if(arr[i]==min)countMin++;
        // if(arr[i]==max)countMax++;
        // if(min>arr[i]){
        // countMin=1;
        // min = arr[i];
        // }
        // if(max<arr[i]){
        // countMax=1;
        // max=arr[i];
        // }
        // }
        // if(max==min){
        // sb.append(max-min).append(" ").append(countMax*(countMin-1)/2);
        // return;
        // }
        // sb.append(max-min).append(" ").append(countMin*countMax);
        // String s = next();
        // int ans = 0;

        // char one = s.charAt(0);
        // ans += 25 * (one - 'a');

        // char two = s.charAt(1);
        // if(two>one){
        //     ans += two-'a';
        // }else{
        //     ans+= two-'a'+1;
        // }
        // sb.append(ans).append("\n");
        // int totaldays = nextInt();
        // int minDays = nextInt();
        // int max_temp = nextInt();
        // int[] arr = new int[totaldays];
        // for(int i =0; i<totaldays; i++){
        //     arr[i] = nextInt();
            
        // }
        // long count =0;
        // long length =0;
        // for(int i =0; i<totaldays; i++){
        //     length++;
        //     if(arr[i]>max_temp){
        //         if(length>=minDays){
        //             count +=(((length-1)-minDays+1)*((length-1)-minDays+2))/2;
        //         }
        //         length=0;
        //     }
        // }
        // if(length>=minDays){
        //     count+=(((length)-minDays+1)*((length)-minDays+2))/2;
        // }
        // sb.append(count).append("\n");

        //A. Pasha and Stick
        // int n = nextInt();
        // if((n&1)==1){
        //     sb.append(0);
        //     return;
        // }
        // sb.append((((n+2)/2)/2)-1);

        // long n = nextInt();
        // long ans = binPow(27,n)-binPow(7,n);
        // sb.append(((ans%MOD)+MOD)%MOD).append("\n");
        
        //broken Keyboard
        // int n = nextInt();
        // int k = nextInt();
        // String s = next();
        // int[] freq =new int[26];
        // char[] latinW =new char[k];
        // for(int i=0; i<n; i++){
        //     freq[s.charAt(i)-'a'] =0;
        // }
        // for(int i=0; i<k; i++){
        //     latinW[i] = next().charAt(0);
        //     freq[latinW[i]-'a']=1;
        // }
        // long count =0;
        // long length =0;
        // for(int i=0; i<n; i++){
        //     length++;
        //     if(freq[s.charAt(i)-'a'] == 0){
        //         count+=(length-1)*(length)/2;
        //         length=0;
        //     }
            
        // }
        // if(length>0)count+=(length+1)*(length)/2;;
        // sb.append(count).append("\n");


        // long participants=nextLong();
        // long teams = nextLong();
        // long minInATeam = participants/teams;
        // long rem = participants%teams;
        // long min =rem*((minInATeam+1)*minInATeam/2)+(teams-rem)*(minInATeam*(minInATeam-1)/2);

        // long max = (participants-teams+1)*(participants-teams)/2;
        // sb.append(min).append(" ").append(max).append("\n");

        int n =nextInt();
        int k = nextInt();
        char[] c = new char[n];
        Arrays.fill(c, 'a');
        int i=1;
        while(i<k){
            k-=i;
            i++;
        }
        c[n-i-1] ='b';
        c[n-k] ='b';
        sb.append(new String(c)).append("\n");

    }

    // private static long binPow(long base, long power){
    //     long res =1;
    //     base %= MOD;
    //     while(power>0){
    //         if((power&1)==1){
    //             res = res*base%MOD;
    //         }
    //         base = base *base%MOD;
    //         power>>=1;
    //     }
    //     return res;
    // }

    // private static long binPow(long base, long power){
    // long result =1;

    // while(power>0){
    // if((power&1)==1){
    // result = result*base;
    // }
    // base = base*base;
    // power >>=1;
    // }
    // return result;
    // }
}
