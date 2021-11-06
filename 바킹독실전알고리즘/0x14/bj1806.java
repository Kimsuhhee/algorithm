import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806 {
    static int N,S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int en = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        for(int st=0;st<N;st++){
            while(en<N && sum<S){
                en++;
                if(en!=N) sum+=arr[en];
            }
            if(en==N)break;
            min = Math.min(min,en-st+1);
            sum-=arr[st];
        }
        if(min==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);

    }
}
