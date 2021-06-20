import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13565 {
    static int M,N;
    static boolean done = false;
    static int[][] p;
    static boolean[][] visited;
    static int[]dx = {1,0,-1,0};
    static int[]dy = {0,1,0,-1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        p = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                p[i][j] = s.charAt(j)-'0';
            }
        }
        for(int j=0;j<N;j++){
            if(p[0][j]==0 && !visited[0][j]){
                q.add(new Point(0,j));
                visited[0][j] = true;
                bfs();
            }
        }
        if(done)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.x==M-1){
                done = true;
                return;
            }
            for(int i=0;i<4;i++){
                int x = temp.x+dx[i];
                int y = temp.y+dy[i];
                if(x<0||y<0||x>=M||y>=N)continue;
                if(!visited[x][y] && p[x][y]==0){
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
