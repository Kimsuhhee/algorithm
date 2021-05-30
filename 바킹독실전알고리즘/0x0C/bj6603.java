import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj6603 {
    static int k;
    static int[]s = new int[14];
    static boolean[]visited = new boolean[14];
    static ArrayList<Integer>list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(stk.nextToken());
            if(k==0)break;
            for (int i = 0; i < k; i++) list.add(Integer.parseInt(stk.nextToken()));
            func(1, 0);
            System.out.println(sb);
        }

    }

    private static void func(int start, int n) {
        if(n==6){
            for(int i=0;i<6;i++){
                sb.append(s[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<k;i++){
            if(!visited[i]){
                s[n] = list.get(i-1);
                visited[i] = true;
                func(i+1,n+1);
                visited[i] = false;
            }
        }
    }
}
