import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3830 {
    static int N,M;
    static int[] parent;
    static long[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;

        StringBuilder sb = new StringBuilder();
        while(true) {
            stk = new StringTokenizer(br.readLine());

            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            if(N==0 && M==0)break;

            parent = new int[N+1];
            for(int i=1;i<=N;i++){
                parent[i] = i;
            }
            weight = new long[N+1];

            for(int i=0;i<M;i++){
                String[] command = br.readLine().split(" ");
                int a = Integer.parseInt(command[1]);
                int b = Integer.parseInt(command[2]);

                if(command[0].equals("!")){
                    int w = Integer.parseInt(command[3]);
                    union(a,b,w);
                }else {
                    if(find(a)!=find(b)){
                        sb.append("UNKNOWN"+"\n");
                    }else{
                        sb.append((weight[b] - weight[a])+"\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }

    private static int find(int x) {
        if(x==parent[x])return x;
        else{
            int idx = find(parent[x]);
            weight[x] += weight[parent[x]];
            return parent[x] = idx;
        }
    }

    private static void union(int a, int b, int w) {
        int pa = find(a);
        int pb = find(b);
        if(pa==pb)return;
        parent[pb] = pa;
        weight[pb] = weight[a] - weight[b] + w;
    }
}
