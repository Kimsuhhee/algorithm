import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11053 {
    static int n;
    static int[] d = new int[1002];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        //dp();
        LIS();
    }

    private static void LIS() {
        d[0] = 1;
        int max = 0;
        for(int i=1;i<n;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && d[j]+1>d[i])
                    d[i] = d[j]+1;
            }
            if(max<d[i])max = d[i];
        }
        System.out.println(max);
    }

    private static void dp() {
        int ans = 0;
        for(int i=0;i<n;i++){
            d[i] = 1;
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(max,d[j]);
                }
            }
            d[i] = max+1;
            ans = Math.max(d[i],ans);
        }
        System.out.println(ans);
    }
}
