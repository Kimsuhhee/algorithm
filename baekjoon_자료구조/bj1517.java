import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1517 {
    static int N;
    static int[] arr,tree;
    static HashMap<Integer,Integer>index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        index = new HashMap<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            index.put(arr[i],i);
        }

        tree = new int[N*4];
        Arrays.sort(arr);

        long swapCount = 0;
        for(int i=0;i<N;i++){
            int cur = arr[i];
            int curIdx = index.get(cur);
            swapCount += sum(0,N-1,curIdx+1,N-1, 1);
            update(0,N-1,1,curIdx,1);
            //System.out.println(swapCount);
        }
        System.out.println(swapCount);
    }

    private static void update(int left, int right, int node, int target, int diff) {
        if(target < left || target > right)return;
        tree[node] += diff;
        if(left!=right){
            update(left,(left+right)/2,node*2,target,diff);
            update((left+right)/2+1,right,node*2+1,target,diff);
        }
    }

    private static long sum(int left, int right, int l, int r, int node) {
        if(l > right || r < left) return 0;
        if(l <= left && right <= r) return tree[node];
        return sum(left,(left+right)/2,l,r,node*2) + sum((left+right)/2+1,right,l,r,node*2+1);
    }
}
