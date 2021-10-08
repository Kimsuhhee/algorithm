import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3055 {
    static int R,C;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][]map;
    static int[][]dist;
    static boolean isPossible = false;
    static Queue<Point>q,w;
    static Point start,end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        map = new char[R][C];
        w = new LinkedList<>();
        dist = new int[R][C];
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = s.charAt(j);
                if(map[i][j]=='S')start = new Point(i,j);
                if(map[i][j]=='D')end = new Point(i,j);
                if(map[i][j]=='*')w.add(new Point(i,j));
            }
        }
        q = new LinkedList<>();
        q.add(start);
        for(int i=0;i<R;i++){
            Arrays.fill(dist[i],-1);
        }
        dist[start.x][start.y] = 0;
        bfs();
        if(!isPossible)System.out.println("KAKTUS");
        else System.out.println(dist[end.x][end.y]);

    }

    private static void bfs() {
        while(!q.isEmpty()){
            int size = w.size();
            while(size-- > 0){
                Point cur = w.poll();
                for(int i=0;i<4;i++){
                    int mx = cur.x + dx[i];
                    int my = cur.y + dy[i];
                    if(mx<0||my<0||mx>=R||my>=C)continue;
                    if(map[mx][my]=='.'){
                        w.add(new Point(mx,my));
                        map[mx][my] = '*';
                    }
                }
            }
            size = q.size();
            while(size-- > 0){
                Point cur = q.poll();
                for(int i=0;i<4;i++){
                    int mx = cur.x + dx[i];
                    int my = cur.y + dy[i];
                    if(mx<0||my<0||mx>=R||my>=C)continue;
                    if(map[mx][my]=='.' && dist[mx][my]==-1){
                        q.add(new Point(mx,my));
                        dist[mx][my] = dist[cur.x][cur.y] + 1;
                    }
                    if(map[mx][my]=='D'){
                        dist[mx][my] = dist[cur.x][cur.y] + 1;
                        isPossible = true;
                        return;
                    }
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
