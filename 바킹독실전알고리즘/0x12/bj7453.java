import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj7453 {
    static int n;
    static long[]a,b,c,d,sum1,sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new long[n+1];
        b = new long[n+1];
        c = new long[n+1];
        d = new long[n+1];

        StringTokenizer stk;
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(stk.nextToken());
            b[i] = Long.parseLong(stk.nextToken());
            c[i] = Long.parseLong(stk.nextToken());
            d[i] = Long.parseLong(stk.nextToken());
        }

        sum1 = new long[n*n]; //a+b
        sum2 = new long[n*n]; //c+d
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum1[idx] = a[i]+b[j];
                sum2[idx] = c[i]+d[j];
                idx++;
            }
        }
        long cnt = 0;
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        for(int i=0;i<n*n;i++){
            cnt += upperBound(-sum1[i]) - lowerBound(-sum1[i]);
        }
        System.out.println(cnt);
    }

    private static long lowerBound(long key) {
        int st = 0, en = n*n;
        while(st<en){
            int mid = (st + en)/2;
            if(sum2[mid]>=key){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }

    private static long upperBound(long key) {
        int st = 0, en = n*n;
        while(st<en){
            int mid = (st + en)/2;
            if(sum2[mid]>key){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }
}
