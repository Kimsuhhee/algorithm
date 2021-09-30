import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13398 {
    static int n;
    static int[] arr;
    static int[][]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(stk.nextToken());
        d = new int[n][2];
        d[0][0] = arr[0]; //숫자를 제거하지 않은경우
        d[0][1] = arr[0]; //숫자하나를 제거한 경우
        int max = arr[0];
        for(int i=1;i<n;i++){
            d[i][0] = Math.max(d[i-1][0]+arr[i],arr[i]);
            d[i][1] = Math.max(d[i-1][1]+arr[i],d[i-1][0]); 
            max = Math.max(d[i][1],Math.max(max,d[i][0]));
        }
        System.out.println(max);
    }
}
