/*Time Limit : 
1 sec
Memory Limit : 
256000 MB
Description
Given two numbers 
N
N, 
Q
Q and a string 
S
S of size 
N
N, followed by 
Q
Q lines of the following queries:

pop_back : remove the last character in the string.
front : print the first character in the string.
back : print the last character in the string.
sort 
l
l 
r
r : where 
1
≤
l
,
r
≤
∣
S
∣
1≤l,r≤∣S∣, sort all characters of 
S
S from 
l
l to 
r
r.
reverse 
l
l 
r
r : where 
1
≤
l
,
r
≤
∣
S
∣
1≤l,r≤∣S∣, reverse all characters of 
S
S from 
l
l to 
r
r.
print 
p
o
s
pos : where 
1
≤
p
o
s
≤
∣
S
∣
1≤pos≤∣S∣, print the character at index 
p
o
s
pos.
substr 
l
l 
r
r : where 
1
≤
l
,
r
≤
∣
S
∣
1≤l,r≤∣S∣, print substring of 
S
S from 
l
l to 
r
r.
push_back 
x
x : add character 
x
x to the end of the string.
Note: If 
l
>
r
l>r, then swap them.

For each query, print the answer associated with it in a single line.

It's guaranteed that in the first 7 types of queries, the string is not empty.

It's recommended to use built-in string functions.

Input Format
The first line contains two integers 
N
N, 
Q
Q, where 
N
N denotes the size of the string and 
Q
Q the number of queries.
The second line contains the string 
S
S consisting of only lowercase English letters.
Next 
Q
Q lines contain the queries.

Output Format
For each query, print the answer associated with it in a single line. If a query does not require an output, do not print anything.

Constraints
1
≤
N
,
Q
≤
1
0
3
1≤N,Q≤10 
3
 

Sample Input 1
18 8
assiutinupperegypt
substr 1 6
sort 5 8
pop_back
back
reverse 1 6
front
push_back i
print 4
Sample Output 1
assiut
p
n
s
Sample Input 2
10 5
algozenith
sort 5 8
reverse 3 6
sort 2 5
push_back a
substr 1 10
Sample Output 2
aeilognzth
Sample Input 3
10 8
algozenith
substr 5 6
sort 5 8
pop_back
back
reverse 5 6
front
push_back a
print 5
Sample Output 3
ze
t
a
i
Note
Test Case 1: After performing the queries:

substr 1 6 outputs "assiut".
sort 5 8 sorts characters from position 5 to 8.
pop_back removes the last character of the string.
back outputs the last character, which is 'p'.
reverse 1 6 reverses characters from position 1 to 6.
front outputs the first character, which is 'n'.
push_back i adds 'i' to the end of the string.
print 4 outputs the character at position 4, which is 's'.
Test Case 2: After performing the queries:

substr 5 6 outputs "ze".
sort 5 8 sorts characters from position 5 to 8.
pop_back removes the last character of the string.
back outputs the last character, which is 't'.
reverse 5 6 reverses characters from position 5 to 6.
front outputs the first character, which is 'a'.
push_back a adds 'a' to the end of the string.
print 5 outputs the character at position 5, which is 'i'.
Test Case 3: After performing the queries:

sort 5 8 sorts characters from position 5 to 8.
reverse 3 6 reverses characters from position 3 to 6.
sort 2 5 sorts characters from position 2 to 5.
push_back a adds 'a' to the end of the string.
substr 1 10 outputs the substring from position 1 to 10. */

package String;

import java.io.*;
import java.util.*;

public class StringFunctions {
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
        int n = nextInt();
        int q = nextInt();
        String s = next();
        while (q-- > 0) {
            String s1 = next();
            if ("pop_back".equals(s1)) {
                s = s.substring(0, s.length() - 1);
            } else if ("front".equals(s1)) {
                sb.append(s.charAt(0)).append("\n");
            } else if ("back".equals(s1)) {
                sb.append(s.charAt(s.length()-1)).append("\n");
            } else if ("sort".equals(s1)) {
                int l = nextInt();
                int r = nextInt();
                if(l>r){
                    int temp = l;
                    l = r;
                    r = temp;
                }
                char[] c = s.toCharArray();
                for (int i = l - 1; i < r; i++) {
                    for (int j = i + 1; j < r ; j++) {
                        if (c[i] > c[j]) {
                            char temp = c[i];
                            c[i] = c[j];
                            c[j] = temp;
                        }
                    }
                }
                s = String.valueOf(c);
            } else if ("reverse".equals(s1)) {
                int l = nextInt();
                int r = nextInt();
                if(l>r){
                    int temp = l;
                    l = r;
                    r = temp;
                }
                // char[] c = s.toCharArray();
                // while (l  <= r ) {
                    
                //     char temp = c[l - 1];
                //     c[l - 1] = c[r - 1];
                //     c[r - 1] = temp;
                //     l++;
                //     r--;
                // }
                // s = String.valueOf(c);
                s = s.substring(0, l-1) + new StringBuilder(s.substring(l-1, r)).reverse() + s.substring(r);
            } else if ("print".equals(s1)) {
                int pos = nextInt();
                sb.append(s.charAt(pos - 1)).append("\n");
            } else if ("substr".equals(s1)) {
                int l = nextInt();
                int r = nextInt();
                if(l>r){
                    int temp = l;
                    l = r;
                    r = temp;
                }
                sb.append(s.substring(l - 1, r)).append("\n");
            } else if("push_back".equals(s1)) {
                char x = next().charAt(0);
                s += x;

            }
        }
    }
}
