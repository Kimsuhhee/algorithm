import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10835 {
    static int N; //카드 더미 개수
    static int max;
    static int[][] cards; //0->왼쪽, 1->오른쪽
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[2][N];
        for(int i=0;i<2;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                cards[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        d = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                d[i][j] = -1;
            }
        }
        System.out.println(dp(0,0));
    }

    private static int dp(int l,int r) {
        if(l>=N || r>=N)return 0;
        if(d[l][r]!=-1)return d[l][r];
        d[l][r] = Math.max(dp(l+1,r),dp(l+1,r+1));
        if(cards[0][l]>cards[1][r]) {
            d[l][r] = Math.max(d[l][r],cards[1][r]+dp(l,r+1));
        }
        return d[l][r];
    }
}
