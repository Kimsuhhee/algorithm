import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649 {
    static int N,M;
    static int[]arr = new int[9];
    static boolean[]visited = new boolean[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        func(0);
        System.out.println(sb);

    }

    private static void func(int n) {
        if(n==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                arr[n] = i;
                visited[i] = true;
                func(n+1);
                visited[i] = false;
            }
        }
    }
}
