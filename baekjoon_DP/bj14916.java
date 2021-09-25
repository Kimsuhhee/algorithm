import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj14916 {
    static int[] coins = {2,5};
    static int[]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        Arrays.fill(d,1000000);
        d[0] = 0;
        for(int i=0;i<2;i++){
            int coin = coins[i];
            for(int j=coin;j<=n;j++){
                d[j] = Math.min(d[j],d[j-coin]+1);
            }
        }
        if(d[n]==1000000) System.out.println(-1);
        else System.out.println(d[n]);
    }
}
