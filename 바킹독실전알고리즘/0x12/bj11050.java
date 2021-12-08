import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11050 {
    static int N,K;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        d = new int[11][11];
        d[0][0] = 1;
        d[1][0] = d[1][1] = 1;
        for(int i=2;i<11;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i)d[i][j] = 1;
                else d[i][j] = d[i-1][j-1] + d[i-1][j];
            }
        }
        System.out.println(d[N][K]);
    }
}
