import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2512 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        System.out.println(Math.min(M,binarySearch()));
    }

    private static int binarySearch() {
        int st = 1;
        int en = arr[N-1];
        int m = 0;
        while(st<=en){
            int mid = (st+en)/2;
            int money = 0;
            for(int i=0;i<N;i++){
                if(arr[i]<mid)money+=arr[i];
                else money+=mid;
            }
            if(money<=M){
                m = mid;
                st = mid+1;
            }else
                en = mid-1;
        }
        return m;
    }
}
