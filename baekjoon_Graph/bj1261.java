import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1261 {
    static int M,N;
    static int[][] maze,broken;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        maze = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                maze[i][j] = s.charAt(j)-'0';
            }
        }
        PriorityQueue<Point>pq = new PriorityQueue<>();
        broken = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(broken[i],Integer.MAX_VALUE);
        }
        broken[0][0] = 0;
        pq.add(new Point(0,0,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(broken[nx][ny]>broken[p.x][p.y]+maze[nx][ny]){
                    broken[nx][ny] = broken[p.x][p.y]+maze[nx][ny];
                    pq.add(new Point(nx,ny,broken[nx][ny]));
                }

            }
        }

        System.out.println(broken[N-1][M-1]);
    }

    private static class Point implements Comparable<Point>{
        int x,y,cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
}
