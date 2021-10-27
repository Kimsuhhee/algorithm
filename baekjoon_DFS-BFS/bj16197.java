import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16197 {
    static int N,M;
    static char[][] board;
    static Info start;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][][][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        board = new char[N][M];
        boolean pre = false;
        
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                board[i][j] = s.charAt(j);
                if(board[i][j]=='o' && !pre){
                    start = new Info(i,j,0,0,0);
                    pre = true;
                }else if(board[i][j]=='o' && pre){
                    start.x2 = i; start.y2 = j;
                }
            }
        }

        Queue<Info>q = new LinkedList<>();
        q.add(start);
        visited = new boolean[21][21][21][21];
        visited[start.x1][start.y1][start.x2][start.y2] = true;

        int answer = -1;

        while(!q.isEmpty()){
            Info info = q.poll();
            if(info.cnt>=10)break;
            for(int d=0;d<4;d++){
                boolean flag1 = false, flag2 = false;
                int nx1 = info.x1 + dx[d];
                int ny1 = info.y1 + dy[d];

                int nx2 = info.x2 + dx[d];
                int ny2 = info.y2 + dy[d];

                if(nx1<0||ny1<0||nx1>=N||ny1>=M){
                    flag1 = true;
                }
                if(nx2<0||ny2<0||nx2>=N||ny2>=M){
                    flag2 = true;
                }

                if(flag1 && flag2)continue;

                if(flag1 && !flag2 || !flag1 && flag2){
                    answer = info.cnt+1;
                    System.out.println(answer);
                    System.exit(0);
                }

                if(board[nx1][ny1]=='#') {
                    nx1 -= dx[d];
                    ny1 -= dy[d];
                }

                if(board[nx2][ny2]=='#') {
                    nx2 -= dx[d];
                    ny2 -= dy[d];
                }

                if(!visited[nx1][ny1][nx2][ny2]){
                    q.add(new Info(nx1,ny1,nx2,ny2,info.cnt+1));
                    visited[nx1][ny1][nx2][ny2] = true;
                }
            }
        }
        System.out.println(answer);

    }

    private static class Info {
        int x1,y1,x2,y2,cnt;

        public Info(int x1, int y1, int x2, int y2,int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cnt = cnt;
        }
    }
}
