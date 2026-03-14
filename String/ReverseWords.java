/*Time Limit : 
1 sec
Memory Limit : 
256000 KB
Description
Given a string 
S
S. For each word in 
S
S, reverse its letters then print it.

Note: Words are separated by spaces. If there are multiple spaces between the words, then you need to remove them.

Example : word1 word2 word3
output : reverseword1 reverseword2 reverseword3

Input Format
One line contains a string 
S
S.

Output Format
Print the answer required above.

Constraints
1
≤
∣
S
∣
≤
1
0
6
1≤∣S∣≤10 
6
 , where 
∣
S
∣
∣S∣ is the length of the string.
The string consists of lowercase and uppercase English letters and spaces.

Sample Input 1
I love you
Sample Output 1
I evol uoy
Sample Input 2
We are a happy family
Sample Output 2
eW era a yppah ylimaf
Sample Input 3
You love me
Sample Output 3
uoY evol em
Note
In each test case, each word in the input string is reversed individually, and the words are printed in the same order separated by spaces. */

package String;

import java.io.*;
import java.util.*;

public class ReverseWords {
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
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }
    static double nextDouble() throws IOException { return Double.parseDouble(next()); }
    static String nextLine() throws IOException {
        st = null;
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        out.print(sb);
        out.flush();
    }

    static void solve() throws Exception {
        String s = nextLine();
        String[] y = s.trim().split("\\s+");
       // String m ="";
        for(String x : y){
            sb.append(new StringBuilder(x).reverse()).append(" ");
           // m += new StringBuilder(x).reverse().append(" ").toString();
        }
        
    }
}
