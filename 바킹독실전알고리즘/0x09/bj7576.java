import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7576 {
    static int N,M;
    static int[][] tomato;
    static int[][] dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Tomato>q = new LinkedList<>();

    private static class Tomato {
        int x,y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String MN = br.readLine();
        StringTokenizer stk = new StringTokenizer(MN," ");

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        tomato = new int[N+1][M+1];
        dist = new int[N+1][M+1];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                tomato[i][j] = Integer.parseInt(stk.nextToken());
                if(tomato[i][j]==0)dist[i][j]=-1;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomato[i][j]==1){
                    q.add(new Tomato(i,j));
                    dist[i][j] = 0;
                }
            }
        }
        bfs();

        int max =  Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(dist[i][j]==-1){
                    System.out.println(-1);return;
                }
                max = Math.max(max,dist[i][j]);
            }
        }
        System.out.println(max);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Tomato tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 || my<0|| mx>N || my>M)continue;
                if(dist[mx][my]==-1){
                    q.add(new Tomato(mx,my));
                    dist[mx][my] = dist[tmp.x][tmp.y]+1;
                }
            }
        }
    }

}
