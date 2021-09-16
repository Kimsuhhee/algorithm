import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1890 {
    static int N;
    static long cnt;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int[][] arr;
    static long[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        d = new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                d[i][j] = -1; //방문표시도 함께
            }
        }
        System.out.println(dfs(0,0));
    }

    private static long dfs(int sx, int sy) {
        if(sx==N-1&& sy==N-1){
            return 1;
        }
        if(d[sx][sy]==-1) {
            d[sx][sy] = 0;
            for (int i = 0; i < 2; i++) {
                int mx = sx + dx[i] * arr[sx][sy];
                int my = sy + dy[i] * arr[sx][sy];
                if (mx < 0 || my < 0 || mx >= N || my >= N) continue;
                d[sx][sy] += dfs(mx, my);
            }
        }
        return d[sx][sy];
    }
}
