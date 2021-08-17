import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17144 {
    static int R,C,T;
    static int[] up = {2,1,3,0}; //반시계
    static int[] down = {2,0,3,1}; //시계
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] room;
    static Point m1,m2; //공기청정기 위치
    static Queue<Point>airs = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());
        room = new int[R][C];
        int mcnt = 0;
        for(int i=0;i<R;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<C;j++){
                room[i][j] = Integer.parseInt(stk.nextToken());
                if(room[i][j]==-1){
                    if(mcnt++ == 0) m1 = new Point(i,j,room[i][j]);
                    else m2 = new Point(i,j,room[i][j]);
                }
                else if(room[i][j]!=0){
                    airs.add(new Point(i,j,room[i][j]));
                }
            }
        }

        while(T-->0){
            diffuse();
            activate();
            add();
        }
        System.out.println(cal());
    }

    private static void add() {
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(room[i][j]!=-1 && room[i][j]!=0){
                    airs.add(new Point(i,j,room[i][j]));
                }
            }
        }
    }

    private static void diffuse() {
        while(!airs.isEmpty()){
            Point cur = airs.poll();
            int amount = cur.amount;
            int change = amount/5; //변경되기전 먼지양으로 계산
            int cnt = 0;
            for(int i=0;i<4;i++){
                int x = cur.x+dx[i];
                int y = cur.y+dy[i];
                if(x>=0&&y>=0&&x<R&&y<C&&room[x][y]!=-1){
                    room[x][y] += change;
                    cnt++;
                }
            }
            room[cur.x][cur.y] -= change * cnt;

        }


    }

    private static void activate() {
        int[][] temp = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                temp[i][j] = room[i][j];
            }
        }
        int x = m1.x;
        int y = m1.y+1;
        room[x][y] = 0;
        for(int i=0;i<4;i++){
            while(true) {
                int mx = x + dx[up[i]];
                int my = y + dy[up[i]];
                if (mx < 0 || my < 0 || mx >= R || my >= C) break;
                if (mx==m1.x && my==m1.y) break;
                room[mx][my] = temp[x][y];
                x = mx;
                y = my;
            }
        }

        x = m2.x;
        y = m2.y+1;
        room[x][y] = 0;
        for(int i=0;i<4;i++){
            while(true) {
                int mx = x + dx[down[i]];
                int my = y + dy[down[i]];
                if (mx < 0 || my < 0 || mx >= R || my >= C) break;
                if (mx==m2.x && my==m2.y) break;
                room[mx][my] = temp[x][y];
                x = mx;
                y = my;
            }
        }
    }

    private static int cal() {
        int sum = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(room[i][j]!=0 && room[i][j]!=-1)
                    sum+=room[i][j];
            }
        }
        return sum;
    }


    private static class Point {
        int x,y,amount;

        public Point(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
