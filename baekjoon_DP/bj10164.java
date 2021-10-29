import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10164 {
    static int N,M,K,cx,cy;
    static int[][] board,d;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        board = new int[N][M];
        int num = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board[i][j] = num;
                if(num==K){
                    cx=i; cy=j;
                }
                num++;
            }
        }

        int answer = 0;
        d = new int[N][M];
        if(K==0) answer = dfs(0,0,N-1,M-1);
        else {
            answer = dfs(0,0,cx,cy);
            d = new int[N][M];
            answer *= dfs(cx,cy,N-1,M-1);
        }
        System.out.println(answer);
    }

    private static int dfs(int x, int y, int ex, int ey) {
        if(x==ex && y==ey){
            return 1;
        }
        if(d[x][y]!=0) return d[x][y];
        for(int i=0;i<2;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M)continue;
            d[x][y] += dfs(nx,ny,ex,ey);
        }
        return d[x][y];
    }
}
