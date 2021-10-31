import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16401 {
    static int M,N;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        snack = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            snack[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(snack);
        System.out.println(find());
    }

    private static int find() {
        int st = 1, en = snack[N-1];
        int ans = 0;
        while(st<=en){
            int mid = (st+en)/2;
            int cnt = 0;
            for(int i=0;i<N;i++){
                cnt += snack[i]/mid;
            }
            if(cnt>=M){
                ans = mid;
                st = mid+1;
            }else{
                en = mid-1;
            }
        }
        return ans;
    }
}
