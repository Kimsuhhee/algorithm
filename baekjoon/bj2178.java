import java.io.*;
import java.util.*;

public class bj2178 {
    static int N,M;
    static int[][] maze;
    static int[][] dp;
    static int[][] visited;
    static int[] dx = {-1,+1,0,0};
    static int[] dy = {0,0,-1,+1};

    private static class Points {
        int x;
        int y;

        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        visited = new int [N+1][M+1];
        maze = new int [N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                maze[i][j] = s.charAt(j)-'0';
            }
        }
        bfs(0,0);
        System.out.println(dp[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Points> q = new LinkedList<Points>();
        q.add(new Points(x,y));
        visited[x][y]=1;
        dp[0][0]=1;

        while(!q.isEmpty()){
         Points tmp = q.poll();
         int ox = tmp.x;
         int oy = tmp.y;
         for(int i=0;i<4;i++){
             int cx = ox+dx[i];
             int cy = oy+dy[i];
             if(cx>=0 && cy>=0 && cx<=N && cy<=M) {
                 if (maze[cx][cy] == 1 && visited[cx][cy] == 0) {
                     q.add(new Points(cx, cy));
                     visited[cx][cy] = 1;
                     dp[cx][cy] = dp[ox][oy]+1;
                 }
             }
          }
        }
     }

}
