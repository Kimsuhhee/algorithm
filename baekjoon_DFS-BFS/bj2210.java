import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj2210 {
    static int N = 6;
    static HashSet<String>set = new HashSet<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] numbers = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        for(int i=0;i<5;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                numbers[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                dfs("",i,j,0);
            }
        }
        System.out.println(set.size());

    }

    private static void dfs(String s, int x, int y, int n) {
        if(n==N){
            set.add(s);
            return;
        }

        for(int i=0;i<4;i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx<0||my<0||mx>=5||my>=5)continue;
            dfs(s+numbers[x][y],mx,my,n+1);
        }
    }
}
