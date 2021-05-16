import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206 {
    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Point>q = new LinkedList<>();

    private static class Point {
        int x,y,bk,cnt;

        public Point(int x, int y, int bk, int cnt) {
            this.x = x;
            this.y = y;
            this.bk = bk;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        q.add(new Point(0,0,0,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.x==N-1 && temp.y==M-1){
                System.out.println(temp.cnt+1);
                return;
            }
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0||y<0||x>=N||y>=M) continue;
                if(map[x][y]==1 && temp.bk==0){ //벽인데 벽을 부순적이 없다면
                    q.add(new Point(x,y,temp.bk+1,temp.cnt+1));
                    visited[x][y][temp.bk+1] = true;
                }
                if(map[x][y]==0 && !visited[x][y][temp.bk]){ //벽이아닌데 방문한 적이 없다면
                    q.add(new Point(x,y,temp.bk,temp.cnt+1));
                    visited[x][y][temp.bk] = true;
                }
            }
        }
        System.out.println(-1);

    }

}
