import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2295 {
    static int N;
    static long[] arr;
    static ArrayList<Long>sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        sum = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                sum.add(arr[i]+arr[j]);
            }
        }
        Collections.sort(sum);
        long max = Long.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(binarySearch(arr[j]-arr[i])) {
                    max = Math.max(max,arr[j]);
                }
            }
        }
        System.out.println(max);
    }

    private static boolean binarySearch(long key) {
        int st = 0, en = sum.size()-1;
        while(st<=en){
            int mid =(st + en)/2;
            if(sum.get(mid)<key){
                st = mid + 1;
            }else if(sum.get(mid)>key){
                en = mid - 1;
            }else return true;
        }
        return false;
    }
}
