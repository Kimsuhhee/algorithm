import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj23290 {
    static int M,S,max;
    static ArrayList<Fish>fish;
    static int Sx,Sy;
    static int[] sDx = {-1,0,1,0};
    static int[] sDy = {0,-1,0,1};
    static int[] fDx = {0,-1,-1,-1,0,1,1,1};
    static int[] fDy = {-1,-1,0,1,1,1,0,-1};
    static int[][] smell;
    static ArrayList<Fish>[][] map;
    static boolean[][] visited;
    static int[] p,dirOrder;
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        //물고기 초기 위치
        fish = new ArrayList<>();
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            fish.add(new Fish(x,y,d-1));
        }

        //상어 초기 위치
        stk = new StringTokenizer(br.readLine());
        Sx = Integer.parseInt(stk.nextToken());
        Sy = Integer.parseInt(stk.nextToken());

        smell = new int[5][5];

        while(S-- > 0){
            ArrayList<Fish>temp = (ArrayList<Fish>) fish.clone();
            init();
            fishMove();
            sharkMove(0);
            disappear();
            copyFish(temp);
        }
        System.out.println(fish.size());

    }

    private static void init() {
        //물고기 좌표 표시 , 물고기는 같은 칸에 있을 수 있음
        map = new ArrayList[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j] = new ArrayList<>();
            }
        }

        //상어가 움직일때 잡을 수 있는 최대 물고기 수
        max = -1;

        //상어의 움직이는 방향 순서 배열
        dirOrder = new int[3];
        p = new int[3];

    }

    private static void sharkMove(int depth) {
        if(depth == 3){
            int cnt = move();
            if(cnt > max){
                max = cnt;
                for(int i=0;i<3;i++){
                    dirOrder[i] = p[i];
                }
            }
            return;
        }
        for(int i=0;i<4;i++){
            p[depth] = i;
            sharkMove(depth + 1);
        }
    }

    private static int move() {
        int x = Sx; int y = Sy;
        visited = new boolean[5][5];
        int sum = 0;

        for(int i=0;i<3;i++){
            x += sDx[p[i]];
            y += sDy[p[i]];
            if(x < 1 || y < 1 || x > 4 || y > 4){
                return -1;
            }
            if(!visited[x][y]) {
                sum += map[x][y].size();
            }
            visited[x][y] = true;
        }
        return sum;
    }

    private static void fishMove() {
        for(Fish f : fish){
            boolean isPossible = false;
            //현재 방향을 시작으로 이동 가능한 방향으로 한칸 이동
            for(int i=0;i<8;i++){
                int dir = (f.d-i+8)%8;
                int nx = f.x + fDx[dir];
                int ny = f.y + fDy[dir];
                if(nx < 1 || ny < 1 || nx > 4 || ny > 4)continue;
                if(smell[nx][ny]!=0)continue;
                if(nx==Sx && ny==Sy)continue;
                map[nx][ny].add(new Fish(nx, ny, dir));
                isPossible = true;
                break;
            }
            if(!isPossible)map[f.x][f.y].add(f);
        }

    }

    private static void disappear() {
        //현재 남겨진 냄새 -1
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                if(smell[i][j] > 0) {
                    smell[i][j]--;
                }
            }
        }

        //상어가 움직이면서 잡은 물고기 자리에 냄새표시
        for(int i=0;i<3;i++){
            Sx += sDx[dirOrder[i]];
            Sy += sDy[dirOrder[i]];
            if(map[Sx][Sy].size() > 0){
                smell[Sx][Sy] = 2;
                map[Sx][Sy].clear();
            }
        }
    }

    private static void copyFish(ArrayList<Fish>copy) throws CloneNotSupportedException {
        //원래 가지고 있던 물고기  + 복제한 물고기
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                if(map[i][j].size()!=0){
                    for(Fish f : map[i][j]){
                        copy.add(f);
                    }
                }
            }
        }
        fish = (ArrayList<Fish>) copy.clone();
    }

    private static class Fish implements Cloneable{
        int x,y,d;

        public Fish(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public Fish(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        protected Fish clone() throws CloneNotSupportedException {
            return (Fish)super.clone();
        }
    }

}
