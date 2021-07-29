import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11055 {
    static int N;
    static int[]d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N]; //현재 인덱스까지의 합 중에 가장 큰 경우의 합
        String[] arr = br.readLine().split(" ");
        int ans = -1;
        for(int i=0;i<N;i++){
            d[i] = Integer.parseInt(arr[i]);
            int max = 0;
            for(int j=0;j<=i;j++){
                if(Integer.parseInt(arr[j])<Integer.parseInt(arr[i])){
                    max = Math.max(max,d[j]);
                }
            }
            d[i]+=max;
            ans = Math.max(ans,d[i]);
        }
        System.out.println(ans);
    }
}
