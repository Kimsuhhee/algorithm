import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14501 {
    static int N;
    static int[] t, p, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new int[N+15];
        p = new int[N+15];
        d = new int[N+15];

        for(int i=1;i<=N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            t[i] = Integer.parseInt(stk.nextToken());
            p[i] = Integer.parseInt(stk.nextToken());
        }

        int max = 0;
        for(int i=1;i<=N+1;i++){
            max = Math.max(max,d[i]);
            if(t[i]+i<=N+1){
                d[t[i]+i] = Math.max(d[t[i]+i],max+p[i]);
            }
        }

        System.out.println(d[N+1]);
    }
}
