import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String nx = br.readLine();
        StringTokenizer stk = new StringTokenizer(nx," ");

        int N = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken());

        String numbers = br.readLine();
        StringTokenizer stk1 = new StringTokenizer(numbers," ");

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(stk1.nextToken());
            if(num<X)sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
