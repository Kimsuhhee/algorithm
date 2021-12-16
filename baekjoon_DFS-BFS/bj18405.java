import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj18405 {
    static int N,K,S,X,Y;
    static int[][]tube;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Point>[]q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        tube =new int[N+1][N+1];
        q = new Queue[K+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                tube[i][j] = Integer.parseInt(stk.nextToken());

            }
        }
        for(int i=0;i<=K;i++){
            q[i] = new LinkedList<>();
        }
        stk = new StringTokenizer(br.readLine());
        S = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());
        Y = Integer.parseInt(stk.nextToken());

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(tube[i][j]!=0){
                    q[tube[i][j]].add(new Point(tube[i][j],i,j));
                }
            }
        }

        while(S-- > 0){
            for(int v=1;v<=K;v++){
                int size = q[v].size();
                while(size-- > 0){
                    Point p = q[v].poll();
                    for(int i=0;i<4;i++){
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];
                        if(nx<1 ||ny<1 || nx>N || ny>N)continue;
                        if(tube[nx][ny]==0) {
                            tube[nx][ny] = v;
                            q[v].add(new Point(v,nx,ny));
                        }
                    }
                }
            }
        }

        System.out.println(tube[X][Y]);

    }

    private static class Point {
        int type,x,y;

        public Point(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
