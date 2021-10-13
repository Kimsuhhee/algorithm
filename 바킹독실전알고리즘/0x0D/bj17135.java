import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17135 {
    static int N,M,D,max;
    static int[] dx = {0,-1,0};
    static int[] dy = {-1,0,1};
    static int[][]pan,arr;
    static int[]archer;
    static boolean[][]attacked,visited;
    static Queue<Point>q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());

        pan = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                pan[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        max = -1;
        archer = new int[3];
        combination(0,0);
        System.out.println(max);
    }

    private static void combination(int start,int n) {
        if(n==3){
            arr = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    arr[i][j] = pan[i][j];
                }
            }
            max = Math.max(max,attack());
            return;
        }
        for(int i=start;i<M;i++){
            archer[n] = i;
            combination(i+1,n+1);
        }
    }

    private static int attack() {
        int sum = 0;

        //모든 적이 0이 아닌경우 반복
        while(!finish()){
            attacked = new boolean[N][M];
            for(int y:archer){
                bfs(y);
            }
            //공격당한 적 => 0으로
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(attacked[i][j]==true){
                        arr[i][j]=0;
                        sum++;
                    }
                }
            }
            //모든 적이 0이 아니라면 이동
            move();
        }
        return sum;
    }

    private static boolean finish() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1)return false;
            }
        }
        return true;
    }

    private static void bfs(int y) {
        q = new LinkedList<>();
        q.add(new Point(N,y));
        visited = new boolean[N+1][M];
        visited[N][y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<3;i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if(visited[mx][my])continue;
                int dist = Math.abs(N-mx)+Math.abs(y-my);
                if(dist>D)continue;
                if (arr[mx][my] == 1) {
                    attacked[mx][my] = true;
                    return;
                }
                visited[mx][my] = true;
                q.add(new Point(mx, my));
                }
            }
        }
    private static void move() {
        int[][]temp = new int[N][M];
        for(int x=N-2;x>=0;x--){
            for(int y=0;y<M;y++){
                temp[x+1][y] = arr[x][y];
            }
        }

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = temp[i][j];
            }
        }
    }

    private static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
