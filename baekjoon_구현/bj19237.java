import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class bj19237 {
    static int N,M,K;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};
    static shark[] sharks;
    static int[][][] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        area = new int[2][N+1][N+1];
        sharks = new shark[M+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                int num = Integer.parseInt(stk.nextToken());
                if(num == 0)continue;
                sharks[num] = new shark(i,j,0,false);
                area[0][i][j] = num;
                area[1][i][j] = K;
            }
        }
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=M;i++){
            sharks[i].dir = Integer.parseInt(stk.nextToken());
        }

        for(int i=1;i<=M;i++){
            for(int j=1;j<=4;j++){
                stk = new StringTokenizer(br.readLine()," ");
                for(int k=1;k<=4;k++){
                    sharks[i].d[j][k]=Integer.parseInt(stk.nextToken());
                }
            }
        }

        int time = 0;
        while(time < 1000){
            move();
            spread();
            time++;
            int cnt = 0;
            for(int i=1;i<=M;i++){
                if(sharks[i].remove==false) cnt++;
            }
            if(cnt==1){
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);

    }

    private static void spread() {

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(area[1][i][j]!=0){
                    area[1][i][j]-=1;
                    if(area[1][i][j]==0)area[0][i][j]=0;
                }
            }
        }

        for(int i=1;i<=M;i++){
            if(sharks[i].remove==true)continue;
                int x = sharks[i].x;
                int y = sharks[i].y;
                area[1][x][y] = K;
                area[0][x][y] = i;
        }
    }

    private static void move() {
        //이동할수있는 영역에 상어위치를 표시할 임시 배열
        int[][] arr = new int[N+1][N+1];

        for(int i=1;i<=M;i++) {
            shark cur = sharks[i];
            boolean check = false;
            if (sharks[i].remove == false) {
                for (int j = 1; j <= 4; j++) {
                    int md = cur.d[cur.dir][j];
                    int mx = cur.x + dx[md];
                    int my = cur.y + dy[md];
                    if (mx <= 0 || my <= 0 || mx > N || my > N) continue;
                    if (area[1][mx][my] == 0) { //냄새 없는 경우
                        if (arr[mx][my] != 0) { //칸에 이미 다른 상어가 있을때
                            if (arr[mx][my] > i) { //칸에 있던 상어의 번호가 현재 번호보다 큰경우
                                sharks[arr[mx][my]].remove = true;
                                //area[0][mx][my] = i;
                                //area[0][cur.x][cur.y] = 0;
                                arr[mx][my] = i;
                                cur.x = mx;
                                cur.y = my;
                                cur.dir = md;
                                check = true;
                                break;
                            }
                            if(arr[mx][my]<i) {
                                sharks[i].remove = true;
                                //area[0][cur.x][cur.y] = 0;
                                arr[cur.x][cur.y] = 0;
                                check = true;
                                break;
                            }
                        } else { //이동하려고 하는 칸에 아무도 없는 경우
                            //area[0][mx][my] = i;
                            //area[0][cur.x][cur.y] = 0;
                            arr[mx][my] = i;
                            cur.x = mx;
                            cur.y = my;
                            cur.dir = md;
                            check = true;
                            break;
                        }
                    }
                }
                if (!check) {
                    //갈곳이 없음, 다시 되돌아가야함
                    for (int j = 1; j <= 4; j++) {
                        int md = cur.d[cur.dir][j];
                        int mx = cur.x + dx[md];
                        int my = cur.y + dy[md];
                        if (mx <= 0 || my <= 0 || mx > N || my > N) continue;
                        if (area[0][mx][my] == i) {
                            //area[0][cur.x][cur.y] = 0;
                            cur.x = mx;
                            cur.y = my;
                            cur.dir = md;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static class shark {
        int x,y,dir;
        boolean remove;
        int[][] d = new int[5][5];

        public shark(int x, int y,int dir, boolean remove) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.remove = remove;
        }
    }

}
