import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1926 {
    static Queue<Point> q = new LinkedList<>();
    static int[][] draw ;
    static boolean[][] visited ;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int cnt,area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();

        StringTokenizer stk= new StringTokenizer(nm," ");
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        draw = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String info = br.readLine();
            stk = new StringTokenizer(info," ");
            for(int j=0;j<m;j++){
                draw[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ArrayList list = new ArrayList();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(draw[i][j]==1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    cnt++;
                    area = 0;
                    bfs();
                    list.add(area);
                }
            }
        }

        System.out.println(cnt);
        if(cnt==0) System.out.println(0);
        else System.out.println(Collections.max(list));
    }

    private static void bfs() {
        while(!q.isEmpty()){
            area++;
            Point tmp = q.poll();
            int ox = tmp.x;
            int oy = tmp.y;
            for(int i=0;i<4;i++){
                int mx = ox+dx[i];
                int my = oy+dy[i];
                if(mx>=n || my>=m || mx<0 || my<0)continue;
                if(draw[mx][my]==1 && visited[mx][my]==false){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
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
