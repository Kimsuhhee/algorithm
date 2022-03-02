import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16139 {
    static String S;
    static char alpha;
    static int q,l,r;
    static int[][] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        cnt = new int[S.length()+1][27];
        for(int i=1;i<=S.length();i++){
            char c = S.charAt(i-1);
            cnt[i][c-'a']++;
            for(int j=0;j<26;j++){
                cnt[i][j] += cnt[i-1][j];
            }
        }

        q = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            stk = new StringTokenizer(br.readLine());
            alpha = stk.nextToken().charAt(0);
            l = Integer.parseInt(stk.nextToken());
            r = Integer.parseInt(stk.nextToken());
            sb.append(cnt[r+1][alpha-'a'] - cnt[l][alpha-'a']+"\n");
        }
        System.out.print(sb);
    }
}
