import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj16930 {
    static int N,M,K;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][]arr;
    static int[][]d;
    static Queue<Point> q;
    static Point start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        stk = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(stk.nextToken())-1;
        int y1 = Integer.parseInt(stk.nextToken())-1;
        int x2 = Integer.parseInt(stk.nextToken())-1;
        int y2 = Integer.parseInt(stk.nextToken())-1;
        start = new Point(x1,y1);
        end = new Point(x2,y2);
        d = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(d[i],Integer.MAX_VALUE);
        }
        q = new LinkedList<>();
        q.add(start);
        d[start.x][start.y] = 0;
        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            if(cx==end.x && cy==end.y) {
                System.out.println(d[cx][cy]);
                System.exit(0);
            }
            for(int i=0;i<4;i++){
                for(int j=1;j<=K;j++) {
                    int mx = cx + dx[i]*j;
                    int my = cy + dy[i]*j;
                    if (mx < 0 || my < 0 || mx >= N || my >= M) break;
                    if(arr[mx][my]=='#')break;
                    if(d[mx][my]==Integer.MAX_VALUE) {
                        q.add(new Point(mx, my));
                        d[mx][my] = d[cx][cy] + 1;
                    }
                    if(d[mx][my]<=d[cx][cy])break;
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
