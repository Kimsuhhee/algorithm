import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2146 {
    static int[][] island;
    static int[][] g;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static Queue<Point> q = new LinkedList();
    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        island = new int[n][n];
        g = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            StringTokenizer stk = new StringTokenizer(tmp," ");
            for(int j=0;j<n;j++){
                island[i][j] = Integer.parseInt(stk.nextToken());
                dist[i][j] = -1;
            }
        }

        /**섬 번호매기기 **/
        int number=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(island[i][j]==1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    g[i][j]=number;
                    bfs(number);
                    number++;
                }
            }
        }

        q.clear();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = false;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(island[i][j]==1){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(x<0||y<0||x>=n||y>=n)continue;
                if(g[x][y]==0 && !visited[x][y]){
                    g[x][y] = g[p.x][p.y];
                    q.add(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }

        q.clear();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(island[i][j]==1){
                    q.add(new Point(i,j));
                    dist[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0||my<0||mx>=n||my>=n)continue;
                if(dist[mx][my]==-1){
                    q.add(new Point(mx,my));
                    dist[mx][my] = dist[tmp.x][tmp.y]+1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if(x>=0 && y>=0 && x<n && y<n && g[i][j] != g[x][y])
                        min = Math.min(min,dist[i][j]+dist[x][y]);
                }
            }
        }
        System.out.println(min);

    }

    private static void bfs(int number) {
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int mx = temp.x+dx[i];
                int my = temp.y+dy[i];
                if(mx<0||my<0||mx>=n||my>=n)continue;
                if(island[mx][my]==1 && !visited[mx][my]){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
                    g[mx][my] = number;
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
