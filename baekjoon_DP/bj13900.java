import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13900 {
    static int N;
    static long[] arr, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        arr = new long[N];
        sum = new long[N];

        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(stk.nextToken());
            if(i==0){
                sum[0] = arr[0];
            }
            else {
                sum[i] = (sum[i-1] + arr[i]);
            }
        }

        long answer = 0;
        for(int i=0;i<N;i++){
            answer += (sum[N-1] - sum[i]) * arr[i];
        }
        System.out.println(answer);
    }
}
