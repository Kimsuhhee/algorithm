import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7562 {
    static int l;
    static int nx,ny,ex,ey;
    static int dist[][];
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {-2,1,-1,2,-2,-1,1,2};
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
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            l = Integer.parseInt(br.readLine());
            dist = new int[l][l];
            for(int i[]:dist) Arrays.fill(i,-1);
            q.clear();

            String nxny = br.readLine();
            StringTokenizer stk = new StringTokenizer(nxny," ");
            nx = Integer.parseInt(stk.nextToken());
            ny = Integer.parseInt(stk.nextToken());

            String exey = br.readLine();
            stk = new StringTokenizer(exey," ");
            ex = Integer.parseInt(stk.nextToken());
            ey = Integer.parseInt(stk.nextToken());

            q.add(new Point(nx,ny));
            dist[nx][ny] = 0;
            bfs();
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point tmp = q.poll();
            if(tmp.x==ex && tmp.y==ey){
                System.out.println(dist[ex][ey]);
                break;
            }
            for(int i=0;i<8;i++){
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                if(mx<0||my<0||mx>=l||my>=l)continue;
                if(dist[mx][my]==-1 || dist[mx][my]>dist[tmp.x][tmp.y]+1){
                    q.add(new Point(mx,my));
                    dist[mx][my] = dist[tmp.x][tmp.y]+1;
                }
            }
        }
    }

}
