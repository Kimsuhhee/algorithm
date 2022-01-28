import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj7579 {
    static int N,M;
    static int[] memory, cost;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        memory = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            memory[i] = Integer.parseInt(stk.nextToken());
        }

        cost = new int[N+1];
        int tot = 0;
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            cost[i] = Integer.parseInt(stk.nextToken());
            tot += cost[i];
        }

        d = new int[N+1][tot+1];

        for(int i=1;i<=N;i++){
            for(int j=0;j<=tot;j++){
                if(j-cost[i]>=0) {
                    d[i][j] = Math.max(d[i][j], d[i-1][j - cost[i]]+memory[i]);
                }
                d[i][j] = Math.max(d[i][j], d[i-1][j]);
            }
        }

        int answer = 0;
        for(int i=1;i<=tot;i++){
            if(d[N][i]>=M) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}
