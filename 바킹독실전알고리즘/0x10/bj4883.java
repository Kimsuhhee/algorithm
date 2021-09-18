import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4883 {
    static int n;
    static int[] dx = {0,1,1,1};
    static int[] dy = {1,-1,0,1};
    static int[][] graph;
    static long[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 0;
        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n==0)break;

            graph = new int[n][3];
            StringTokenizer stk;
            for(int i=0;i<n;i++){
                stk = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    graph[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            d = new long[n][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    d[i][j] = -1; //방문체크
                }
            }
            System.out.println(++t+". "+dp(0,1));

        }
    }

    private static long dp(int x,int y) {
        if(x==n-1 && y==1) return graph[x][y];

        if(d[x][y]!=-1) return d[x][y];

        d[x][y] = 1000000;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < 0 || my < 0 || mx >= n || my >= 3) continue;
            d[x][y] = Math.min(d[x][y], dp(mx,my) + graph[x][y]);
        }
        return d[x][y];
    }
}
