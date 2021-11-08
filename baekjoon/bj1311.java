import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1311 {
    static int N;
    static int[][] cost,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        cost = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                cost[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        d = new int[N][(1<<N)];
        for(int i=0;i<N;i++){
            Arrays.fill(d[i],-1);
        }
        System.out.println(dfs(0,0));
    }

    private static int dfs(int node, int S) {
        if(node==N || S == (1<<N)-1){
            return 0;
        }

        if(d[node][S]!=-1){
            return d[node][S];
        }
        d[node][S] = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if((S &(1<<i))==0 && cost[node][i]!=0){
                d[node][S] = Math.min(d[node][S],dfs(node+1,S |(1<<i))+cost[node][i]);
            }
        }
        return d[node][S];
    }
}
