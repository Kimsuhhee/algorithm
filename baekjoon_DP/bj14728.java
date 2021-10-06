import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14728 {
    static int N,T;
    static int[]k,s;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());

        k = new int[N+1];
        s = new int[N+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            k[i] = Integer.parseInt(stk.nextToken());
            s[i] = Integer.parseInt(stk.nextToken());
        }
        d = new int[N+1][T+1];
        for(int i=1;i<=N;i++){
            for(int t=1;t<=T;t++){
                if(k[i]>t)d[i][t] = d[i-1][t];
                else d[i][t] = Math.max(d[i-1][t-k[i]]+s[i],d[i-1][t]);
            }
        }
        System.out.println(d[N][T]);
    }
}
