import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15486 {
    static int N;
    static int[] t, p, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        t = new int[N+2];
        p = new int[N+2];
        d = new int[N+2];

        StringTokenizer stk;
        for(int i = 1 ; i <= N ; i++){
            stk = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(stk.nextToken());
            p[i] = Integer.parseInt(stk.nextToken());
        }

        int max = -1;
        for(int i = 1 ; i <= N + 1 ; i++){
            max = Math.max(max,d[i]);
            if(i + t[i] > N + 1) continue;
            d[i+t[i]] = Math.max(d[i+t[i]],max + p[i]);
//            System.out.println(i+t[i]+"일");
//            System.out.println(d[i+t[i]]);
        }
        System.out.println(max);
    }
}
