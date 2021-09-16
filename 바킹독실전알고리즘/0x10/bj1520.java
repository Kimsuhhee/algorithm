import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1520 {
    static int M,N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] road,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        road = new int[M][N];
        d = new int[M][N];

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                road[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                d[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int cx, int cy) {
        if(cx==M-1 && cy==N-1)return 1;

        int cur = road[cx][cy];
        if(d[cx][cy]==-1){
            d[cx][cy] = 0;
            for(int i=0;i<4;i++){
                int x = cx + dx[i];
                int y = cy + dy[i];
                if(x<0||y<0||x>=M||y>=N)continue;
                if(road[x][y]<cur) d[cx][cy] += dfs(x,y);
            }
        }
        return d[cx][cy];
    }
}
