import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14503 {
    static int N,M,r,c,d;
    static int cnt;
    static int[] dx = {-1,0,1,0}; //북동남서
    static int[] dy = {0,1,0,-1};
    static int[][] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        area = new int[N][M];

        stk = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(true){
            //현재 위치를 청소한다.
            if(area[r][c]==0){
                area[r][c] = 2;
                cnt++;
            }

            boolean flag = false;
            for(int i=0;i<4;i++){
                d = turnDirection(d);
                int cx = r+dx[d];
                int cy = c+dy[d];
                if(cx<0||cy<0||cx>N||cy>M)continue;
                if(area[cx][cy]==0){
                    flag = true;
                    r = cx; c = cy;
                    break;
                }
            }

            if(!flag){
                int back = backDirection(d);
                int bx = r+dx[back];
                int by = c+dy[back];
                if(bx>=0 && by>=0 && bx<N && by<M && area[bx][by]!=1){
                    r = bx;
                    c = by;
                }else
                    break;

            }

        }

        System.out.println(cnt);

    }

    private static int backDirection(int d) {
        if(d==0){
            d=2;
        }else if(d==1){
            d=3;
        }else if(d==2){
            d=0;
        }else if(d==3){
            d=1;
        }
        return d;
    }

    private static int turnDirection(int d) {
        if(d==0){
            d=3;
        }else if(d==1){
            d=0;
        }else if(d==2){
            d=1;
        }else if(d==3){
            d=2;
        }
        return d;
    }

    private static class Point {
        int x,y,dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
