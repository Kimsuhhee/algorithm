import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2352 {
    static int n;
    static int[] arr,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        d = new int[n];
        d[0] = arr[0];

        int idx = 0;
        for(int i=1;i<n;i++){
            //d의 마지막 값보다 새로운 값이 크면 d[idx+1]자리에 넣기 
            if(d[idx] < arr[i]){
                d[++idx] = arr[i];
            }else{
                //새로운 값이 들어갈 수 있는 자리에 넣기 
                int nIdx = lower_bound(idx,arr[i]);
                d[nIdx] = arr[i];
            }
        }

        System.out.println(idx+1);
    }

    private static int lower_bound(int idx, int key) {
        int st = 0, en = idx+1;
        while(st<en){
            int mid = (st + en)/2;
            if(d[mid]>=key){
                en = mid;
            }else {
                st = mid + 1;
            }
        }
        return en;
    }
}
