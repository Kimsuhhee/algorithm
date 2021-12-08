import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1735 {
    static int A1,A2,B1,B2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        A1 = Integer.parseInt(stk.nextToken());
        B1 = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        A2 = Integer.parseInt(stk.nextToken());
        B2 = Integer.parseInt(stk.nextToken());

        int bSum = lcm(B1,B2);
        int aSum = bSum/B1*A1 + bSum/B2*A2;

        //현재 구한 분수의 최대공약수 구하기
        int g = gcd(aSum,bSum);

        //최대공약수가 1이라면 기약분수임
        if(g==1) System.out.println(aSum+" "+bSum);
        else System.out.println(aSum/g+" "+bSum/g);
    }

    private static int lcm(int b1, int b2) {
        return b1/gcd(b1,b2)*b2;
    }

    private static int gcd(int b1, int b2) {
        if(b2==0)return b1;
        return gcd(b2,b1%b2);
    }
}
