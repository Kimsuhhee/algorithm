import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2225 {
    static long[][] d = new long[201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        dp();
        System.out.println(d[N][K]);
    }

    private static void dp() {
        for(int i=1;i<=200;i++){
            d[i][1] = 1;
        }
        for(int i=1;i<=200;i++){
            d[0][i] = 1;
        }
        for(int i=1;i<=200;i++){
            for(int j=2;j<=200;j++){
                d[i][j] = (d[i-1][j]+d[i][j-1])%1000000000;
            }
        }
    }
}
