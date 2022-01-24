import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1717 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(stk.nextToken());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if(c==0){
                union(a,b);
            }else{
                int pa = find(a);
                int pb = find(b);

                if(pa==pb)sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
        }
        System.out.print(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b)return;
        else{
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if(a==parent[a])return a;
        return parent[a] = find(parent[a]);
    }
}
