import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[N+1][M+1];
        int[][] sum = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                sum[i][j] = arr[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        while(K-- > 0){
            stk = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stk.nextToken());
            int j = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            System.out.println(sum[x][y]-sum[x][j-1]-sum[i-1][y]+sum[i-1][j-1]);
        }
    }
}
