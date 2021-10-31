import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2174 {
    static int A,B,N,M;
    static int[][]area;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Robot[]robots;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        area = new int[B][A];

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        robots = new Robot[N+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(stk.nextToken())-1;
            int x = Integer.parseInt(stk.nextToken())-1;
            char dir = stk.nextToken().charAt(0);

            area[B-x-1][y] = i;

            if(dir=='W') robots[i] = new Robot(B-x-1,y,1);
            else if(dir=='N') robots[i] = new Robot(B-x-1,y,2);
            else if(dir=='E') robots[i] = new Robot(B-x-1,y,0);
            else if(dir=='S') robots[i] = new Robot(B-x-1,y,3);

        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            char command = stk.nextToken().charAt(0);
            int times = Integer.parseInt(stk.nextToken());
            simulation(num,command,times);
        }
        System.out.println("OK");
    }

    private static void simulation(int num, char command, int times) {
        for(int t=0;t<times;t++){
            if(command=='L'||command=='R'){
                int d = robots[num].dir;
                robots[num].dir = changeDir(command,d);
            }else if(command=='F'){
                int cx = robots[num].x;
                int cy = robots[num].y;
                int dir = robots[num].dir;

                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx<0||ny<0||nx>=B||ny>=A){
                    System.out.println("Robot "+num+" crashes into the wall");
                    System.exit(0);
                }
                if(area[nx][ny]!=0){
                    System.out.println("Robot "+num+" crashes into robot "+area[nx][ny]);
                    System.exit(0);
                }
                robots[num].x = nx;
                robots[num].y = ny;
                area[cx][cy] = 0;
                area[nx][ny] = num;
            }
        }
    }

    private static int changeDir(char command, int d) {
        if(command=='L'){
            if(d==0) return 2;
            if(d==1) return 3;
            if(d==2) return 1;
            if(d==3) return 0;
        }else if(command=='R'){
            if(d==0) return 3;
            if(d==1) return 2;
            if(d==2) return 0;
            if(d==3) return 1;
        }
        return 0;
    }

    private static class Robot {
        int x,y,dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
