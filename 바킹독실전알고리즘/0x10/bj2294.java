import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2294 {
    static int n,k;
    static int[] d,coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        d = new int[k+1];
        for(int i=0;i<=k;i++) d[i] = 10005;
        coin = new int[n+1];
        for(int i=1;i<=n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        d[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=coin[i];j<=k;j++){
                d[j] = Math.min(d[j],d[j-coin[i]]+1);
            }
        }
        if(d[k]==10005) System.out.println(-1);
        else System.out.println(d[k]);

    }

}
