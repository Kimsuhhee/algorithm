import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2624 {
    static int T,k;
    static int[][]d;
    static Coin[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        coins = new Coin[k];
        StringTokenizer stk;
        for(int i=0;i<k;i++){
            stk = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            coins[i] = new Coin(p,n);
        }
        Arrays.sort(coins);

        d = new int[k][T];
        for(int i=0;i<k;i++){
            for(int j=0;j<T;j++){
                d[i][j] = -1;
            }
        }
        System.out.println(dp(0,0));
    }

    private static int dp(int idx, int p) {
        if(p==T) return 1;
        if(idx>=k)return 0;
        if(d[idx][p]!=-1) return d[idx][p];
        d[idx][p] = 0;
        for(int i=0;i<=coins[idx].cnt;i++){
            if(p+(coins[idx].price*i)<=T) {
                d[idx][p] += dp(idx+1,p+(coins[idx].price*i));
            }
        }
        return d[idx][p];
    }

    private static class Coin implements Comparable<Coin> {
        int price,cnt;

        public Coin(int price, int cnt) {
            this.price = price;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Coin o) {
            return this.price-o.price;
        }
    }
}
