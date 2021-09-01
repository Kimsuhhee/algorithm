import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10816 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(stk.nextToken());
            int l = lower_index(num);
            int u = upper_index(num);
            System.out.print(u-l+" ");
        }
    }

    private static int upper_index(int num) {
        int st = 0, en = arr.length;
        while(st<en){
            int mid = (st+en)/2;
            if(arr[mid]>num) en = mid;
            else st = mid+1;
        }
        return  en;
    }

    private static int lower_index(int num) {
        int st = 0, en = arr.length;
        while(st<en){
            int mid = (st+en)/2;
            if(arr[mid]>=num)en = mid;
            else st = mid+1;
        }
        return en;
    }
}
