import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj10090 {
    static int n;
    static int[] arr,tree;
    static HashMap<Integer,Integer>indexMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        indexMap = new HashMap<>();

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            indexMap.put(arr[i],i);
        }

        tree = new int[4*n];
        Arrays.sort(arr);

        long answer = 0;
        for(int i=n-1;i>=0;i--){
            int key = arr[i];
            int idx = indexMap.get(key);
            answer += search(0,n-1,0,idx,1);
            update(0,n-1,idx,1,1);
        }
        System.out.println(answer);

    }

    private static void update(int start, int end, int idx, int node, int diff) {
        if(start > idx || end < idx) return;
        tree[node] += diff;
        if(start != end) {
            update(start, (start + end) / 2, idx, node * 2, diff);
            update((start + end) / 2 + 1, end, idx, node * 2 + 1, diff);
        }
    }

    private static int search(int start, int end, int left, int right, int node) {
        if(start > right || end < left) return 0;
        if(left <= start && end <= right) return tree[node];
        return search(start,(start + end)/2,left,right,node*2) + search((start + end)/2+1,end,left,right,node*2+1);
    }
}
