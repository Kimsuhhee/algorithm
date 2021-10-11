import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16929 {
    static int N,M;
    static char[][] board;
    static Info start;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
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
            }
        }

        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    start = new Info(i,j,board[i][j]);
                    visited[i][j] = true;
                    dfs(i,j,1);
                    visited[i][j] = false;
                }
            }
        }
        System.out.println("No");
    }

    private static void dfs(int x, int y, int cnt) {
        for(int i=0;i<4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            //다음 좌표가 범위안에 있으면서 방문 하지 않았고 현재 type과 같은 type인 경우
            if(mx>=0 && my>=0 && mx<N && my<M && !visited[mx][my] && board[mx][my]== start.type) {
                visited[x][y] = true;
                dfs(mx,my,cnt+1);
                visited[x][y] = false;
            }

            //다음좌표가 시작점이면서 점의 개수가 4개이상이면 사이클존재
            if(mx==start.x && my==start.y && cnt>=4){
                System.out.println("Yes");
                System.exit(0);
            }
        }
    }

    private static class Info {
        int x,y;
        char type;

        public Info(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
