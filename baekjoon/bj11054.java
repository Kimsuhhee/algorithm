import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11054 {
    static int N;
    static int[]arr,lis,lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        lis = new int[N];
        lis[0] = 1;
        for(int i=1;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<=i;j++){
                if(arr[i]>arr[j]){
                    lis[i] = Math.max(lis[j]+1,lis[i]);
                }
            }
        }
        lds = new int[N];
        lds[N-1] = 1;
        for(int i=N-2;i>=0;i--){
            lds[i] = 1;
            for(int j=N-1;j>=i;j--){
                if(arr[i]>arr[j]){
                    lds[i] = Math.max(lds[j]+1,lds[i]);
                }
            }
        }

        int ans = -1;
        for(int i=0;i<N;i++){
            ans = Math.max(ans,lis[i]+lds[i]);
        }
        System.out.println(ans-1);

    }
}
