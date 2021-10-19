import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13460 {
    static int N,M;
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};
    static char[][]board;
    static Info start = new Info(0,0,0,0,0);
    static Queue<Info>q;
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j]=='B'){
                    start.bx = i; start.by = j;
                }
                if(board[i][j]=='R'){
                    start.rx = i; start.ry = j;
                }
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        q = new LinkedList<>();
        q.add(start);
        visited = new boolean[11][11][11][11];
        visited[start.rx][start.ry][start.bx][start.by] = true;

        while(!q.isEmpty()){
            Info info = q.poll();
            if(info.cnt >= 10) break;
            for(int d=0;d<4;d++){

                boolean rflag = false, bflag = false;
                int rx = info.rx; int ry = info.ry;
                int bx = info.bx; int by = info.by;

                while(true){
                    rx += dx[d];
                    ry += dy[d];
                    if(board[rx][ry]=='#'){
                        rx -= dx[d];
                        ry -= dy[d];
                        break;
                    }
                    if(board[rx][ry]=='O'){
                        rflag = true;
                        break;
                    }
                }
                while(true){
                    bx += dx[d];
                    by += dy[d];
                    if(board[bx][by]=='#'){
                        bx -= dx[d];
                        by -= dy[d];
                        break;
                    }
                    if(board[bx][by]=='O'){
                        bflag = true;
                        break;
                    }
                }

                //파란구슬이 구멍에 들어간경우 순서 다른 방향으로
                if(bflag)continue;

                //빨간구슬만 구멍에 들어간경우 종료
                if(rflag)return info.cnt+1;

                //두 구슬의 위치가 같음
                if(rx==bx && ry==by){
                    if(d==0){
                        if(info.rx>info.bx)rx++;
                        else bx++;
                    }else if(d==1){
                        if(info.rx>info.bx)bx--;
                        else rx--;
                    }else if(d==2){
                        if(info.ry>info.by)ry++;
                        else by++;
                    }else if(d==3){
                        if(info.ry>info.by)by--;
                        else ry--;
                    }
                }
                if(!visited[rx][ry][bx][by]){
                    visited[rx][ry][bx][by] = true;
                    q.add(new Info(rx,ry,bx,by,info.cnt+1));
                }
            }
        }
        return -1;

    }


    private static class Info {
        int rx,ry,bx,by,cnt;

        public Info(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}
