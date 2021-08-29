import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17143 {
    static int R,C,M,r,c,s,d,z;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,1,-1};
    static Shark[] sharks;
    static int[][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        sharks = new Shark[M+1];
        map = new int[R+1][C+1];
        if(M==0) {
            System.out.println(0);
            return;
        }
        for(int i=1;i<=M;i++){
            stk = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            s = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
            z = Integer.parseInt(stk.nextToken());
            sharks[i] = new Shark(r,c,s,d,z,false);
        }
        for(int i=1;i<=M;i++){
            Shark s = sharks[i];
            map[s.x][s.y] = i;
        }
        int start = 0;
        int answer = 0;

        while(start<C){
            start++;
            answer += fish(start);
            move();
        }
        System.out.println(answer);
    }

    private static void move() {
        int[][] temp = new int[R+1][C+1];

        for(int i=1;i<=M;i++){
            if(sharks[i].remove==false){
                Shark cur = sharks[i];
                int k = cur.s;
                while(k-- > 0){ //속력만큼 이동
                    if((cur.x==1 && cur.d==1)||(cur.y==1 && cur.d==4)||(cur.x==R && cur.d==2)||(cur.y==C && cur.d==3)){
                        cur.d = changeDirection(cur.d);
                    }
                    cur.x += dx[cur.d];
                    cur.y += dy[cur.d];
                }
                if(temp[cur.x][cur.y]==0){
                    temp[cur.x][cur.y] = i;
                }else{
                    if(sharks[temp[cur.x][cur.y]].z<cur.z){
                        sharks[temp[cur.x][cur.y]].remove = true;
                        map[cur.x][cur.y] = 0;
                        temp[cur.x][cur.y] = i;
                    }else{
                        cur.remove = true;
                    }
                }
            }
        }
        for(int i=1;i<=R;i++){
            for(int j=1;j<=C;j++){
                map[i][j] = temp[i][j];
            }
        }

    }

    private static int changeDirection(int d) {
        if(d==1) return 2;
        if(d==2) return 1;
        if(d==3) return 4;
        if(d==4) return 3;
        return 0;
    }

    private static int fish(int y) {
        for(int x=1;x<=R;x++){
            if(map[x][y]!=0){
                Shark s = sharks[map[x][y]];
                s.remove = true;
                map[x][y] = 0;
                return s.z;
            }
        }

        return 0;
    }

    private static class Shark {
        int x,y,s,d,z;
        boolean remove;

        public Shark(int x, int y, int s, int d, int z, boolean remove) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
            this.remove = remove;
        }
    }
}
