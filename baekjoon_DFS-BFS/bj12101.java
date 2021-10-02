import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12101 {
    static int n,k;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        dfs("1",1);
        dfs("2",2);
        dfs("3",3);
        System.out.println(-1);
    }

    private static void dfs(String s,int sum) {
        if(sum>n)return;
        if(sum==n){
            if(cnt==k) {
                System.out.println(s);
                System.exit(0);
            }
            cnt++;
            return;
        }
        for(int i=1;i<=3;i++){
            dfs(s+"+"+i,sum+i);
        }
    }
}
