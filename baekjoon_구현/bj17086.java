import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17086 {
    static int N,M;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int max = -10;
    static int[][] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        area = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(area[i][j]==0){
                    boolean[][] visited = new boolean[N][M];
                    Queue<Point>q = new LinkedList<>();
                    q.add(new Point(i,j,0));
                    visited[i][j] = true;
                    max = Math.max(max,bfs(q,visited));
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(Queue<Point> q, boolean[][] visited) {
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(area[cur.x][cur.y]==1)return cur.dist;
            for(int i=0;i<8;i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(x<0||y<0||x>=N||y>=M)continue;
                if(visited[x][y])continue;
                q.add(new Point(x,y,cur.dist+1));
                visited[x][y] = true;
            }
        }
        return 0;
    }


    private static class Point {
        int x,y,dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
