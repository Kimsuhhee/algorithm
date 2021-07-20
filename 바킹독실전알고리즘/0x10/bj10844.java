import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10844 {
    static int N;
    static long d[][] = new long[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp();
        long sum = 0;
        for(int i=0;i<10;i++){
            sum  = (sum + d[N][i]) % 1000000000;
        }
        System.out.println(sum);
    }

    private static void dp() {
        d[1][1]=1; d[1][2]=1; d[1][3]=1;
        d[1][4]=1; d[1][5]=1; d[1][6]=1;
        d[1][7]=1; d[1][8]=1; d[1][9]=1;
        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    d[i][j] = d[i-1][j+1] % 1000000000;
                }else if(j==9){
                    d[i][j] = d[i-1][j-1] % 1000000000;
                }else{
                    d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % 1000000000;
                }
            }
        }
    }
}
