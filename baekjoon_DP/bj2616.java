import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2616 {
    static int N,max;
    static int[]coach,sum;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        coach = new int[N+1];
        sum = new int[N+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            coach[i] = Integer.parseInt(stk.nextToken());
            sum[i] = sum[i-1] + coach[i];
        }
        max = Integer.parseInt(br.readLine());
        d = new int[4][N+1];
        for(int i=1;i<4;i++){
            for(int j=max;j<=N;j++){
                d[i][j] = Math.max(d[i][j-1],d[i-1][j-max]+(sum[j]-sum[j-max]));
            }
        }
        System.out.println(d[3][N]);
    }
}
