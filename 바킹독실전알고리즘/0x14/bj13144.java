import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13144 {
    static int N;
    static int[] arr,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        long cnt = 0;
        count = new int[100001];

        int en = 0;
        for(int st=0;st<N;st++){
            while(en<N && count[arr[en]]<1){
                count[arr[en]]++;
                en++;
            }
            cnt += en-st;
            count[arr[st]]--;
        }
        System.out.println(cnt);
    }
}
