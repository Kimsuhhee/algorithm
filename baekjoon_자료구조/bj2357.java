import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2357 {
    static int N,M;
    static int[] arr, minTree, maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        minTree = new int[4*N];
        maxTree = new int[4*N];
        minTreeInit(0,N-1,1);
        maxTreeInit(0,N-1,1);

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int minV = searchMin(0,N-1,1,a-1,b-1);
            int maxV = searchMax(0,N-1,1,a-1,b-1);
            System.out.println(minV+" "+maxV);
        }
    }

    private static int minTreeInit(int left, int right, int node) {
        if(left==right)return minTree[node] = arr[left];
        return minTree[node] = Math.min(minTreeInit(left, (left+right)/2,node*2),minTreeInit((left+right)/2+1,right,node*2+1));
    }
    private static int maxTreeInit(int left, int right, int node) {
        if(left==right)return maxTree[node] = arr[left];
        return maxTree[node] = Math.max(maxTreeInit(left, (left+right)/2,node*2),maxTreeInit((left+right)/2+1,right,node*2+1));
    }

    private static int searchMin(int left, int right, int node, int l, int r) {
        if(l > right || r < left)return 1000000001;
        if(left >= l && right <= r) return minTree[node];
        return Math.min(searchMin(left,(left+right)/2,node*2,l,r),searchMin((left+right)/2+1,right,node*2+1,l,r));
    }
    private static int searchMax(int left, int right, int node, int l, int r) {
        if(l > right || r < left)return -1;
        if(left >= l && right <= r) return maxTree[node];
        return Math.max(searchMax(left,(left+right)/2,node*2,l,r),searchMax((left+right)/2+1,right,node*2+1,l,r));
    }
}
