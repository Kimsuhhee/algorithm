import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1654 {
    static int k,n;
    static int[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        line = new int[k];
        for(int i=0;i<k;i++) line[i] = Integer.parseInt(br.readLine());
        Arrays.sort(line);

        System.out.println(binarySearch(1,line[k-1]));
    }

    private static long binarySearch(long st, long en) {
        long mid = 0,sum = 0;
        while(st<=en){
            mid = (st+en)/2;
            sum = 0;
            for(int i=0;i<k;i++){
                sum += (line[i]/mid);
            }
            if(sum<n){
                en = mid-1;
            }else {
                st = mid+1;
            }
        }
        return en;
    }
}
