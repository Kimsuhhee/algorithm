import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2011 {
    static String password;
    static int[] d = new int[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        password = br.readLine();
        d[0] = 1;
        for(int i=1;i<=password.length();i++) {
            if (password.charAt(i - 1) == '0' && i == 1) {
                break;
            }
            if (password.charAt(i - 1) >= '1' && password.charAt(i - 1) <= '9') {
                d[i] = d[i - 1] % 1000000;
            }
            if (i == 1) continue;
            int u = password.charAt(i - 1) - '0';
            int t = password.charAt(i - 2) - '0';
            int num = 10 * t + u;
            if (num >= 10 && num <= 26) { //자신과 이전의 숫자로 만든 num이 범위안에 있는 두 자리 숫자라면
                d[i] = (d[i] + d[i - 2]) % 1000000;
            }
        }
        System.out.println(d[password.length()]);
    }
}
