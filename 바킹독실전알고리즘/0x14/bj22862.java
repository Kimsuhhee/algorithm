import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj22862 {
    static int N,K;
    static int[] arr;
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

        int en = 0;
        int len = 0, odd = 0;
        for(int st=0;st<N;st++){
            while(en<N && odd<=K){
                if(arr[en++]%2==1)odd++;
            }
            len = Math.max(len,en-st-odd);
            if(arr[st]%2==1)odd--;
        }
        System.out.println(len);
    }
}
