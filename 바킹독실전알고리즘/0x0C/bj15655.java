import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj15655 {
    static int N,M;
    static int[]arr = new int[10];
    static ArrayList list = new ArrayList();
    static boolean[]visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        while(stk.hasMoreTokens())
            list.add(Integer.parseInt(stk.nextToken()));
        Collections.sort(list);

        func(1,0);
        System.out.println(sb);

    }

    private static void func(int start, int n) {
        if(n==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<=N;i++){
            if(!visited[i]){
                arr[n] = (int)list.get(i-1);
                visited[i] = true;
                func(i+1,n+1);
                visited[i] = false;
            }
        }
    }
}
