import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2003 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int cnt = 0;
        int sum = arr[0];
        int en = 0;
        for(int st=0;st<N;st++){
            while(sum<M && en<N-1){
                en++;
                sum += arr[en];
            }
            if(sum>=M){
                if(sum==M)cnt++;
                sum -= arr[st];
            }
        }
        System.out.println(cnt);
    }
}
