import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj3151 {
    static int N;
    static int[] ability;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ability[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(ability);

        long ans = 0;
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                int sum = ability[i] + ability[j];
                int lb = lowerBound(j,0-sum);
                int ub = upperBound(j,0-sum);
                ans += ub-lb;
            }
        }
        System.out.println(ans);
    }

    private static int upperBound(int j,int key) {
        int st = j+1;
        int en = N;
        while(st<en){
            int mid = (st+en)/2;
            if(ability[mid]>key){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }

    private static int lowerBound(int j,int key) {
        int st = j+1;
        int en = N;
        while(st<en){
            int mid = (st+en)/2;
            if(ability[mid]>=key){
                en = mid;
            }else st = mid + 1;
        }
        return en;
    }
}
