import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1932 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[][] arr = new int[501][501];
    static int[][] d = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<i+1;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp();
        System.out.println(max);

    }

    private static void dp() {
        d[0][0] = arr[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i+1;j++){
                if(j==0){
                    d[i][j] = d[i-1][j] + arr[i][j];
                } else if(j==i){
                    d[i][j] = d[i-1][j-1] + arr[i][j];
                }else{
                    d[i][j] = Math.max(d[i-1][j-1],d[i-1][j]) + arr[i][j];
                }

                if(i==n-1){
                    max = Math.max(d[i][j],max);
                }

            }
        }
    }
}
