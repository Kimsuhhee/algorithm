import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj11652 {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long card = arr[0];
        int cnt = 1;
        int maxcnt = 1;

        for(int i=1;i<N;i++){
            if(arr[i]==arr[i-1]){
                cnt++;
            }else{
                cnt = 1;
            }

            if(cnt > maxcnt){
                maxcnt = cnt;
                card = arr[i];
            }
        }
        System.out.println(card);
    }
}
