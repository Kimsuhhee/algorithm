import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17265 {
    static int N,min,max;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = stk.nextToken().charAt(0);
            }
        }

        visited = new boolean[N][N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(0,0,arr[0][0]+"");
        System.out.println(max+" "+min);
    }

    private static void dfs(int x, int y, String exp) {
        if(x==N-1 && y==N-1){
            cal(exp);
            return;
        }
        visited[x][y] = true;
        for(int i=0;i<2;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx<0||my<0||mx>=N||my>=N)continue;
            if(!visited[mx][my]) dfs(mx,my,exp+arr[mx][my]);
        }
        visited[x][y] = false;
    }

    private static void cal(String exp) {
        Stack<Integer>st = new Stack<>();
        st.add(exp.charAt(0)-'0');
        for(int i=1;i<exp.length();i++){
            char cur = exp.charAt(i);
            int pre = 0, next = 0;
            if (cur == '+') {
                pre = st.pop();
                next = exp.charAt(i+1)-'0';
                st.push(pre+next);
                i++;
            } else if (cur == '-') {
                pre = st.pop();
                next = exp.charAt(i+1)-'0';
                st.push(pre-next);
                i++;
            } else if (cur == '*') {
                pre = st.pop();
                next = exp.charAt(i+1)-'0';
                st.push(pre*next);
                i++;
            }
        }
        int ans = st.pop();
        max = Math.max(max,ans);
        min = Math.min(min,ans);
    }
}

