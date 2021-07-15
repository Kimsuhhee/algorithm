import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2156 {
    static int n;
    static int[] graph = new int[10001];
    static int[] d = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=1;i<=n;i++){
            graph[i] = Integer.parseInt(br.readLine());
        }
        dp();
        System.out.println(d[n]);
    }

    private static void dp() {
        d[1] = graph[1];
        d[2] = d[1]+graph[2];
        for(int i=3;i<n+1;i++){
            d[i] = max(d[i-2]+graph[i],d[i-1],graph[i-1]+d[i-3]+graph[i]);
        }
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }
}
