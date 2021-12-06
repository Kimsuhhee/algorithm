import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2143 {
    static long T;
    static int n,m;
    static int[]A,B;
    static ArrayList<Long>aSum,bSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(stk.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            B[i] = Integer.parseInt(stk.nextToken());
        }

        aSum = new ArrayList<>();
        for(int i=0;i<n;i++){
            long sum = A[i];
            aSum.add(sum);
            for(int j=i+1;j<n;j++){
                sum += A[j];
                aSum.add(sum);
            }
        }

        bSum = new ArrayList<>();
        for(int i=0;i<m;i++){
            long sum = B[i];
            bSum.add(sum);
            for(int j=i+1;j<m;j++){
                sum += B[j];
                bSum.add(sum);
            }
        }
        Collections.sort(aSum);
        Collections.sort(bSum);
        long ans = 0;
        for(int i=0;i<aSum.size();i++){
            ans += upper_bound(T- aSum.get(i),bSum.size()) - lower_bound(T- aSum.get(i),bSum.size());
        }
        System.out.println(ans);
    }

    private static long upper_bound(long target, int en) {
        int st = 0;
        while(st<en){
            int mid = (st + en)/2;
            if(bSum.get(mid)>target){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }

    private static long lower_bound(long target, int en) {
        int st = 0;
        while(st<en){
            int mid = (st + en)/2;
            if(bSum.get(mid)>=target){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }
}
