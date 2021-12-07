import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5347 {
    static int a,b,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            sb.append(lcm(a,b)+"\n");
        }
        System.out.print(sb);
    }

    private static int lcm(int a, int b) {
        return a/gcd(a,b)*b;
    }

    private static int gcd(int a, int b) {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
