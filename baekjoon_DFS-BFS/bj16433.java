import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16433 {
    static int N,R,C;
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,-1,1};
    static char[][] carrot;
    static Queue<Point>q = new LinkedList<>();

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        carrot = new char[N][N];
        for(char c[]:carrot) Arrays.fill(c,'.');

        carrot[R-1][C-1] = 'v';
        q.add(new Point(R-1,C-1));

        bfs();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(carrot[i][j]);
            }
            System.out.println();
        }

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point c = q.poll();
            for(int i=0;i<4;i++){
                int x = c.x + dx[i];
                int y = c.y + dy[i];
                if(x<0||y<0||x>=N||y>=N)continue;
                if(carrot[x][y]=='.'){
                    carrot[x][y] = 'v';
                    q.add(new Point(x,y));
                }
            }
        }
    }

}
