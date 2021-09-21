import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj1987 {
    static int R,C;
    static int answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static HashSet<Character>set;
    static boolean[][] visited;
    static char[][]board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        board = new char[R][C];
        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = s.charAt(j);
            }
        }

        set = new HashSet<>();
        visited = new boolean[R][C];
        set.add(board[0][0]);
        visited[0][0] = true;
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        answer = Math.max(answer,set.size());
        for(int i=0;i<4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx<0||my<0||mx>=R||my>=C)continue;
            if(visited[mx][my])continue;
            if(!set.contains(board[mx][my])){
                visited[mx][my] = true;
                set.add(board[mx][my]);
                dfs(mx,my);
                set.remove(board[mx][my]);
                visited[mx][my] = false;
            }
        }
    }
}
