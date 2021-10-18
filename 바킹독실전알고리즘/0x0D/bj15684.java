import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15684 {
    static int N,M,H,ans;
    static boolean[][]ladder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());
        ladder = new boolean[H+1][N+1];
        if(M==0){
            System.out.println(0);
            System.exit(0);
        }
        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            ladder[a][b] = true;
        }
        ans = 4;
        dfs(0,1,1);
        if(ans==4) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void dfs(int idx, int x, int y) {
        if(idx>=ans)return;
        if(check()) ans = Math.min(ans,idx);
        if(idx==3)return;
        for(int i=x;i<=H;i++){
            for(int j=y;j<N;j++){
                if(!ladder[i][j] && !ladder[i][j+1] && !ladder[i][j-1]){
                    ladder[i][j] = true;
                    dfs(idx+1,i,j);
                    ladder[i][j] = false;
                }
            }
            y=1;
        }
    }

    private static boolean check() {
        for(int y=1;y<N;y++){
            int cur = y;
            for(int x=1;x<=H;x++){
                if(ladder[x][cur])cur++;
                else if(ladder[x][cur-1])cur--;
            }
            if(cur!=y)return false;
        }
        return true;
    }
}
