import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ab = br.readLine();
        StringTokenizer stk = new StringTokenizer(ab," ");

        long A = Long.parseLong(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());

        StringBuilder sb = new StringBuilder();
        if(A==B)sb.append(0).append("\n");
        else sb.append(Math.abs(A-B)-1).append("\n");

        long i,j;
        if(A<B) {
            i=A+1;
            j=B;
        }else{
            i=B+1;
            j=A;
        }

        for(;i<j;i++){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
