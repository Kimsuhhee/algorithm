import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20040 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        parent = new int[n];
        for(int i=1;i<n;i++){
            parent[i] = i;
        }

        for(int i=1;i<=m;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            //같은 집합에 이미 속해 있으면 사이클 발생
            if(find(a)==find(b)){
                System.out.println(i);
                System.exit(0);
            }
            union(a,b);
        }
        System.out.println(0);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u==v)return;
        parent[u] = v;
    }

    private static int find(int u) {
        if(parent[u] == u)return u;
        return parent[u] = find(parent[u]);
    }
}
