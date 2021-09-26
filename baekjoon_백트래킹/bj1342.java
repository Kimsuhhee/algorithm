import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1342 {
    static String s;
    static int N,cnt;
    static int[] count = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        N = s.length();
        dfs(0,"");
        System.out.println(cnt);
    }

    private static void dfs(int n,String str) {
        if(n==N){
            if(isLucky(str))cnt++;
            return;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                count[i]--;
                dfs(n+1,str+(char)(i+'a'));
                count[i]++;
            }
        }
    }

    private static boolean isLucky(String str) {
        char pre = str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==pre) return false;
            pre = str.charAt(i);
        }
        return true;
    }
}
