import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1937 {
    static int n,answer;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] area,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        StringTokenizer stk;
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        d = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(d[i],-1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer = Math.max(dfs(i,j),answer);
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if(d[x][y]!=-1) return d[x][y];

        d[x][y] = 1;
        for(int i=0;i<4;i++){
            int mx = x+ dx[i];
            int my = y+ dy[i];
            if(mx<0||my<0||mx>=n||my>=n)continue;
            if(area[x][y]<area[mx][my]) {
                d[x][y] = Math.max(d[x][y],dfs(mx,my)+1);
            }
        }

        return d[x][y];
    }
}
