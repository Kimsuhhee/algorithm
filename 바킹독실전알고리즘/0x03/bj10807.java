import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String numbers = br.readLine();
        StringTokenizer stk = new StringTokenizer(numbers);

        int v = Integer.parseInt(br.readLine()); //개수를세야 하는 숫자

        while(stk.hasMoreTokens()){
            if(Integer.parseInt(stk.nextToken())==v)cnt++;
        }
        System.out.println(cnt);

    }
}
