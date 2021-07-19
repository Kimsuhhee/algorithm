import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1912 {
    static int n;
    static int[] arr;
    static int[] d = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dp();
    }

    private static void dp() {
        d[1] = arr[1];
        int m = d[1];
        for(int i=2;i<=n;i++){
            d[i] = Math.max(d[i-1] + arr[i],arr[i]);
            m = Math.max(m,d[i]);
        }
        System.out.println(m);
    }
}
