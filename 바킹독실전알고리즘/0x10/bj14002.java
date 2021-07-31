import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj14002 {
    static int N;
    static int[] arr;
    static int[] d = new int[1002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int ans = -1;
        for(int i=0;i<N;i++){
            d[i] = 1;
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(max,d[j]);
                }
            }
            d[i] = max+1;
            ans = Math.max(ans,d[i]);
        }
        System.out.println(ans);

        Stack<Integer>st = new Stack<>();
        int temp = ans;
        for(int i=N-1;i>-1;i--){
            if(temp==d[i]){
                st.push(arr[i]);
                temp--;
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
}
