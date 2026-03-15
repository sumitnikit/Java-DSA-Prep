/*8 Neighbors
Time Limit : 
1 sec
Memory Limit : 
256000 KB
Description
Given two numbers 
N
N and 
M
M, a 2D array 
A
A of size 
N
×
M
N×M which contains 'x' or '.' only and two numbers 
X
X, 
Y
Y which denote a cell position in 
A
A such that 
X
X is the row number and 
Y
Y is the column number.

Determine whether all neighbors of the given cell are 'x' or not.

Note: The neighbor cell is any cell that shares an edge or a corner and it should be inside the 2D array.

Input Format
The first line contains 
T
T, the number of test cases.
For each test case:
The first line contains two space-separated integers 
N
N and 
M
M.
N
N denotes number of rows, 
M
M denotes number of columns.
Next 
N
N lines contain 
M
M symbols.
Last line contains two space-separated integers 
X
X and 
Y
Y.

Output Format
Print "yes" if all neighbors of the given cell are 'x' otherwise, print "no" without quotations.

Constraints
1
≤
T
≤
10
1≤T≤10
1
≤
N
,
M
≤
100
1≤N,M≤100
A
[
i
]
∈
{
x
,
.
}
A[i]∈{x,.}
1
≤
X
≤
N
1≤X≤N
1
≤
Y
≤
M
1≤Y≤M

Sample Input 1
1
3 3
xxx
x.x
xxx
2 2
Sample Output 1
yes
Sample Input 2
2
3 3
xxx
x.x
xxx
2 2
3 3
xxx
xxx
xx.
2 2
Sample Output 2
yes
no
Note
In the first test case, the cell at position 
(
2
,
2
)
(2,2) (1-based indexing) is surrounded by 'x' in all its adjacent cells.
In the second test case:

First test case: The cell at position 
(
2
,
2
)
(2,2) is surrounded by 'x' in all its adjacent cells, so the output is "yes".
Second test case: The cell at position 
(
2
,
2
)
(2,2) has at least one neighbor which is '.', so the output is "no". */
package Array2D;

import java.io.*;
import java.util.*;

public class Neighbours8 {
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
        int m = nextInt();
        char[][] matrix = new char[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String row = next(); 
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = row.charAt(j-1); 
            }
        }

        int x = nextInt();
        int y = nextInt();

        int[] dx = {1,0,-1,-1,-1,0,1,1};
        int[] dy = {-1,-1,-1,0,1,1,1,0};

        for(int d=0; d<8; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>=0 && nx<=n && ny>=0 && ny<=m){
                if(matrix[nx][ny] == '.'){
                    sb.append("no").append("\n");
                    return;
                }
            }
        }
        sb.append("yes").append("\n");
        // if (x - 1 == 0) {
        // if (y - 1 == 0) {
        // if(!"x".equals(matrix[x][y]) || !"x".equals(matrix[x-1][y]) ||
        // !"x".equals(matrix[x][y-1])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else if (y + 1 > m) {
        // if(!"x".equals(matrix[x][y-1]) || !"x".equals(matrix[x-1][y-2]) ||
        // !"x".equals(matrix[x][y-2])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else {
        // if(!"x".equals(matrix[x][y-1]) || !"x".equals(matrix[x-1][y-2]) ||
        // !"x".equals(matrix[x][y-2]) || !"x".equals(matrix[x-1][y]) ||
        // !"x".equals(matrix[x][y])){
        // sb.append("no").append("\n");
        // return;
        // }
        // }
        // } else if (x + 1 > n) {
        // if (y - 1 == 0) {
        // if(!"x".equals(matrix[x-2][y-1]) || !"x".equals(matrix[x-1][y]) ||
        // !"x".equals(matrix[x-2][y])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else if (y + 1 > m) {
        // if(!"x".equals(matrix[x-1][y-2]) || !"x".equals(matrix[x-2][y-1]) ||
        // !"x".equals(matrix[x-2][y-2])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else {
        // if(!"x".equals(matrix[x-2][y-1]) || !"x".equals(matrix[x-1][y-2]) ||
        // !"x".equals(matrix[x-1][y]) || !"x".equals(matrix[x-2][y]) ||
        // !"x".equals(matrix[x-2][y-2])){
        // sb.append("no").append("\n");
        // return;
        // }
        // }
        // } else {
        // if (y - 1 == 0) {
        // if(!"x".equals(matrix[x-2][y-1]) || !"x".equals(matrix[x-1][y]) ||
        // !"x".equals(matrix[x][y-1]) || !"x".equals(matrix[x][y]) ||
        // !"x".equals(matrix[x-2][y])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else if (y + 1 > m) {
        // if(!"x".equals(matrix[x-2][y-1]) || !"x".equals(matrix[x-1][y-2]) ||
        // !"x".equals(matrix[x][y-1]) || !"x".equals(matrix[x][y-2]) ||
        // !"x".equals(matrix[x-2][y-2])){
        // sb.append("no").append("\n");
        // return;
        // }
        // } else {
        // if(!"x".equals(matrix[x-2][y-1]) || !"x".equals(matrix[x-1][y-2]) ||
        // !"x".equals(matrix[x-1][y]) || !"x".equals(matrix[x-2][y]) ||
        // !"x".equals(matrix[x-2][y-2]) || !"x".equals(matrix[x][y]) ||
        // !"x".equals(matrix[x][y-1]) || !"x".equals(matrix[x][y-2])){
        // sb.append("no").append("\n");
        // return;
        // }
        // }
        // }
        // sb.append("yes").append("\n");

    }

}
