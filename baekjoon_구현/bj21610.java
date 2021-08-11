import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21610 {
    static int N,M,d,s;
    static int[][] map;
    static boolean[][] visited;

    //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static Queue<Point>q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        //(N, 1), (N, 2), (N-1, 1), (N-1, 2)
        q.add(new Point(N,1));
        q.add(new Point(N,2));
        q.add(new Point(N-1,1));
        q.add(new Point(N-1,2));

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            d = Integer.parseInt(stk.nextToken());
            s = Integer.parseInt(stk.nextToken());
            move(d-1,s);
            rain();
            cloud();
        }
        System.out.println(cal());
    }

    private static int cal() {
        int sum = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void cloud() {
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(visited[i][j])continue;
                if(map[i][j]>=2){
                    map[i][j] -= 2;
                    q.add(new Point(i,j));
                }
            }
        }
    }

    private static void rain() {
        Iterator<Point>it = q.iterator();
        while(it.hasNext()){
            Point temp = it.next();
            map[temp.x][temp.y]++;
        }
        while(!q.isEmpty()){
            Point temp = q.poll();
            int cnt = 0, x = 0 , y = 0;
            for(int i=1;i<8;i+=2){
                x = temp.x + dx[i];
                y = temp.y + dy[i];
                if(x<=0||y<=0||x>N||y>N)continue;
                if(map[x][y]>0)cnt++;
            }
            map[temp.x][temp.y] += cnt;
        }
    }

    private static void move(int dir, int s) {
        visited = new boolean[N+1][N+1];
        int size = q.size();
        while(size-- > 0){
            Point temp = q.poll();
            int x = temp.x + s * dx[dir] + s*N -1;
            int y = temp.y + s * dy[dir] + s*N -1;
            x = x%N+1;
            y = y%N+1;
            q.add(new Point(x,y));
            visited[x][y] = true;
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
