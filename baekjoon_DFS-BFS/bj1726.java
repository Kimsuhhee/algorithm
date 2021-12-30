import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1726 {
    static int M,N;
    static int[][]state;
    static int[] dx = {0,0,1,-1}; //동,서,남,북
    static int[] dy = {1,-1,0,0};
    static Info start,end;
    static Queue<Info>q;
    static boolean[][][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        state = new int[M][N];
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                state[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        start = new Info(m-1,n-1,d-1,0);

        stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        end = new Info(m-1,n-1,d-1,0);

        q = new LinkedList<>();
        visited = new boolean[4][M][N];

        q.add(start);
        visited[start.dir][start.x][start.y] = true;

        while(!q.isEmpty()){
            Info cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cd = cur.dir;
            if(cx==end.x && cy==end.y && cd==end.dir){
                System.out.println(cur.cnt);
                break;
            }
            //명령 1
            for(int k=1;k<4;k++){
                if(cd==0){
                    if(cy+k<N && !visited[cd][cx][cy+k]){
                        //k칸 이동시 중간에 이동할 수 없는 칸이 있다면 반복문 탈출
                        if(state[cx][cy+k]==1)break;
                        visited[cd][cx][cy+k] = true;
                        q.add(new Info(cx,cy+k,cd,cur.cnt+1));
                    }
                }else if(cd==1){
                    if(cy-k>=0 && !visited[cd][cx][cy-k]){
                        if(state[cx][cy-k]==1)break;
                        visited[cd][cx][cy-k] = true;
                        q.add(new Info(cx,cy-k,cd,cur.cnt+1));
                    }
                }else if(cd==2){
                    if(cx+k<M && !visited[cd][cx+k][cy]){
                        if(state[cx+k][cy]==1)break;
                        visited[cd][cx+k][cy] = true;
                        q.add(new Info(cx+k,cy,cd,cur.cnt+1));
                    }
                }else if(cd==3){
                    if(cx-k>=0 && !visited[cd][cx-k][cy]){
                        if(state[cx-k][cy]==1)break;
                        visited[cd][cx-k][cy] = true;
                        q.add(new Info(cx-k,cy,cd,cur.cnt+1));
                    }
                }
            }

            //명령 2
            int turnLeftDir = turnLeft(cd);
            if(!visited[turnLeftDir][cx][cy]){
                visited[turnLeftDir][cx][cy] = true;
                q.add(new Info(cx,cy,turnLeftDir,cur.cnt+1));
            }
            int turnRightDir = turnRight(cd);
            if(!visited[turnRightDir][cx][cy]){
                visited[turnRightDir][cx][cy] = true;
                q.add(new Info(cx,cy,turnRightDir,cur.cnt+1));
            }
        }
    }

    private static int turnRight(int cd) {
        int dir = 0;
        if(cd==0) dir = 2;
        else if(cd==2) dir = 1;
        else if(cd==1) dir = 3;
        else if(cd==3) dir = 0;
        return dir;
    }

    private static int turnLeft(int cd) {
        int dir = 0;
        if(cd==0) dir = 3;
        else if(cd==1) dir = 2;
        else if(cd==2) dir = 0;
        else if(cd==3) dir = 1;
        return dir;
    }

    private static class Info {
        int x,y,dir,cnt;

        public Info(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
