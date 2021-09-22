import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11722 {
    static int N;
    static int[] arr,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        d[0] = 1;
        int max = d[0];

        for(int i=1;i<N;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
            max = Math.max(max,d[i]);
        }
        System.out.println(max);
    }
}
