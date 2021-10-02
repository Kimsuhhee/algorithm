import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj15989 {
    static int T,n;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        d = new int[10001][4];
        dp();
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i=1;i<=3;i++){
                sum+=d[n][i];
            }
            System.out.println(sum);
        }

    }

    private static void dp() {
        d[1][1] = 1;
        d[2][1] = 1; d[2][2] = 1;
        d[3][1] = 1; d[3][2] = 1; d[3][3] = 1;
        for(int i=4;i<=10000;i++){
            d[i][1] = d[i-1][1];
            d[i][2] = d[i-2][1]+d[i-2][2];
            d[i][3] = d[i-3][1]+d[i-3][2]+d[i-3][3];
        }
    }
}
