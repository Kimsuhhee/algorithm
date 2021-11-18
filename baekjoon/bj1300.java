import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1300 {
    static long N,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());
        System.out.println(binarySearch(1,N*N));
    }

    private static long binarySearch(long st, long en) {
        long res = 0;
        while(st<=en){
            long mid = (st+en)/2;
            long cnt = 0;
            for(int i=1;i<=N;i++){
                cnt += Math.min(mid/i,N);
            }
            if(cnt<k){
                st = mid + 1;
            }else {
                res = mid;
                en = mid - 1;
            }
        }
        return res;
    }
}
