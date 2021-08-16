import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13305 {
    static int N;
    static long[] len;
    static long[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        len = new long[N-1];
        cost = new long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N-1;i++)
            len[i] = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            cost[i] = Integer.parseInt(stk.nextToken());

        long min = cost[0];
        for(int i=1;i<N;i++){
            if(min>cost[i])min = cost[i];
            else cost[i] = min;
        }

        long sum = 0;
        for(int i=0;i<N-1;i++){
            sum +=(len[i]*cost[i]);
        }
        System.out.println(sum);

    }
}
