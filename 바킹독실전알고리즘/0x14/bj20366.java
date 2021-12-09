import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20366 {
    static int[] snow;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        snow = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            snow[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(snow);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N-3;i++){
            for(int j=i+3;j<N;j++){
                int st = i+1;
                int en = j-1;
                while(st<en){
                    int gap = (snow[i]+snow[j]) - (snow[st]+snow[en]);
                    if(Math.abs(gap)<min){
                        min = Math.abs(gap);
                    }
                    if(gap>0){
                        st++;
                    }else{
                        en--;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
