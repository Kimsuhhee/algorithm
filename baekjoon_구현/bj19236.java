import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19236 {
    static int max = -10;
    static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] number = new int[4][4];
        Fish[] fish = new Fish[17];
        for(int i=0;i<4;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                int num = Integer.parseInt(stk.nextToken());
                int dir = Integer.parseInt(stk.nextToken());
                fish[num] = new Fish(num,i,j,dir,false);
                number[i][j] = num;
            }
        }

        Shark shark = new Shark(0,0,fish[number[0][0]].dir,number[0][0]);
        fish[number[0][0]].remove = true;
        number[0][0] = -1;
        dfs(shark,fish,number);

        System.out.println(max);
    }

    private static void dfs(Shark shark, Fish[] fish, int[][] number) {

        max = Math.max(max,shark.sum);
        fishMove(fish,number);

        int x = shark.x; int y = shark.y;
        for(int i=1;i<=3;i++) {
            x += dx[shark.dir];
            y += dy[shark.dir];
            if (x >= 0 && y >= 0 && x < 4 && y < 4 && number[x][y] > 0) {
                int[][] arr = copyArr(number);
                Fish[] fish1 = new Fish[17];
                for(int f=1;f<=16;f++){
                    fish1[f] = new Fish(f,fish[f].x,fish[f].y,fish[f].dir,fish[f].remove);
                }
                int e = arr[x][y];
                fish1[arr[x][y]].remove = true;
                arr[x][y] = -1;
                arr[shark.x][shark.y] = 0;
                Shark shark1 = new Shark(x,y,fish1[e].dir,shark.sum+e);
                dfs(shark1,fish1,arr);
            }
        }
    }

    private static int[][] copyArr(int[][] number) {
        int[][] temp = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                temp[i][j] = number[i][j];
            }
        }
        return temp;
    }

    private static void fishMove(Fish[] fish, int[][] number) {
        for(int i=1;i<=16;i++){
            if(fish[i].remove==true)continue;
            Fish cur = fish[i];
            int dir = cur.dir;
            while(true) {
                int mx = cur.x + dx[dir];
                int my = cur.y + dy[dir];
                if(mx<0||my<0||mx>=4||my>=4||number[mx][my]==-1){
                    dir = (dir%8)+1;
                    continue;
                }
                if (number[mx][my] == 0) { //해당 칸에 아무도 없을때
                    number[mx][my] = i;
                    number[cur.x][cur.y] = 0;
                    cur.x = mx; cur.y = my;
                    cur.dir = dir;
                    break;
                } else { //다른 물고기가 있는 경우
                    Fish temp = fish[number[mx][my]];
                    number[mx][my] = i;
                    number[cur.x][cur.y] = temp.num;
                    temp.x = cur.x; temp.y = cur.y;
                    cur.x = mx; cur.y = my; cur.dir = dir;
                    break;
                }
            }
        }
    }

    private static class Fish {
        int num,x,y,dir;
        boolean remove = false;

        public Fish(int num,int x, int y, int dir, boolean remove) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.remove = remove;
        }
    }

    private static class Shark {
        int x,y,dir,sum;

        public Shark(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }
    }
}
