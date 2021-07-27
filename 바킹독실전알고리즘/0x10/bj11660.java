import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11660 {
    static int N,M,x1,y1,x2,y2;
    static int[][] arr,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N+1][N+1];
        d = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                d[i][j] = d[i-1][j] + d[i][j-1] -d[i-1][j-1] + arr[i][j];
            }
        }

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            x1 = Integer.parseInt(stk.nextToken());
            y1 = Integer.parseInt(stk.nextToken());
            x2 = Integer.parseInt(stk.nextToken());
            y2 = Integer.parseInt(stk.nextToken());

            System.out.println(d[x2][y2]-d[x2][y1-1]-d[x1-1][y2]+d[x1-1][y1-1]);
        }


    }
}
