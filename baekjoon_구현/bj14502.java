import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14502 {
    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(map[i][j]==0 && !visited[i][j]){
                    visited[i][j] = true;
                    map[i][j] = 1;
                    makeSafeZone(i,j,1);
                    visited[i][j] = false;
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(max);

    }

    private static void makeSafeZone(int x, int y, int n) {
        if(n==3){
            max = Math.max(max,bfs());
            return;
        }
        for(int i=x;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(map[i][j]==0 && !visited[i][j]){
                    visited[i][j] = true;
                    map[i][j] = 1;
                    makeSafeZone(i,j,n+1);
                    visited[i][j] = false;
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        Queue<Point>q = new LinkedList<>();
        int[][] copy = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                copy[i][j] = map[i][j];
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(copy[i][j]==2){
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int x = temp.x +dx[i];
                int y = temp.y +dy[i];
                if(x<=0||y<=0||x>N||y>M)continue;
                if(copy[x][y]==0){
                    copy[x][y]=2;
                    q.add(new Point(x,y));
                }
            }
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(copy[i][j]==0) cnt++;
            }
        }
        return cnt;

    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
