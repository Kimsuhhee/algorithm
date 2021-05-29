import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
    static int n,r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nrc = br.readLine();
        StringTokenizer stk = new StringTokenizer(nrc," ");
        n = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        System.out.println(func(n,r,c));
    }

    private static int func(int n, int r, int c) {
        if(n==0)return 0;
        int half = 1<<(n-1);
        if(r<half && c<half)
            return func(n-1,r,c);
        if(r<half && c>=half)
            return half*half+func(n-1,r,c-half);
        if(r>=half && c<half)
            return 2*half*half+func(n-1,r-half,c);

        return 3*half*half+func(n-1,r-half,c-half);
    }
}
