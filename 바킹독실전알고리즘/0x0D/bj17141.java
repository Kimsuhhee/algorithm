import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17141 {
    static int N,M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Point>possible = new ArrayList<Point>();
    static int[] combination;
    static boolean[] visited;
    static Queue<Point>q;
    static int[][] dist;
    static int[][] lab;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        lab = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                lab[i][j] = Integer.parseInt(stk.nextToken());
                if(lab[i][j]==2)possible.add(new Point(i,j));

            }
        }
        visited = new boolean[possible.size()];
        combination = new int[M];
        permutation(0,0);
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void permutation(int start, int n) {
        if(n==M){
            q = new LinkedList<>();
            dist = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(lab[i][j]==1) //벽
                        dist[i][j] = -1;
                }
            }
            for(int i:combination) { //큐에 넣고 방문처리
                q.add(possible.get(i));
                dist[possible.get(i).x][possible.get(i).y] = 1;
            }
            min = Math.min(min,bfs());

            return;
        }
        for(int i=start;i<possible.size();i++){
            combination[n] = i;
            permutation(i+1,n+1);
        }
    }

    private static int bfs() {
        int max = 0;
        boolean zero = false;
        while(!q.isEmpty()){
            Point virus = q.poll();
            for(int i=0;i<4;i++){
                int x = virus.x + dx[i];
                int y = virus.y + dy[i];
                if(x<0||y<0||x>=N||y>=N)continue;
                if(dist[x][y]==-1)continue;
                if(dist[x][y]==0){
                    dist[x][y] = dist[virus.x][virus.y] + 1;
                    q.add(new Point(x,y));
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(dist[i][j]==0) return min;
                if(dist[i][j]>max)max = dist[i][j];
            }
        }
        return max-1;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
