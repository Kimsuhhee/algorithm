import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234 {
    static int N,L,R;
    static Queue<Point>q;
    static ArrayList<Point>list;
    static boolean[][] visited;
    static int[][] area;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        area = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int days = 0;
        while(true){
            if(!can_be_union())break;
            days++;
        }
        System.out.println(days);
    }

    private static void union() {
        int sum = 0;
        for(Point p:list){
            sum+=area[p.x][p.y];
        }
        int res = sum/list.size();

        for(Point p:list){
            area[p.x][p.y] = res;
        }
    }

    private static boolean can_be_union() {
        visited = new boolean[N][N];
        q = new LinkedList<>();
        boolean find = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                list = new ArrayList<>();
                if(!visited[i][j]){
                    q.add(new Point(i,j));
                    //시작점 방문표시x
                    bfs();
                    if(list.size()!=0){
                        union();
                        find = true;
                    }
                }
            }
        }
        return find;
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int d=0;d<4;d++){
                int x = p.x + dx[d];
                int y = p.y + dy[d];
                if(x<0||y<0||x>=N||y>=N) continue;
                if(visited[x][y])continue;
                if(Math.abs(area[x][y]-area[p.x][p.y])>=L && Math.abs(area[x][y]-area[p.x][p.y])<=R) {
                    q.add(new Point(x, y));
                    list.add(new Point(x,y));
                    visited[x][y] = true;
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
