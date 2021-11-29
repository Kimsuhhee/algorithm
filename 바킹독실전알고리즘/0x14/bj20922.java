import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20922 {
    static int N,K;
    static int[] arr,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        count = new int[200001];
        int st = 0, en = 0;
        count[arr[en]] = 1;
        int max = Integer.MIN_VALUE;
        while(st<N && en<N){
            if(count[arr[en]]<=K){
                max = Math.max(max,en-st+1);
                en++;
                if(en==N)break;
                count[arr[en]]++;
            }else{
                while(st<=en && count[arr[en]]>K){
                    count[arr[st]]--;
                    st++;
                }
            }
        }
        System.out.println(max);
    }
}
