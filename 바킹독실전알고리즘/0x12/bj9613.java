import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9613 {
    static int t,n;
    static int[] arr;
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            sum = 0;
            stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    sum += gcd(arr[i],arr[j]);
                }
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }

    private static long gcd(int a, int b) {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
