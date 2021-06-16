import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj14888 {
    static int N;
    static int[] arr;
    static int[] cnt;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[4];
        
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            cnt[i] = Integer.parseInt(stk.nextToken());
        }
        
        func(arr[0],1);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    private static void func(int sum, int n) {
        if(n == N){
            list.add(sum);
         return;
        }
        for(int i=0;i<4;i++){
            if(cnt[i]>0){
                cnt[i]--;
                if(i==0){
                    func(sum+arr[n],n+1);
                }else if(i==1){
                    func(sum-arr[n],n+1);
                }else if(i==2){
                    func(sum*arr[n],n+1);
                }else{
                    func(sum/arr[n],n+1);
                }
                cnt[i]++;
            }
        }
    }
}
