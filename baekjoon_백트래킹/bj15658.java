import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15658 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[]op = new int[4];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(arr[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int sum, int n) {
        if(n==N){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }
        for(int i=0;i<4;i++){
            if(op[i]>0){
                op[i]--;
                if(i==0) dfs(sum+arr[n],n+1);
                if(i==1) dfs(sum-arr[n],n+1);
                if(i==2) dfs(sum*arr[n],n+1);
                if(i==3) dfs(sum/arr[n],n+1);
                op[i]++;
            }
        }
    }
}
