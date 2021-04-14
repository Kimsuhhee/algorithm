import java.io.*;
import java.util.*;

public class bj7576 {
    static int N,M; //M:가로, N:세로
    static int answer;
    static int[][] tomato;
    static int[][] visited;
    static int[] dx = {-1,+1,0,0};
    static int[] dy = {0,0,-1,+1};

    private static class Tomatos {
        int x;
        int y;

        public Tomatos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        visited = new int [N+1][M+1];
        tomato = new int [N+1][M+1];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                tomato[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Queue<Tomatos> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomato[i][j]==1){
                    q.add(new Tomatos(i,j));
                    visited[i][j]=1;
                }
            }
        }

        while(!q.isEmpty()){
            Tomatos tmp = q.poll();
            int ox = tmp.x;
            int oy = tmp.y;
            for(int i=0;i<4;i++){
                int cx = ox+dx[i];
                int cy = oy+dy[i];
                if(cx>=0 && cy>=0 && cx<N && cy<M){
                    if(tomato[cx][cy]!=-1 && visited[cx][cy]==0){
                        q.add(new Tomatos(cx,cy));
                        visited[cx][cy]=1;
                        tomato[cx][cy] = tomato[ox][oy]+1;
                    }
                }
            }
        }

        int m = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tomato[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                m=Math.max(m,tomato[i][j]);
            }
        }
        System.out.println(m-1);

    }

}
