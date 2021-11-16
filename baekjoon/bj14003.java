import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj14003 {
    static int N,idx;
    static int[] arr,d;
    static Info[]info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        //인덱스와 값을 저장해두는 배열
        info = new Info[N];

        //LIS계산시 이용하는 배열
        d = new int[N];

        d[0] = arr[0];
        info[0] = new Info(0,arr[0]);
        idx = 0;

        for(int i=1;i<N;i++){
            if(d[idx]<arr[i]){
                ++idx;
                d[idx] = arr[i];
                info[i] = new Info(idx,arr[i]);
            }else {
                int l = lower_bound(arr[i]);
                d[l] = arr[i];
                info[i] = new Info(l,arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(idx+1+"\n");

        Stack<Integer>st = new Stack<>();
        int ans = idx;
        for(int i=N-1;i>=0;i--){
            if(info[i].idx==ans){
                st.add(info[i].v);
                ans--;
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop()+" ");
        }

        System.out.println(sb);
    }

    private static int lower_bound(int key) {
        int st = 0;
        int en = idx + 1;
        while(st<en){
            int mid = (st+en)/2;
            if(d[mid]>=key){
                en = mid;
            }else st = mid+1;
        }
        return en;
    }

    private static class Info {
        int idx,v;

        public Info(int idx, int v) {
            this.idx = idx;
            this.v = v;
        }
    }
}
