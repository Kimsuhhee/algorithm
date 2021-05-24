import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1743 {
    static int N,M,K,cnt;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] food;
    static boolean[][] visited;
    static Queue<Point>q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        food = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0;i<K;i++){
            stk = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            food[r][c] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(food[i][j] == 1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    cnt=0;
                    bfs();
                    if(max<cnt)max=cnt;
                }
            }
        }
        System.out.println(max);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            cnt++;
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0||y<0||x>N||y>M)continue;
                if(food[x][y]==1 && !visited[x][y]){
                    q.add(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
