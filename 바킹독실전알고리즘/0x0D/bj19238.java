import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj19238 {
    static int N,M,fuel;
    static int[][] map;
    static Point start;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Point[] passengers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        fuel = Integer.parseInt(stk.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int sx,sy,ex,ey;
        stk = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(stk.nextToken())-1;
        sy = Integer.parseInt(stk.nextToken())-1;
        start = new Point(sx,sy);
        passengers = new Point[M];
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(stk.nextToken())-1;
            sy = Integer.parseInt(stk.nextToken())-1;
            ex = Integer.parseInt(stk.nextToken())-1;
            ey = Integer.parseInt(stk.nextToken())-1;
            passengers[i] = new Point(sx,sy,ex,ey,false);
        }

        //한 승객을 태워 목적지로 이동시키는 일을 M번 반복
        for(int i=0;i<M;i++){
            int p = findClosePassenger();
            if(p==-1){
                System.out.println(-1);
                System.exit(0);
            }

            fuel -= move(p);
            if(fuel<0){
                System.out.println(-1);
                System.exit(0);
            }

            int spend = arrive(p);
            if(spend==-1){
                System.out.println(-1);
                System.exit(0);
            }
            fuel -= spend;
            if(fuel<0){
                System.out.println(-1);
                System.exit(0);
            }
            fuel += (spend * 2);

            //해당 승객 도착 표시
            passengers[p].isArrived = true;

            //출발지 갱신
            start = new Point(passengers[p].ex,passengers[p].ey);

        }
        System.out.println(fuel);
    }

    private static int move(int p) {
        Queue<Point>q = new LinkedList<>();
        int[][] dist = new int[N][N];
        q.add(start);
        dist[start.x][start.y] = 1;
        Point end = passengers[p];

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x==end.x && cur.y==end.y){
                return dist[cur.x][cur.y]-1;
            }
            for(int i=0;i<4;i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(dist[mx][my]!=0)continue;
                if(map[mx][my]==1)continue;
                q.add(new Point(mx,my));
                dist[mx][my] = dist[cur.x][cur.y]+1;
            }
        }
        return -1;
    }

    private static int arrive(int p) {
        Queue<Point>q = new LinkedList<>();
        int[][] dist = new int[N][N];
        q.add(new Point(passengers[p].x,passengers[p].y));
        dist[passengers[p].x][passengers[p].y] = 1;
        Point end = passengers[p];

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x==end.ex && cur.y==end.ey){
                return dist[cur.x][cur.y]-1;
            }
            for(int i=0;i<4;i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(dist[mx][my]!=0)continue;
                if(map[mx][my]==1)continue;
                q.add(new Point(mx,my));
                dist[mx][my] = dist[cur.x][cur.y]+1;
            }
        }
        return -1;
    }

    private static int findClosePassenger() {
        Queue<Point>q = new LinkedList<>();
        int[][] dist = new int[N][N];
        q.add(start);
        dist[start.x][start.y] = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(dist[mx][my]!=0)continue;
                if(map[mx][my]==0) {
                    q.add(new Point(mx, my));
                    dist[mx][my] = dist[cur.x][cur.y] + 1;
                }
            }
        }

        ArrayList<Distance>list = new ArrayList<>();
        for(int i=0;i<M;i++){
            if(passengers[i].isArrived)continue;
            int cx = passengers[i].x; int cy = passengers[i].y;
            if(dist[cx][cy]==0)continue;
            list.add(new Distance(i,cx,cy,dist[cx][cy]));
        }
        if(list.size()==0)return -1;
        Collections.sort(list);
        return list.get(0).num;
    }

    private static class Distance implements Comparable<Distance> {
        int num,x,y,dist;

        public Distance(int num, int x, int y, int dist) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Distance o) {
            if(this.dist==o.dist){
                if(this.x==o.x){
                    return this.y-o.y;
                }else return this.x-o.x;
            }else
                return this.dist-o.dist;
        }
    }

    private static class Point {
        int x,y,ex,ey;
        boolean isArrived;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point(int x, int y, int ex, int ey, boolean isArrived){
            this(x,y);
            this.ex = ex;
            this.ey = ey;
            this.isArrived = isArrived;
        }
    }
}
