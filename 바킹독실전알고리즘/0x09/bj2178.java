import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {
    static int N,M;
    static int[][]maze;
    static int[][]dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Maze> q= new LinkedList();

    private static class Maze {
        int x,y;

        public Maze(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer stk = new StringTokenizer(NM," ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        maze = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        for(int t[]:dist){
            Arrays.fill(t,-1);
        }

        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<M;j++){
                maze[i][j] = tmp.charAt(j)-'0';
            }
        }
        q.add(new Maze(0,0));
        dist[0][0]=0;

        while(!q.isEmpty()){
            Maze tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 || my<0 || mx>N || my>M)continue;
                if(dist[mx][my]==-1 && maze[mx][my]==1){
                    q.add(new Maze(mx,my));
                    dist[mx][my] = dist[tmp.x][tmp.y]+1;
                }
            }
        }
        System.out.println(dist[N-1][M-1]+1);

    }
}
