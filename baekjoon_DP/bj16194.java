import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16194 {
    static int N;
    static int[] card,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            card[i] = Integer.parseInt(stk.nextToken());
        }
        d = new int[N+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0]=0;
        for(int i=1;i<=N;i++){
            for(int j=i;j<=N;j++){
                d[j] = Math.min(d[j],d[j-i]+card[i]);
            }
        }
        System.out.println(d[N]);
    }
}
