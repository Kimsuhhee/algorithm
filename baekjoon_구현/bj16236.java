import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj16236 {
    static int N;
    static PriorityQueue<Point> fish;
    static Queue<Point>q;
    static Point shark;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
                if(area[i][j]==9)
                    shark = new Point(i,j,2,0);
            }
        }

        int time = 0;
        int eats = 0;
        while(true){
            bfs();
            if(fish.size()==0)break;
            else{
                Point end = fish.poll();
                //System.out.println(end.x+" "+end.y+" "+end.dist);
                area[shark.x][shark.y] = 0;
                area[end.x][end.y] = 9;
                shark.x = end.x;
                shark.y = end.y;
                shark.dist = 0;
                ++eats;
                if(eats==shark.size){
                    eats=0;
                    shark.size++;
                }
                time+=end.dist;
            }

        }
        System.out.println(time);

    }

    private static void bfs() {
        q = new LinkedList<>();
        fish = new PriorityQueue<>();
        q.add(shark);
        visited = new boolean[N][N];
        visited[shark.x][shark.y] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int x = cur.x+dx[i];
                int y = cur.y+dy[i];
                if(x<0||y<0||x>=N||y>=N) continue;
                if(visited[x][y]) continue;
                if(area[x][y]>=1 && area[x][y]<=6 && area[x][y]<shark.size)
                    fish.add(new Point(x,y,area[x][y],cur.dist+1));
                else if(area[x][y]==0) q.add(new Point(x,y,0, cur.dist+1));
                else if(area[x][y]==shark.size)q.add(new Point(x,y,0,cur.dist+1));
                visited[x][y] = true;
            }
        }
    }

    private static class Point implements Comparable<Point>{
        int x,y,size,dist;

        public Point(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if(this.dist-o.dist==0){
                if(this.x-o.x==0){
                    return this.y-o.y;
                }else return this.x-o.x;
            }else return this.dist-o.dist;
        }
    }
}
