import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11052 {
    static int N;
    static int[] arr,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        d = new int[N+1];

        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dp();
        System.out.println(d[N]);

    }

    private static void dp() {
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                d[i] = Math.max(d[i-j]+arr[j],d[i]);
            }
        }
    }
}
