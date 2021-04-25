import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2583 {
    static int M,N,K;
    static int[][]area;
    static boolean[][]visited;
    static Queue<Point> q = new LinkedList<>();
    static int areaCnt;
    static int[] dx = {1, 0 ,-1 ,0};
    static int[] dy = {0, 1 ,0 ,-1};

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mnk = br.readLine();
        StringTokenizer stk = new StringTokenizer(mnk);
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        area = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<K;i++){
            String s = br.readLine();
            stk = new StringTokenizer(s," ");
            int sx = Integer.parseInt(stk.nextToken());
            int sy = Integer.parseInt(stk.nextToken());
            int ex = Integer.parseInt(stk.nextToken());
            int ey = Integer.parseInt(stk.nextToken());
            for(int x = sx ; x < ex ; x++){
                for(int y = sy ; y < ey ; y++){
                    area[x][y]=1;
                }
            }
        }
        ArrayList list = new ArrayList();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(area[i][j]==0 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    areaCnt = 0;
                    bfs();
                    list.add(areaCnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            areaCnt++;
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 || my<0 || mx>=N || my>=M) continue;
                if(area[mx][my]==0 && !visited[mx][my]){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
                }
            }
        }
    }

}
