import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2098 {
    static int N;
    static int[][] cost,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                cost[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        d = new int[N][(1<<N)-1];
        for(int i=0;i<N;i++){
            Arrays.fill(d[i],10000000);
        }
        System.out.println(dfs(0,1<<0));
    }

    private static int dfs(int node, int S) {

        //마지막정점에서 0번정점으로의 경로유무
        if(S == (1<<N)-1) {
            if(cost[node][0]==0)return 10000000;
            return cost[node][0];
        }

        if(d[node][S]!=10000000){
            return d[node][S];
        }

        for(int i=0;i<N;i++){
            if((S &(1<<i))==0 && cost[node][i]!=0) {
                d[node][S] = Math.min(d[node][S], dfs(i, S |(1<<i)) + cost[node][i]);
            }
        }
        return d[node][S];
    }
}
